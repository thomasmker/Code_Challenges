package com.thomashayashi;

import java.util.HashSet;
import java.util.List;

public class SockMerchant {

    public static int calculatePairs(List<Integer> colorsEachSock) {
        int number_of_pairs = 0;

        HashSet<Integer> matching_socks = new HashSet<>();
        for(Integer sockColor : colorsEachSock) {
            if(matching_socks.contains(sockColor)) {
                number_of_pairs++;
                matching_socks.remove(sockColor);
            } else {
                matching_socks.add(sockColor);
            }
        }

        return number_of_pairs;
    }
}
