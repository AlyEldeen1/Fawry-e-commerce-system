package Carts;
import Products.Product;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be positive!");
            return;
        }

        if (product.getQuantity() < quantity) {
            System.out.println("Not enough stock for " + product.getName());
            return;
        }

        if (product.isExpired()) {
            System.out.println("Cannot add expired product: " + product.getName());
            return;
        }

        items.add(new CartItem(product, quantity));
        System.out.println(" Added " + quantity + " x " + product.getName() + " to cart.");
    }
    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (CartItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    public void printCart() {
        System.out.println("Cart Contents:");
        for (CartItem item : items) {
            System.out.println(item.info());
        }
        System.out.println("Subtotal: " + getSubtotal());
    }

}
