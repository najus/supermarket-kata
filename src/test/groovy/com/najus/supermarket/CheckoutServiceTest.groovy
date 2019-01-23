package com.najus.supermarket

import spock.lang.Specification
import spock.lang.Unroll

class CheckoutServiceTest extends Specification {

    Integer price(String goods){
        def RULES = makePricingRules()
        def co = new CheckOut(RULES)
        goods.toCharArray().each {good ->
            co.scan(good.toString())
        }
        return co.total()
    }

    def makePricingRules() {
        List<PricingRule> rulesList = new ArrayList<>()
        PricingRule rulesForA = new PricingRule(item: 'A', unitPrice: 50, specialPrice: [3 : 130])
        PricingRule rulesForB = new PricingRule(item: 'B', unitPrice: 30, specialPrice: [2 : 45])
        PricingRule rulesForC = new PricingRule(item: 'C', unitPrice: 20)
        PricingRule rulesForD = new PricingRule(item: 'D', unitPrice: 15)

        rulesList.addAll(rulesForA, rulesForB, rulesForC, rulesForD)
        rulesList
    }

    @Unroll
    def 'test totals for #goods should cost #actualPrice'(){
        expect:
        assert price(goods) == actualPrice

        where:
        goods    | actualPrice
        ""       | 0
        "A"      | 50
        "AB"     | 80
        "CDBA"   | 115

        "AA"     | 100
        "AAA"    | 130
        "AAAA"   | 180
        "AAAAA"  | 230
        "AAAAAA" | 260
        "AAAB"   | 160
        "AAABB"  | 175
        "AAABBD" | 190
        "DABABA" | 190
    }

    def 'test incremental'() {
        when:
        def RULES = makePricingRules()
        def co = new CheckOut(RULES)

        then:
        assert co.total() == 0

        and:
        co.scan("A")

        then:
        assert co.total() == 50

        and:
        co.scan("B")

        then:
        assert co.total() == 80

        and:
        co.scan("A")

        then:
        assert co.total() == 130

        and:
        co.scan("A")

        then:
        assert co.total() == 160

        and:
        co.scan("B")

        then:
        assert co.total() == 175
    }
}
