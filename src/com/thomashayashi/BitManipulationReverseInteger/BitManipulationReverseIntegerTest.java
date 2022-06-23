package com.thomashayashi.BitManipulationReverseInteger;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class BitManipulationReverseIntegerTest {
    @Test
    void checkIndex(){
        assertEquals(321, reverse(123));
        assertEquals(-321, reverse(-123));
    }

    private int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int rem= x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && rem> 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && rem< -8)) return 0;
            rev = rev * 10 + rem;
        }
        return rev;
    }
}
