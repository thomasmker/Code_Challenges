package com.thomashayashi.Delivery;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeliveryTest {
    @Test
    void checkDeliveries(){
        assertEquals(List.of(Arrays.asList(1, -1)), deliveryPlan(Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4),Arrays.asList(1,-1)),1));
        assertEquals(Arrays.asList(Arrays.asList(1,-1),Arrays.asList(1,2)), deliveryPlan(Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,4),Arrays.asList(1,-1)),2));
    }

    static class Point {
        int x;
        int y;
        double distance;

        Point(int x, int y, double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private List<List<Integer>> deliveryPlan(List<List<Integer>> allLocations, int numDeliveries) {
        List<Point> pointsList = new ArrayList<>();
        for(List<Integer> location : allLocations) {
            int x = location.get(0);
            int y = location.get(1);
            double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            pointsList.add(new Point(x, y, distance));
        }

        pointsList.sort((p1, p2) -> {
            if (p1.distance == p2.distance) {
                return p1.x - p2.x;
            } else
                return Double.compare(p1.distance, p2.distance);
        });

        List<List<Integer>> deliveries = new ArrayList<>();
        for(int i = 0; i < numDeliveries; i++) {
            Point p = pointsList.get(i);
            deliveries.add(Arrays.asList(p.x, p.y));
        }
        return deliveries;
    }
}
