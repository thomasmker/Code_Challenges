package com.thomashayashi.RollerCoasterQueue;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.max;

class RollerCoasterQueue {

    private int totalOfBribes = 0;
    private static final int MAX_BRIBES_PER_PERSON = 2;

    public int minimumBribes(List<Integer> queue) throws RuntimeException {
        for (int currentPerson = queue.size() - 1; currentPerson >= 0; currentPerson--) {
            checkMaxAmountOfBribesDone(queue, currentPerson);
            calculateBribedTimes(queue, currentPerson);
        }

        return totalOfBribes;
    }

    private void checkMaxAmountOfBribesDone(List<Integer> queue, int currentPerson) {
        if(queue.get(currentPerson) - (currentPerson + 1) > MAX_BRIBES_PER_PERSON)
            throw new RuntimeException();
    }

    private void calculateBribedTimes(List<Integer> queue, int currentPerson) {
        for(int frontPerson = max(0, queue.get(currentPerson) - 2); frontPerson < currentPerson; frontPerson++){
            if(queue.get(frontPerson) > queue.get(currentPerson))
                totalOfBribes++;
        }
    }
}