 
package Products;

/**
 *
 * @author aliel
 */
public class Product {
    protected String name;
    protected Double price;
    protected int quantity;

    public Product(String name, Double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int amount)
    {
        if(amount<= quantity)
        {
            quantity =- amount;
        }
        else
        {
            System.out.println("Not enough stock for " + name);
        }
    }
     public boolean isExpired() {
        return false; // 
    }

    public String info() {
        return name + " - Price: " + price + " - Quantity: " + quantity;
    }
    
    
}
