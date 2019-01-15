package com.najus.supermarket

import spock.lang.Specification

import static com.najus.supermarket.SpecialOffer.BUY_ONE_GET_ONE_FREE
import static com.najus.supermarket.SpecialOffer.NO_SPEICAL_OFFER

class CheckoutServiceTest extends Specification {

    def checkoutService = new CheckoutService()

    def 'product needs a test, no?'(){
        given:
        def product = new Product('socks', 5.99f, 4, NO_SPEICAL_OFFER)

        when:
        def result = checkoutService.getPrice(product)

        then:
        result == 5.99f * 4
    }

    def 'special offer for buy one get one free'() {
        given:
        def twoProductsOneFree = new Product('shoes', 20f, 2, BUY_ONE_GET_ONE_FREE)

        when:
        def result = checkoutService.getPrice(twoProductsOneFree)

        then:
        result == 20f
    }

    def 'special offer for buy one get one free for odd items should not be applied'() {
        given:
        def twoProductsOneFree = new Product('shoes', 20f, 3, BUY_ONE_GET_ONE_FREE)

        when:
        def result = checkoutService.getPrice(twoProductsOneFree)

        then:
        result == 40f
    }
}
