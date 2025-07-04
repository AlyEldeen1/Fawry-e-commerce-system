package Carts;
import Products.Product;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity ) {
        this.quantity = quantity;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
    public String info() {
        return quantity + " x " + product.getName() + " = " + getTotalPrice();
    }
}
