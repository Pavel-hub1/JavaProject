import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.addProduct(new Product("Lays", 100, 1));
        machine.addProduct(new Product("Mars", 70, 1));
        machine.addProduct(new Product("Twix", 70.99, 2));
        machine.addProduct(new Product("Алёнка", 90, 2));
        machine.addProduct(new Product("Колокольчик", 85, 3));
        machine.addProduct(new Perishable("Молоко Бурёнка", 85, new Date(2023, 1, 25), 2));
        machine.addProduct(new Perishable("Молоко Коровка", 85, new Date(2023, 1, 25), 1));
        machine.addProduct(new Perishable("Молоко Василёк", 85, new Date(2023, 1, 25), 3));

        System.out.println(machine);
        System.out.println("__________________________________");
        System.out.println(machine.findProduct("Молоко"));
        System.out.println(machine.findProduct("Алёнка"));
        System.out.println(machine.findProduct("Пиво"));
        System.out.println("__________________________________");
        System.out.println("продан: " + machine.sellProduct(machine.findProduct("Twix").get(0)));
        System.out.println("__________________________________");
        System.out.println(machine);


    }
}