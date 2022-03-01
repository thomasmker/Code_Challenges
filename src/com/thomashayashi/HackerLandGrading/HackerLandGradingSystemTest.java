package com.thomashayashi.HackerLandGrading;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
* HackerLand University has the following grading policy:
* Every student receives a grade in the inclusive range from 0 to 100.
* Any less 40 than is a failing grade.
*
* Sam is a professor at the university and likes to round each student's grade according to these rules:
* - If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next
* multiple of 5.
* - If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade
*
* Examples:
* grade = 84 round to 85 (85 - 84 is less than 3)
* grade = 29 do not round (result is less than 40)
* grade = 57 do not round (60 - 57 is 3 or higher)
*
* Full description: https://www.hackerrank.com/challenges/grading/problem
 */
public class HackerLandGradingSystemTest {
    @Test
    void shouldReturnAnEmptyList() {
        List<Integer> grades = new ArrayList<>();
        List<Integer> roundedGrades = HackerLandGradingSystem.gradingStudents(grades);
        assertEquals(0, roundedGrades.size());
    }

    @Test
    void shouldNotRoundGradesBelow38() {
        List<Integer> grades = Arrays.asList(37, 36, 0);
        List<Integer> roundedGrades = HackerLandGradingSystem.gradingStudents(grades);
        assertEquals(37, roundedGrades.get(0));
        assertEquals(36, roundedGrades.get(1));
        assertEquals(0, roundedGrades.get(2));
    }

    @Test
    void shouldNotRoundIfTheGradeIsMultipleOfFive() {
        List<Integer> grades = Arrays.asList(40, 55, 100);
        List<Integer> roundedGrades = HackerLandGradingSystem.gradingStudents(grades);
        assertEquals(40, roundedGrades.get(0));
        assertEquals(55, roundedGrades.get(1));
        assertEquals(100, roundedGrades.get(2));
    }

    @Test
    void shouldRoundToTheClosestMultipleOfFiveIfTheDifferenceBetweenIsLessThanThree() {
        List<Integer> grades = Arrays.asList(84, 83);
        List<Integer> roundedGrades = HackerLandGradingSystem.gradingStudents(grades);
        assertEquals(85, roundedGrades.get(0));
        assertEquals(85, roundedGrades.get(1));
    }

    @Test
    void shouldNotRoundToTheClosestMultipleOfFiveBecauseTheDifferenceIsThreeOrMore() {
        List<Integer> grades = Arrays.asList(82, 81, 57, 56);
        List<Integer> roundedGrades = HackerLandGradingSystem.gradingStudents(grades);
        assertEquals(82, roundedGrades.get(0));
        assertEquals(81, roundedGrades.get(1));
        assertEquals(57, roundedGrades.get(2));
        assertEquals(56, roundedGrades.get(3));
    }
}
