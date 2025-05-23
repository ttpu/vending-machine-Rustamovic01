import java.util.*;

public class VendingMachine {
    private Map<String, Double> beverages = new HashMap<>();
    private Map<Integer, Double> cards = new HashMap<>();
    private String[] columnNames = new String[4];
    private int[] columnCans = new int[4];

    public void addBeverage(String name, double price) {
        beverages.put(name, price);
    }

    public double getPrice(String name) {
        return beverages.getOrDefault(name, -1.0);
    }

    public void rechargeCard(int cardId, double amount) {
        cards.put(cardId, cards.getOrDefault(cardId, 0.0) + amount);
    }

    public double getCredit(int cardId) {
        return cards.getOrDefault(cardId, -1.0);
    }

    public void refillColumn(int columnNumber, String beverageName, int cans) {
        if (columnNumber < 1 || columnNumber > 4) return;
        columnNames[columnNumber - 1] = beverageName;
        columnCans[columnNumber - 1] = cans;
    }

    public int availableCans(String beverageName) {
        int total = 0;
        for (int i = 0; i < 4; i++) {
            if (beverageName.equals(columnNames[i])) {
                total += columnCans[i];
            }
        }
        return total;
    }

    public int sell(String beverageName, int cardId) {
        if (!beverages.containsKey(beverageName) || !cards.containsKey(cardId)) return -1;
        double price = beverages.get(beverageName);
        double credit = cards.get(cardId);
        if (credit < price) return -1;
        for (int i = 0; i < 4; i++) {
            if (beverageName.equals(columnNames[i]) && columnCans[i] > 0) {
                columnCans[i]--;
                cards.put(cardId, credit - price);
                return i + 1;
            }
        }
        return -1;
    }
}
