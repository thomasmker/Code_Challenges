package com.thomashayashi.KangarooShow;

class KangarooShow {

    public static String willTheyMeet(int x1, int v1, int x2, int v2) {
        String response = "NO";
        boolean canCatchUp = (v2 < v1);
        if(canCatchUp) {
            // x1 + (hops * v1) = x2 + (hops * v2)
            // x1 - x2 = (hops * v2) - (hops * v1)
            // x1 - x2 = hops * (v2 -v1)
            // (x1 - x2) / (v2 -v1) = hops
            boolean willIntersectOnLand = (x1 - x2) % (v2 - v1) == 0;
            if(willIntersectOnLand) {
                response = "YES";
            }
        }

        return response;
//        int p1 = x1;
//        int p2 = x2;
//        while(true) {
//            if(p1 == p2)
//                return "YES";
//            if(p1 > p2)
//                return "NO";
//
//            p1 += v1;
//            p2 += v2;
//        }
    }
}
