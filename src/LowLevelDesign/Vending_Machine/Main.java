package LowLevelDesign.Vending_Machine;

import LowLevelDesign.Vending_Machine.Enum.Coin;

public class Main {

    public static void main(String[] args) {

        Product coke =
                new Product("1","Coke",40);

        Shelf s1 = new Shelf(1);

        s1.loadProduct(coke,5);

        VendingMachine vm =
                new VendingMachine();

        vm.getInventory().addShelf(s1);

        vm.insertCoin(Coin.TEN);
        vm.insertCoin(Coin.TEN);
        vm.insertCoin(Coin.TEN);
        vm.insertCoin(Coin.TEN);

        vm.selectProduct(1);

        vm.dispense();
    }
}
