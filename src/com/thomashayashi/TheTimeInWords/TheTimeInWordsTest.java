package com.thomashayashi.TheTimeInWords;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/strange-advertising/problem
 */
class TheTimeInWordsTest {
    @Test
    void checkTime(){
        assertEquals("quarter past eleven", timeInWords(11,15));
        assertEquals("half past twelve", timeInWords(12,30));
        assertEquals("two minutes past three", timeInWords(3,2));
        assertEquals("one minute past four", timeInWords(4,1));
        assertEquals("five o' clock", timeInWords(5,0));
    }

    private String timeInWords(int h, int m) {
        List<String> v = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine" );

        String time;

        if(m<=30){
            if(m==0)
                time=v.get(h)+" o' clock";
            else if(m==15)
                time="quarter past "+v.get(h);
            else if(m==30)
                time="half past "+v.get(h);
            else if(m==1)
                time=v.get(m)+" minute past "+v.get(h);
            else
                time=v.get(m)+" minutes past "+v.get(h);
        }
        else{
            if(m==45)
                time="quarter to "+v.get(h+1);
            else if(m==59)
                time=v.get(60-m)+" minute to "+v.get(h+1);
            else
                time=v.get(60-m)+" minutes to "+v.get(h+1);
        }
        return time;

    }
}
