package Servce;

import Servce.CheckoutService;
import Servce.ShippingServiceImpl;
import card.CardImpl;
import card.CartItemImpl;
import customer.CostumerImpl;
import product.ProductImpl;

import java.util.List;

public class CheckoutServiceImpl implements CheckoutService {
    @Override
    public void checkout(CostumerImpl customer, CardImpl cart) throws Exception {
        if (cart.getItems().isEmpty()) {
            throw new Exception("Error: Cart is empty.");
        }

        double subtotal = cart.calculateSubtotal();
        List<ProductImpl>shippables = cart.getShippableItems();
        double shippingCost = ShippingServiceImpl.calculateShipping(shippables);
        double totalAmount = subtotal + shippingCost;

        if (customer.getBalance() < totalAmount) {
            throw new Exception("Error: Insufficient balance for " + customer.getName());
        }

        // Deduct balance and reduce stock
        customer.deductBalance(totalAmount);
        for (CartItemImpl item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        // Print receipt
        System.out.println("----------------------------------------------------------------");
        System.out.println("** Checkout receipt **");
        for (CartItemImpl item : cart.getItems()) {
            if (!item.getProduct().isExpired() && item.getProduct().isShippable()) {
                System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + "           " + item.getProduct().getPrice());
            }
        }
        System.out.println("Subtotal: " + subtotal);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Shipping Cost: " + shippingCost);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Remaining Balance: " + customer.getBalance());
    }
}
