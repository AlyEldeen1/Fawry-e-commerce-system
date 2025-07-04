package Services;

import Users.Customer;
import Carts.Cart;
import Carts.CartItem;
import Products.Product;
import Products.Shippable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Cannot checkout. Cart is empty.");
            return;
        }

        double subtotal = cart.getSubtotal();
        double shippingCost = 0;

        // Collect shippable items
        List<ShippingService.ShippableItem> shippableItems = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            if (product.isExpired()) {
                System.out.println("Cannot checkout. Product expired: " + product.getName());
                return;
            }

            if (product.getQuantity() < quantity) {
                System.out.println("Cannot checkout. Not enough stock for " + product.getName());
                return;
            }

            if (product instanceof Shippable) {
                Shippable shippable = (Shippable) product;
                shippableItems.add(new ShippingService.ShippableItem(
                        shippable.getName(),
                        shippable.getWeight(),
                        quantity
                ));
                shippingCost += 15; // flat rate per shippable item type (customizable)
            }
        }

        double total = subtotal + shippingCost;

        if (!customer.charge(total)) {
            System.out.println("Cannot checkout. Not enough balance.");
            return;
        }

        // Reduce product quantities
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        // Print shipment
        if (!shippableItems.isEmpty()) {
            ShippingService.ship(shippableItems);
        }

        // Print receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-12s %.0f\n", item.getQuantity(), item.getProduct().getName(),
                    item.getProduct().getPrice() * item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal         " + subtotal);
        System.out.println("Shipping         " + shippingCost);
        System.out.println("Amount           " + total);
        customer.printBalance();
    }
}
