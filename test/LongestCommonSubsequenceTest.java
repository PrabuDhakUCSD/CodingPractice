package test;

import static org.junit.Assert.*;
import dp.LongestCommonSubSequence;

import org.junit.Test;

public class LongestCommonSubsequenceTest {

    @Test
    public void test1() {
        String first = "applogic";
        String second = "pgcoicpogi";
        String expected = "ppogi";
        assertTrue(expected.equals(LongestCommonSubSequence.lcs(first, second)));
    }
    
    @Test
    public void test2() {
        String first = "abapnapnlae";
        String second = "appbananale";
        String expected = "abnanle";
        assertTrue(expected.equals(LongestCommonSubSequence.lcs(first, second)));
    }

}
