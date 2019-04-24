import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

class Bill {

    private double numPeople = 0;
    private double totalPrice;
    private Queue<Orders> ordersList = new LinkedList<>();
    private Queue<Orders> calculated = new LinkedList<>();
    private double delivery;
    private double promo;
    private double discountedTotal = 0;
    private ArrayList<Orders> debtList = new ArrayList<>();

    public Bill(double delivery, double promo) {
        this.delivery = delivery;
        this.promo = promo;
    }

    public void add(Orders order) {
        ordersList.add(order);
        totalPrice += order.getPrice();
        numPeople++;
    }

    public void calculate() {
        double discountedPrice = totalPrice - promo;
        while (ordersList.peek() != null) {
            Orders order = ordersList.poll();
            double newPrice = (order.getPrice() / totalPrice) *
                discountedPrice + delivery / numPeople;
            discountedTotal += newPrice;
            calculated.add(new Orders(order.getName(), newPrice));
        }
    }

    public void print() {
        while (calculated.peek() != null) {
            Orders order = calculated.poll();
            System.out.println(order);
            debtList.add(order);
        }
        System.out.println("Total discounted price: " + 
                String.format("%.2f", discountedTotal));
    }
}
