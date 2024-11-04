package card;

import product.ProductImpl;

import java.util.ArrayList;
import java.util.List;

public class CardImpl implements Card {

    private List<CartItemImpl> items = new ArrayList<>();

    @Override
    public void add(ProductImpl product, int quantity) throws Exception {
        if (quantity > product.getQuantity()) {
            System.out.println("Error: " + product.getName() + " out of stock.");
        } else if (product.isExpired()) {
            System.out.println("Error: " + product.getName() + " is expired.");
        } else {
            items.add(new CartItemImpl(product, quantity));
        }
    }

    public List<CartItemImpl> getItems() {
        return items;
    }

    @Override
    public double calculateSubtotal() {
        double subtotal = 0;
        for (CartItemImpl item : items) {
            if (!item.getProduct().isExpired() && item.getProduct().isShippable()) {
                subtotal += item.getTotalPrice();
            }
        }
        return subtotal;
    }

    @Override
    public List<ProductImpl> getShippableItems() {
        List<ProductImpl> shippables = new ArrayList<>();
        for (CartItemImpl item : items) {
            if (!item.getProduct().isExpired() && item.getProduct().isShippable()) {
                shippables.add(item.getProduct());
            }
        }
        return shippables;
    }
}
