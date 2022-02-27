package com.thomashayashi.LeftRotation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 * A left rotation operation on an array shifts each of the array's elements 1unit to the left.
 * For example, if 2 left rotations are performed on array
 * [1,2,3,4,5]
 * then the array would become
 * [3,4,5,1,2]
 * Note that the lowest index item moves to the highest index in a rotation.
 * This is called a circular array.
 *
 * Given an A array of N integers and a number, d, perform d left rotations on the array.
 * Return the updated array to be printed as a single line of space-separated integers.
 * */
class LeftRotationTest {

    @Test
    void shouldStayTheSameWithOneElementIndependentOfTheLeftShift() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        List<Integer> rotatedArray = LeftRotation.rotLeft(arr, 1);
        assertEquals(arr, rotatedArray);
    }

    @Test
    void shouldSwapPositionWithTwoElementsAndOneShift() {
        List<Integer> arr = Arrays.asList(1,2);
        List<Integer> rotatedArray = LeftRotation.rotLeft(arr, 1);
        assertEquals(Arrays.asList(2,1), rotatedArray);
    }

    @Test
    void shouldRemainTheSameWithAFullCycleShiftWithAListWithEvenNumberOfElements() {
        List<Integer> originalArray = Arrays.asList(1,2);
        List<Integer> rotatedArray = LeftRotation.rotLeft(originalArray, originalArray.size());
        assertEquals(originalArray, rotatedArray);
    }

    @Test
    void shouldRemainTheSameWithAFullCycleShiftWithAListWithOddNumberOfElements() {
        List<Integer> originalArray = Arrays.asList(1,2,3);
        List<Integer> rotatedArray = LeftRotation.rotLeft(originalArray, originalArray.size());
        assertEquals(originalArray, rotatedArray);
    }

    @Test
    void shouldRemainTheSameWithANumberOfFullCycleShiftWithAListWithEvenNumberOfElements() {
        List<Integer> originalArray = Arrays.asList(1,2);
        List<Integer> rotatedArray = LeftRotation.rotLeft(originalArray, originalArray.size() * 5);
        assertEquals(originalArray, rotatedArray);
    }

    @Test
    void shouldRemainTheSameWithANumberOfFullCycleShiftWithAListWithOddNumberOfElements() {
        List<Integer> originalArray = Arrays.asList(1,2,3);
        List<Integer> rotatedArray = LeftRotation.rotLeft(originalArray, originalArray.size() * 7);
        assertEquals(originalArray, rotatedArray);
    }

    @Test
    void shouldSwapPositionWithTwoElementsWithOneAndHalfCycle() {
        List<Integer> arr = Arrays.asList(1,2);
        List<Integer> rotatedArray = LeftRotation.rotLeft(arr, arr.size() + 1);
        assertEquals(Arrays.asList(2,1), rotatedArray);
    }

    @Test
    void shouldConsiderOnlyTheAdditionalShiftAfterFullCycle() {
        List<Integer> arr = Arrays.asList(1,2,3);
        List<Integer> rotatedArray = LeftRotation.rotLeft(arr, arr.size() + 1);
        assertEquals(Arrays.asList(2,3,1), rotatedArray);

        rotatedArray = LeftRotation.rotLeft(arr, arr.size() + 2);
        assertEquals(Arrays.asList(3,1,2), rotatedArray);
    }
}