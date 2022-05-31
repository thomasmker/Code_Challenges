package com.thomashayashi.DecimalToRoman;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecimalToRomanTest {
    @Test
    void checkDecimalToRomanConversion(){
        assertEquals("I", convertToRoman(1));
        assertEquals("II", convertToRoman(2));
        assertEquals("III", convertToRoman(3));
        assertEquals("IV", convertToRoman(4));
        assertEquals("V", convertToRoman(5));
        assertEquals("VI", convertToRoman(6));
        assertEquals("IX", convertToRoman(9));
        assertEquals("XIX", convertToRoman(19));
        assertEquals("XXXVIII", convertToRoman(38));
        assertEquals("XLIX", convertToRoman(49));
        assertEquals("CLX", convertToRoman(160));
        assertEquals("CCXLVI", convertToRoman(246));
        assertEquals("CD", convertToRoman(400));
        assertEquals("DCCLXXXIX", convertToRoman(789));
        assertEquals("DCCCLXXXVIII", convertToRoman(888));
        assertEquals("CMXCIX", convertToRoman(999));
        assertEquals("MCMXLIV", convertToRoman(1944));
        assertEquals("MMXIV", convertToRoman(2014));
        assertEquals("MMMCMXCIX", convertToRoman(3999));
        assertEquals("MMMMCDXLIV", convertToRoman(4444));
        assertEquals("MMMMDCCCLXXXVIII", convertToRoman(4888));
        assertEquals("MMMMCMXCIX", convertToRoman(4999));
    }

    private String convertToRoman(int arabic) {
        return new DecimalToRoman().convert(arabic);
    }

    public static class DecimalToRoman {
        private Map<Integer, String> decimalToRomanMap;
        private int decimalRemaining;
        private final StringBuilder convertedRoman;

        public DecimalToRoman() {
            createDecimalToRomanMap();
            convertedRoman = new StringBuilder();
        }

        private void createDecimalToRomanMap() {
            decimalToRomanMap = new LinkedHashMap<>();
            decimalToRomanMap.put(1000, "M");
            decimalToRomanMap.put(900, "CM");
            decimalToRomanMap.put(500, "D");
            decimalToRomanMap.put(400, "CD");
            decimalToRomanMap.put(100, "C");
            decimalToRomanMap.put(90, "XC");
            decimalToRomanMap.put(50, "L");
            decimalToRomanMap.put(40, "XL");
            decimalToRomanMap.put(10, "X");
            decimalToRomanMap.put(9, "IX");
            decimalToRomanMap.put(5, "V");
            decimalToRomanMap.put(4, "IV");
            decimalToRomanMap.put(1, "I");
        }

        public String convert(int decimal) {
            decimalRemaining = decimal;
            for(Integer value : decimalToRomanMap.keySet())
                appendRomanLetters(value);
            return convertedRoman.toString();
        }

        private void appendRomanLetters(int value) {
            while (decimalRemaining >= value) {
                appendRomanNumeral(value);
                decimalRemaining -= value;
            }
        }

        private void appendRomanNumeral(int value) {
            convertedRoman.append(decimalToRomanMap.get(value));
        }
    }
}
