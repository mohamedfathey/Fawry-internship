package card;

import product.ProductImpl;

import java.util.List;

public interface Card {

    public void add(ProductImpl product, int quantity)throws Exception;
    public double calculateSubtotal();
    public List<ProductImpl> getShippableItems();
}
