package com.thomashayashi.SalesByMatch;

import java.util.HashSet;
import java.util.List;

class SockMerchant {

    public static int calculatePairs(List<Integer> colorsEachSock) {
        HashSet<Integer> matching_socks = new HashSet<>();

        int numberOfPairs = 0;
        for(Integer sockColor : colorsEachSock) {
            if(matching_socks.contains(sockColor)) {
                numberOfPairs++;
                matching_socks.remove(sockColor);
            } else {
                matching_socks.add(sockColor);
            }
        }

        return numberOfPairs;
    }
}
