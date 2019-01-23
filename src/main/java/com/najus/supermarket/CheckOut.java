package com.najus.supermarket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class CheckOut {

    private List<PricingRule> pricingRules;
    private Map<String, Integer> totalIndividualQuantity = new HashMap<>();

    public CheckOut(List<PricingRule> pricingRules) {
        this.pricingRules = pricingRules;
    }

    public void scan(String good){
        if(totalIndividualQuantity.containsKey(good)){
            totalIndividualQuantity.put(good, totalIndividualQuantity.get(good) + 1);
        } else {
            totalIndividualQuantity.put(good, 1);
        }
    }

    public Integer total(){
        AtomicInteger totalPrice = new AtomicInteger();
        totalIndividualQuantity.forEach((key, value) -> {
            Optional<PricingRule> matchingRule = pricingRules
                    .stream()
                    .filter(rules -> rules.getItem().equals(key))
                    .findFirst();
            if (matchingRule.isPresent()) {
                Map<Integer, Integer> specialOffer = matchingRule.get().getSpecialPrice();
                if(specialOffer != null) {
                    int specialQuantity = matchingRule.get().getSpecialPrice().entrySet().stream().findFirst().get().getKey();
                    int specialPrice = matchingRule.get().getSpecialPrice().entrySet().stream().findFirst().get().getValue();
                    totalPrice.addAndGet((value / specialQuantity) * specialPrice + (value % specialQuantity) * matchingRule.get().getUnitPrice());
                } else {
                    totalPrice.addAndGet(value * matchingRule.get().getUnitPrice());
                }
            }
        });
        return totalPrice.get();
    }
}
