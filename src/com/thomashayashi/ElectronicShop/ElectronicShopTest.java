package com.thomashayashi.ElectronicShop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/electronics-shop/problem
 */
public class ElectronicShopTest {
    @Test
    void checkMostExpensivePurchase(){
        assertEquals(-1, getMoneySpent(new int[]{10}, new int[]{1}, 10));
        assertEquals(9, getMoneySpent(new int[]{3,1}, new int[]{5,2,8}, 10));
        assertEquals(58, getMoneySpent(new int[]{40,50,60}, new int[]{5,8,12}, 60));
    }

    private int getMoneySpent(int[] keyboards, int[] drives, int b) {
        List<Integer> lstKeyboards = convertToList(keyboards);
        List<Integer> lstDrives = convertToList(drives);
        Collections.sort(lstKeyboards);
        Collections.sort(lstDrives);

        int bestDeal = -1;
        for(int i = lstKeyboards.size() - 1, j = 0; i >= 0; i--){
            for(; j < lstDrives.size(); j++){
                int sumPurchase = lstKeyboards.get(i)+lstDrives.get(j);
                if(sumPurchase > b) break;
                if(sumPurchase > bestDeal)
                    bestDeal = sumPurchase;
            }
        }

        return bestDeal;
    }

    private List<Integer> convertToList(int[] arr) {
        List<Integer> lst = new ArrayList<>(arr.length);
        for (int i : arr)
            lst.add(i);
        return lst;
    }
}
