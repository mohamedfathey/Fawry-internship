package product;

public class ProductImpl implements Product{

    private String name;
    private double price;
    private int quantity;
    private boolean isShippable;
    private boolean isExpirable;
    private double weight;
    private boolean isExpired;


    public ProductImpl(String name, double price, int quantity, boolean isShippable, boolean isExpirable, double weight, boolean isExpired) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isShippable = isShippable;
        this.isExpirable = isExpirable;
        this.weight = weight;
        this.isExpired = isExpired;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isShippable() {
        return isShippable;
    }

    public boolean isExpirable() {
        return isExpirable;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isExpired() {
        return isExpired;
    }

    @Override
    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }


}
