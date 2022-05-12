package com.thomashayashi.MoneyExchange;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyExchangeTest {
    private final Map<String, Double> exchanges;
    public MoneyExchangeTest() {
        this.exchanges = new HashMap<>();
        this.exchanges.put("USD=BRL", 5d);
        this.exchanges.put("BRL=YEN", 25d);
        this.exchanges.put("EUR=YEN", 140d);

        this.exchanges.put("A=B", 2d);
        this.exchanges.put("B=C", 1d);
        this.exchanges.put("B=D", 3d);
        this.exchanges.put("D=C", 1d);
    }

    @Test
    void givenAnUnknownExchangeOrNonexistentExchangeShouldReturnZero() {
        assertEquals(0d, convert(1d,"USD","UNKNOWN"));
        assertEquals(0d, convert(1d,"USD","D"));
    }

    @Test
    void givenSameCurrencyShouldReturnSameValue() {
        assertEquals(2d, convert(2d,"USD","USD"));
    }

    @Test
    void givenThatDirectCurrencyExchangeExistsShouldUseThisExchangeRate() {
        assertEquals(5d, convert(1d,"USD","BRL"));
    }

    @Test
    void givenThatReverseCurrencyExchangeExistsButNoDirectConversionShouldReturnTheReverseExchangeRate(){
        assertEquals(0.2d, convert(1d,"BRL","USD"));
    }

    @Test
    void givenThatChainOfExchangesToTheDestinyCurrencyExistShouldReturnWithTheAccumulatedExchangeRates() {
        assertEquals(125d, convert(1d,"USD","YEN"));
    }

    @Test
    void givenThatChainOfExchangesToTheDestinyCurrencyExistWithAReverseExchangeShouldReturnWithTheAccumulatedExchangeRates() {
        assertEquals(0.89d, convert(1d,"USD","EUR"), 0.01);
    }

    @Test
    void givenThatThereAreMoreThanOneWayToConvertShouldReturnTheBiggestValue() {
        // A -> B -> C = 2
        // A -> B -> D -> C = 6
        assertEquals(6d, convert(1d,"A","C"));
    }

    public Double convert(Double amount, String fromCurrency, String toCurrency) {
        return amount * getConversionRate(fromCurrency, toCurrency);
    }

    private Double getConversionRate(String fromCurrency, String toCurrency) {
        if(fromCurrency.equals(toCurrency))
            return 1d;

        return calculateConversionRates(fromCurrency, toCurrency);
    }

    private double calculateConversionRates(String fromCurrency, String toCurrency) {
        List<Double> exchangeRates = new ArrayList<>();
        exchangeRates.add(getDirectExchange(getExchangeKey(fromCurrency, toCurrency)));
        exchangeRates.add(getReverseExchange(getExchangeKey(toCurrency, fromCurrency)));
        exchangeRates.add(getFromChainExchange(fromCurrency, toCurrency));
        return getBestExchangeRate(exchangeRates);
    }

    private Double getDirectExchange(String keyExchange) {
        return getExchangeRate(keyExchange);
    }

    private Double getReverseExchange(String keyExchange) {
        Double exchangeRate = getDirectExchange(keyExchange);
        return exchangeRate != null ? 1/exchangeRate : null;
    }

    private Double getFromChainExchange(String fromCurrency, String toCurrency) {
        Double bestExchange = null;
        for(String pairExchange : getAllExchangeRates()) {
            if(pairExchange.startsWith(fromCurrency + "="))
                bestExchange = getAccumulatedChainExchange(toCurrency, pairExchange);
        }
        return bestExchange;
    }

    private Double getAccumulatedChainExchange(String toCurrency, String conversionPair) {
        Double exchangeRate = getExchangeRate(conversionPair);
        String newFromCurrency = conversionPair.split("=", 2)[1];
        return exchangeRate * getConversionRate(newFromCurrency, toCurrency);
    }

    private double getBestExchangeRate(List<Double> exchangeRates) {
        Double bestExchangeRate = null;
        for(Double exchangeRate : exchangeRates) {
            if(exchangeRate != null)
                bestExchangeRate = getBetterExchange(bestExchangeRate, exchangeRate);
        }

        return bestExchangeRate == null ? 0d : bestExchangeRate;
    }

    private String getExchangeKey(String fromCurrency, String toCurrency) {
        return fromCurrency + "=" + toCurrency;
    }

    private Set<String> getAllExchangeRates() {
        return this.exchanges.keySet();
    }

    private Double getExchangeRate(String keyExchange) {
        return this.exchanges.getOrDefault(keyExchange, null);
    }

    private Double getBetterExchange(Double currentValue, Double newValue) {
        return currentValue == null || currentValue < newValue ? newValue : currentValue;
    }
}
