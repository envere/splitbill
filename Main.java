import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter delivery charge");
        double delivery = sc.nextDouble();

        System.out.println();
        System.out.println("Enter flat discount i.e. if $7 off $20, enter 7");
        double promo = sc.nextDouble();

        Bill bill = new Bill(delivery, promo);

        System.out.println();
        System.out.println("Enter name and price of order");
        while (sc.hasNext()) {
            String name = sc.next();
            double price = sc.nextDouble();
            bill.add(new Orders(name, price));
        }

        bill.calculate();
        System.out.println();
        System.out.println("Printing final prices");
        bill.print();
    }
}
