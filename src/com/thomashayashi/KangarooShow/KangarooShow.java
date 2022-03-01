package com.thomashayashi.KangarooShow;

public class KangarooShow {

    public static String willTheyMeet(int x1, int v1, int x2, int v2) {
        String response = "NO";
        boolean canCatchUp = (v2 < v1);
        if(canCatchUp) {
            boolean willIntersectOnLand = (x1 - x2) % (v2 - v1) == 0;
            if(willIntersectOnLand) {
                response = "YES";
            }
        }

        return response;
//        int positionKangaroo1 = x1;
//        int positionKangaroo2 = x2;
//
//        int whoIsFirst = x1 > x2 ? 1 : 2;
//        while(true) {
//            positionKangaroo1 += v1;
//            positionKangaroo2 += v2;
//
//            if(positionKangaroo1 == positionKangaroo2)
//                return "YES";
//
//            if(whoIsFirst == 1 && positionKangaroo2 > positionKangaroo1) {
//                return "NO";
//            }
//            if(whoIsFirst == 2 && positionKangaroo1 > positionKangaroo2) {
//                return "NO";
//            }
//        }
    }
}
