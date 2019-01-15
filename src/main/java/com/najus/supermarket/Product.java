package com.najus.supermarket;

public class Product {
    private String name;
    private float price;
    private int unit;
    private SpecialOffer specialOffer;

    public Product(String name, float price, int unit, SpecialOffer specialOffer){
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.specialOffer = specialOffer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public SpecialOffer getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(SpecialOffer specialOffer) {
        this.specialOffer = specialOffer;
    }
}
