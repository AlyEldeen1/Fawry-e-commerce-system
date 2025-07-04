/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Products;

public class ShippableProduct extends Product implements Shippable {
     private final double weight;
     
     public ShippableProduct (String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }
     @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String info() {
        return super.info() + " | Weight: " + weight + "kg";
    }
    
}
