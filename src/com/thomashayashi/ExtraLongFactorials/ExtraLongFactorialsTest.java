package com.thomashayashi.ExtraLongFactorials;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/extra-long-factorials/problem
 */
class ExtraLongFactorialsTest {
    @Test
    void checkExtraLongFactorial(){
        assertEquals("2432902008176640000", extraLongFactorials(20));
        assertEquals("51090942171709440000", extraLongFactorials(21));
        assertEquals("1124000727777607680000", extraLongFactorials(22));
        assertEquals("25852016738884976640000", extraLongFactorials(23));
        assertEquals("620448401733239439360000", extraLongFactorials(24));
        assertEquals("15511210043330985984000000", extraLongFactorials(25));
    }

    private String extraLongFactorials(int n) {
        BigInteger result = BigInteger.valueOf(1);

        for (long factor = 2; factor <= n; factor++)
            result = result.multiply(BigInteger.valueOf(factor));

        return String.valueOf(result);
    }
}
