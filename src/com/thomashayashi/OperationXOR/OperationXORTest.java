package com.thomashayashi.OperationXOR;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationXORTest {

    @Test
    void checkMultiplication(){
        assertEquals(12, solution(5, 8));

        assertEquals(2, solution(5, 9));
        assertEquals(14, solution(4, 8));
    }

    public int solution(int M, int N) {
        String firstXOR = getOperationXOR(M);
        String lastXOR = getOperationXOR(N - 1);
        String result = getBitwiseMultiplication(firstXOR, lastXOR);
        return convertToDecimal(result);
    }

    private String getOperationXOR(int value) {
        String current = convertToBinary(value);
        String next = convertToBinary(value + 1);
        return getBitwiseMultiplication(current, next);
    }

    private String getBitwiseMultiplication(String current, String next) {
        current = equalizeWithLeadingZeros(current, next.length());
        next = equalizeWithLeadingZeros(next, current.length());

        return calculateBitwiseMultiplication(current, next);
    }

    private String calculateBitwiseMultiplication(String current, String next) {
        StringBuilder sbResul = new StringBuilder();
        for(int b = 0; b < current.length(); b++)
            sbResul.append((current.charAt(b) == next.charAt(b)) ? "0" : "1");

        return sbResul.toString();
    }

    private String equalizeWithLeadingZeros(String value, int size) {
        if(value.length() >= size)
            return value;

        StringBuilder currentBuilder = new StringBuilder(value);
        while(currentBuilder.length() < size)
            currentBuilder.insert(0, "0");

        return currentBuilder.toString();
    }

    private String convertToBinary(int value) {
        return Integer.toBinaryString(value);
    }
    private int convertToDecimal(String result) { return Integer.parseInt(result, 2); }
}
