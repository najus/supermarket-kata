package com.najus.supermarket;

public class CheckoutService {

    public float getPrice(Product product){
        return product.getPrice() * product.getUnit();
    }
}
