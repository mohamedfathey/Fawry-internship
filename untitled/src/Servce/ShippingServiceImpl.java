package Servce;

import product.ProductImpl;

import java.util.List;

public class ShippingServiceImpl {

    public static double calculateShipping(List<ProductImpl> shippables) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (ProductImpl product : shippables) {
            if (!product.isExpired() && product.isShippable()) {
                System.out.println("Item: " + product.getName() + " ==> Weight: " + (product.getWeight() * 1000) + " g");
                totalWeight += product.getWeight();
            }
        }
        System.out.println("Total package weight: " + totalWeight + "kg");
        return totalWeight * 1000 * 0.01;
    }
}
