public class App {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.addBeverage("tosh", 0.50);
        vm.addBeverage("atir", 0.30);
        vm.addBeverage("Beer", 1.00);

        vm.rechargeCard(12, 5.5);
        vm.rechargeCard(21, 10.0);
        vm.rechargeCard(99, 0.75);

        vm.refillColumn(1, "tosh", 1);
        vm.refillColumn(2, "Beer", 10);
        vm.refillColumn(3, "tosh", 15);
        vm.refillColumn(4, "atir", 20);

        System.out.println(vm.getPrice("tosh"));
        System.out.println(vm.getCredit(12));
        System.out.println(vm.availableCans("tosh"));

        int result = vm.sell("tosh", 12);
        System.out.println(result);
        System.out.println(vm.getCredit(12));
    }
}
