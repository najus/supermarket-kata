package com.najus.supermarket;

public class CheckoutService {

    public float getPrice(Product product){
        float initialPrice = product.getPrice() * product.getUnit();

        if(product.getSpecialOffer() == SpecialOffer.BUY_ONE_GET_ONE_FREE){
            int units = product.getUnit();
            int numberOfFreeItems = units / 2;
            return product.getPrice() * (units - numberOfFreeItems);
        }
        return initialPrice;
    }
}
