package Services;

import Products.Shippable;
import java.util.List;

public class ShippingService {

    public static void ship(List<ShippableItem> items) {
        if (items.isEmpty()) {
            System.out.println("No items to ship.");
            return;
        }

        System.out.println("** Shipment notice **");

        double totalWeight = 0;

        for (ShippableItem item : items) {
            double itemWeight = item.getWeight() * item.getQuantity();
            totalWeight += itemWeight;
            System.out.printf("%dx %-12s %.0fg\n", item.getQuantity(), item.getName(), itemWeight * 1000);
        }

        System.out.printf("Total package weight: %.2f kg\n\n", totalWeight);
    }

    // Inner class to bundle name, weight, and quantity
    public static class ShippableItem implements Shippable {
        private final String name;
        private final double weight;
        private final int quantity;

        public ShippableItem(String name, double weight, int quantity) {
            this.name = name;
            this.weight = weight;
            this.quantity = quantity;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getWeight() {
            return weight;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}
