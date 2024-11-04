package Servce;

import card.CardImpl;
import customer.CostumerImpl;

public interface CheckoutService {
    public   void checkout(CostumerImpl customer, CardImpl cart) throws Exception;
}
