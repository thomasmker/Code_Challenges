package com.thomashayashi.MoneyExchange;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyExchangeTest {
    private final Map<String, Double> exchanges;
    public MoneyExchangeTest() {
        this.exchanges = new HashMap<>();
        this.exchanges.put("USD=BRL", 5d);
        this.exchanges.put("BRL=YEN", 25d);
        this.exchanges.put("EUR=YEN", 140d);
    }

    @Test
    void checkMoneyConversion(){
        // Same currency
        assertEquals(2d, convert(2d,"USD","USD"));
        // One conversion
        assertEquals(5d, convert(1d,"USD","BRL"));
        // Reverse conversion
        assertEquals(0.2d, convert(1d,"BRL","USD"));
        // One direct chain (USD -> BRL -> YEN)
        assertEquals(125d, convert(1d,"USD","YEN"));
        // One chain + one reverse (USD -> BRL -> YEN -> 1/EUR)
        assertEquals(0.89d, convert(1d,"USD","EUR"), 0.01);
    }

    private Double convert(Double amount, String fromCurrency, String toCurrency) {
        return amount * conversion(fromCurrency, toCurrency);
    }

    private Double conversion(String fromCurrency, String toCurrency) {
        if(fromCurrency.equals(toCurrency))
            return 1d;

        String keyConversion = fromCurrency + "=" + toCurrency;
        if(this.exchanges.containsKey(keyConversion))
            return this.exchanges.get(keyConversion);

        String reverseConversion = toCurrency + "=" + fromCurrency;
        if(this.exchanges.containsKey(reverseConversion))
            return 1 / this.exchanges.get(reverseConversion);

        for(String conversionPair : this.exchanges.keySet()) {
            Double exchangeRate = this.exchanges.get(conversionPair);
            String[] newFrom = conversionPair.split("=",2);

            if(conversionPair.startsWith(fromCurrency))
                return exchangeRate * conversion(newFrom[1], toCurrency);
            else if (conversionPair.endsWith(fromCurrency))
                return exchangeRate * conversion(newFrom[0], toCurrency);
        }

        return 0d;
    }
}
