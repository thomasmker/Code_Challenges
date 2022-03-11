package com.thomashayashi.OneOperationAway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
Example:
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bae -> false
*/
class OneOperationAwayTest {
    @Test
    void checkIfTheWordsAreOneOperationAway(){
        assertTrue(isOneOperationAway("a", "a")); // 0 edits
        assertTrue(isOneOperationAway("a", "b")); // 1 replace
        assertTrue(isOneOperationAway("a", "")); // 1 remove
        assertTrue(isOneOperationAway("a", "ab")); // 1 insertion
        assertTrue(isOneOperationAway("pale", "ple")); // 1 remove
        assertTrue(isOneOperationAway("pales", "pale")); // 1 insert
        assertTrue(isOneOperationAway("pale", "bale")); // 1 replace

        assertFalse(isOneOperationAway("a", "aXY")); // 2 insertions
        assertFalse(isOneOperationAway("aXY", "a")); // 2 remove
        assertFalse(isOneOperationAway("ab", "ba")); // 2 replaces
        assertFalse(isOneOperationAway("a", "cb")); // 1 replaces + 1 insertion
        assertFalse(isOneOperationAway("pale", "bae")); // 1 replaces + 1 remove
    }

    private boolean isOneOperationAway(String word1, String word2) {
        if(word1.length() == word2.length())
            return isOneEditReplace(word1, word2);

        if(Math.abs(word1.length() - word2.length()) == 1)
            return isOneEditAway(word1, word2);

        return false;
    }

    private boolean isOneEditAway(String word1, String word2) {
        String biggerWord = word1.length() > word2.length() ? word1 : word2;
        String smaller = biggerWord.equals(word1) ? word2 : word1;

        int missingLetters = 0;

        int indexSmaller = 0, indexBigger = 0;
        while(indexSmaller < smaller.length())
        {
            if(smaller.charAt(indexSmaller) == biggerWord.charAt(indexBigger))
                indexSmaller++;
            else
                missingLetters++;

            indexBigger++;

            if(missingLetters == 2)
                return false;
        }

        return true;
    }

    private boolean isOneEditReplace(String word1, String word2) {
        boolean isOneReplaceDone = false;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)) {
                if(isOneReplaceDone)
                    return false;
                isOneReplaceDone = true;
            }
        }

        return true;
    }

}
