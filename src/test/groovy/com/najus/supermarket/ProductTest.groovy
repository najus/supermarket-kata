package com.najus.supermarket

import spock.lang.Specification

class ProductTest extends Specification {
    def checkoutService

    def 'product needs a test, no?'(){
        given:
        def product = new Product('socks', 5.99f, 4)
        checkoutService = new CheckoutService()

        when:
        def result = checkoutService.getPrice(product)

        then:
        result == 5.99f * 4
    }
}
