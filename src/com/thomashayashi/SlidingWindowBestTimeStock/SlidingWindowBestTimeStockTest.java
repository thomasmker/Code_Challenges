package com.thomashayashi.SlidingWindowBestTimeStock;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
class SlidingWindowBestTimeStockTest {
    @Test
    void checkPrices(){
        assertEquals(0, maxProfit(Collections.emptyList()));
        assertEquals(1, maxProfit(Arrays.asList(0,1)));
        assertEquals(5, maxProfit(Arrays.asList(7,1,5,3,6,4)));
    }

    private int maxProfit(List<Integer> prices) {
        int sell = 0;
        int buy = Integer.MAX_VALUE;

        for (int price: prices) {
            if (price < buy)
                buy = price;
            else
                sell = Math.max(sell, price - buy);
        }

        return sell;
    }
}
