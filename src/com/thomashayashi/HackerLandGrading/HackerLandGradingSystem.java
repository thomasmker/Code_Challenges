package com.thomashayashi.HackerLandGrading;

import java.util.ArrayList;
import java.util.List;

public class HackerLandGradingSystem {
    private static final int PASSING_GRADE = 38;
    private static final int ROUND_FACTOR = 5;
    private static final int ROUND_POINT_LIMIT = 3;

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();
        grades.forEach(grade -> roundedGrades.add(calculateRoundedGrade(grade)));
        return roundedGrades;
    }

    private static Integer calculateRoundedGrade(Integer grade) {
        int pointsToRound = 0;

        if(isPassingGrade(grade) && !isAlreadyRounded(grade))
            pointsToRound = getPointsNextRoundingWithinLimit(grade);

        return grade + pointsToRound;
    }

    private static boolean isPassingGrade(Integer grade){
        return grade >= PASSING_GRADE;
    }

    private static boolean isAlreadyRounded(Integer grade){
        return grade % ROUND_FACTOR == 0;
    }

    private static int getPointsNextRoundingWithinLimit(Integer grade) {
        int pointsNextRound = (ROUND_FACTOR - (grade % ROUND_FACTOR));
        return isWithinRoundLimit(pointsNextRound) ? pointsNextRound : 0;
    }

    private static boolean isWithinRoundLimit(int pointsToRound) {
        return pointsToRound < ROUND_POINT_LIMIT;
    }
}
