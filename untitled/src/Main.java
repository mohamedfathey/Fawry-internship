import Servce.CheckoutService;
import Servce.CheckoutServiceImpl;
import card.CardImpl;
import customer.CostumerImpl;
import product.ProductImpl;

public class Main {
    public static void main(String[] args) {
        try {
            ProductImpl cheese = new ProductImpl("Cheese", 100, 10, true, false,5 , false);
            ProductImpl biscuit = new ProductImpl("Biscuit", 50, 5, true, true, 6, true);
            ProductImpl tv = new ProductImpl("TV", 2000, 2, false, true, 6, false);
            ProductImpl scratchCard = new ProductImpl("Mobile Scratch Card", 20, 50, true, true, 1, false);

            CostumerImpl customer = new CostumerImpl("mohamed", 5000);

            CardImpl cart = new CardImpl();

            cart.add(cheese, 2);
            cart.add(biscuit, 1);
            cart.add(tv, 1);
            cart.add(scratchCard, 1);

            CheckoutServiceImpl checkoutService = new CheckoutServiceImpl() ;
           checkoutService.checkout(customer,cart);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}