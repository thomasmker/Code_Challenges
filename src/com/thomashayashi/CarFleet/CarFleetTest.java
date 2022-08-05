package com.thomashayashi.CarFleet;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/car-fleet/
 */
class CarFleetTest {

    @Test
    void checkTemperature(){
        assertEquals(1, carFleet(0, List.of(1), Collections.emptyList()));
        assertEquals(1, carFleet(10, List.of(3), List.of(3)));
        assertEquals(3, carFleet(12, Arrays.asList(10,8,0,5,3), Arrays.asList(2,4,1,1,3)));
        assertEquals(1, carFleet(100, Arrays.asList(0,2,4), Arrays.asList(4,2,1)));
    }

    private int carFleet(int target, List<Integer> position, List<Integer> speed) {
        if (position.size() == 1) return 1;

        List<Car> fleet = new ArrayList<>();
        for (int i = 0; i < position.size(); i++)
            fleet.add(new Car(position.get(i), speed.get(i)));

        fleet.sort(Comparator.comparingInt(Car::position));

        Stack<Double> stack = new Stack<>();
        for (int i = fleet.size() - 1; i >= 0; i--) {
            Car car = fleet.get(i);
            double currentTime = (double) (target - car.position()) / car.speed();

            if (!stack.isEmpty() && currentTime <= stack.peek())
                continue;

            stack.push(currentTime);
        }
        return stack.size();
    }
}

record Car(int position, int speed) {

}
