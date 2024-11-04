package card;

import product.Product;
import product.ProductImpl;

public class CartItemImpl implements CartItem{
    private ProductImpl product;
    private int quantity;

    public CartItemImpl(ProductImpl product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ProductImpl getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public double getTotalPrice() {
        return product.getPrice() * quantity ;
    }
}
