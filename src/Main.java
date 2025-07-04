import Users.Customer;
import Carts.Cart;
import Products.*;
import Services.CheckoutService;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Customer c5 = new Customer("Layla", 500);
        Cart cart5 = new Cart();

        Product ebook = new Product("E-Book", 100.0, 5);
        cart5.add(ebook, 3);

        CheckoutService.checkout(c5, cart5);

    }
}
