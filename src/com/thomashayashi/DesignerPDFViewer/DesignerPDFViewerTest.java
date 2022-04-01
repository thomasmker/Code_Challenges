package com.thomashayashi.DesignerPDFViewer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
 */
class DesignerPDFViewerTest {
    @Test
    void checkHighlightedWordHeight(){
        assertEquals(9, designerPdfViewer(Arrays.asList(1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5),"abc"));
        assertEquals(8, designerPdfViewer(Arrays.asList(1,3,1,3,1,4,1,3,2,5,5,5,5,1,1,5,5,1,5,2,5,5,5,5,5,5),"torn"));
        assertEquals(28, designerPdfViewer(Arrays.asList(1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,7),"zaba"));
    }

    private int designerPdfViewer(List<Integer> h, String word) {
        int maxHeight = -1;
        for(char letter : word.toCharArray()) {
            int pos = letter - 'a';
            int height = h.get(pos);
            if(height > maxHeight)
                maxHeight = height;
        }
        return maxHeight * word.length();
    }
}
