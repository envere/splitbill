import java.util.LinkedList;
import java.util.Queue;

class Bill {

    private double numPeople = 0;
    private double totalPrice;
    private Queue<Orders> ordersList = new LinkedList<>();
    private Queue<Orders> calculated = new LinkedList<>();
    private double delivery;
    private double promo;

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
            calculated.add(new Orders(order.getName(), newPrice));
        }
    }

    public void print() {
        while (calculated.peek() != null) {
            System.out.println(calculated.poll());
        }
    }
}
