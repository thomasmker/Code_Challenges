package com.thomashayashi.BowlingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void canScoreGutterGame() {
        game.roll(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        assertEquals(game.score(), 0);
    }

    @Test
    void canScoreGameOfOnes() {
        game.roll(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
        assertEquals(game.score(), 20);
    }

    @Test
    void canScoreSpareFollowedByThree() {
        game.roll(5,5,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        assertEquals(game.score(), 16);
    }

    @Test
    void canScoreStrikeFollowedByThreeThenThree() {
        game.roll(10,3,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        assertEquals(game.score(), 22);
    }

    @Test
    void canScorePerfectGame() {
        game.roll(10,10,10,10,10,10,10,10,10,10,10,10);
        assertEquals(game.score(), 300);
    }

}

class Game {
    private int roll = 0;
    private final int[] rolls = new int[21];

    public void roll(int pinsDown) {
        rolls[roll++] = pinsDown;
    }

    public int score() {
        int score = 0;
        int cursor = 0;
        for (int frame = 0; frame < 10; frame++){
            if(isStrike(cursor)){
                score += 10 + rolls[cursor + 1] + rolls[cursor + 2];
                cursor++;
            } else if(isSpare(cursor)) {
                score += 10 + rolls[cursor + 2];
                cursor += 2;
            } else {
                score += rolls[cursor] + rolls[cursor + 1];
                cursor += 2;
            }
        }

        return score;
    }

    private boolean isStrike(int cursor) {
        return rolls[cursor] == 10;
    }

    private boolean isSpare(int cursor) {
        return rolls[cursor] + rolls[cursor + 1] == 10;
    }

    public void roll(int...rolls) {
        for(int pinsDown : rolls)
            roll(pinsDown);
    }
}


