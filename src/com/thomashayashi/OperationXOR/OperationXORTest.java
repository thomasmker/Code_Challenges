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
        int firstXOR = getXOROperation(M);
        int lastXOR = getXOROperation(N - 1);
        return getBitwiseMultiplication(ConvertToBinary(firstXOR), ConvertToBinary(lastXOR));
    }

    private int getXOROperation(int value) {
        String current = ConvertToBinary(value);
        String next = ConvertToBinary(value + 1);
        return getBitwiseMultiplication(current, next);
    }

    private String ConvertToBinary(int value) {
        return Integer.toBinaryString(value);
    }

    private int getBitwiseMultiplication(String current, String next) {
        current = AddLeadingZeros(current, next);
        next = AddLeadingZeros(next, current);

        StringBuilder sbResul = new StringBuilder();
        for(int b = 0; b < current.length(); b++)
            sbResul.append((current.charAt(b) == next.charAt(b)) ? "0" : "1");

        return Integer.parseInt(sbResul.toString(),2);
    }

    private String AddLeadingZeros(String current, String next) {
        if(current.length() == next.length())
            return current;

        StringBuilder currentBuilder = new StringBuilder(current);
        while(currentBuilder.length() < next.length())
            currentBuilder.insert(0, "0");

        return currentBuilder.toString();
    }
}
