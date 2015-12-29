import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BurgerOrder {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int total = n;
		ArrayList<Order> orders = new ArrayList<>();
		while (n > 0) {
			int t = s.nextInt();
			int p = s.nextInt();
			Order o = new Order((total - n + 1), t, p);
			orders.add(o);
			n--;
		}

		Collections.sort(orders);

		for (Order o : orders) {
			System.out.print(o.getOrderId() + " ");
		}
	}
}

class Order implements Comparable<Order> {
	int orderId;
	int orderTime;
	int orderProcessingTime;

	Order(int i, int o, int p) {
		orderId = i;
		orderTime = o;
		orderProcessingTime = p;
	}

	int getOredeDeliveryTime() {
		return orderTime + orderProcessingTime;
	}

	int getOrderId() {
		return orderId;
	}

	@Override
	public int compareTo(Order o) {

		return Integer.compare(this.getOredeDeliveryTime(),
				o.getOredeDeliveryTime());

	}
}