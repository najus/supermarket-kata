package com.najus.supermarket;

import java.util.Map;

public class PricingRule {
    private String item;
    private Integer unitPrice;
    private Map<Integer, Integer> specialPrice;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Map<Integer, Integer> getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Map<Integer, Integer> specialPrice) {
        this.specialPrice = specialPrice;
    }
}
