package com.thomashayashi.RomanToDecimal;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanToDecimalTest {
    @Test
    void checkRomanToDecimalConversion(){
        assertEquals(1, RomanToDecimal("I"));
        assertEquals(2, RomanToDecimal("II"));
        assertEquals(3, RomanToDecimal("III"));
        assertEquals(4, RomanToDecimal("IV"));
        assertEquals(5, RomanToDecimal("V"));
        assertEquals(6, RomanToDecimal("VI"));
        assertEquals(9, RomanToDecimal("IX"));
        assertEquals(19, RomanToDecimal("XIX"));
        assertEquals(38, RomanToDecimal("XXXVIII"));
        assertEquals(49, RomanToDecimal("XLIX"));
        assertEquals(160, RomanToDecimal("CLX"));
        assertEquals(246, RomanToDecimal("CCXLVI"));
        assertEquals(400, RomanToDecimal("CD"));
        assertEquals(789, RomanToDecimal("DCCLXXXIX"));
        assertEquals(888, RomanToDecimal("DCCCLXXXVIII"));
        assertEquals(999, RomanToDecimal("CMXCIX"));
        assertEquals(1944, RomanToDecimal("MCMXLIV"));
        assertEquals(2014, RomanToDecimal("MMXIV"));
        assertEquals(3999, RomanToDecimal("MMMCMXCIX"));
        assertEquals(4444, RomanToDecimal("MMMMCDXLIV"));
        assertEquals(4888, RomanToDecimal("MMMMDCCCLXXXVIII"));
        assertEquals(4999, RomanToDecimal("MMMMCMXCIX"));
    }
    
    private int RomanToDecimal(String romanNumber) {
        return new RomanToDecimal().convert(romanNumber);
    }

    public static class RomanToDecimal {
        private Map<Character, Integer> romanToDecimalMap;

        public RomanToDecimal() {
            createRomToDecimalMap();
        }

        private void createRomToDecimalMap() {
            romanToDecimalMap = new HashMap<>();
            romanToDecimalMap.put('M', 1000);
            romanToDecimalMap.put('D', 500);
            romanToDecimalMap.put('C', 100);
            romanToDecimalMap.put('L', 50);
            romanToDecimalMap.put('X', 10);
            romanToDecimalMap.put('V', 5);
            romanToDecimalMap.put('I',1);
        }

        private int convert(String romanNumber) {
            if(romanNumber.length() == 0)
                return 0;
            int romanDecimal = getDecimalFromSingleLetter(romanNumber);
            return convert(romanNumber.substring(1)) + romanDecimal;
        }

        private int getDecimalFromSingleLetter(String romanNumber) {
            int num = romanToDecimalMap.get(romanNumber.charAt(0));
            return isRomanPrefix(romanNumber, num) ? num * -1 : num;
        }

        private boolean isRomanPrefix(String romanNumber, int num) {
            return (romanNumber.length() > 1 && romanToDecimalMap.get(romanNumber.charAt(1)) > num);
        }
    }
}


