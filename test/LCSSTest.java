package test;

import static org.junit.Assert.*;

import org.junit.Test;
import dp.LongestCommonSubstring;

public class LCSSTest {

    @Test
    public void test1() {
        String first = "abab";
        String second = "baba";
        String expected = "aba";
        String output = LongestCommonSubstring.LCSS(first, second);
        assertTrue(expected.equals(output));
    }
    
    @Test
    public void test2() {
        String first = "geeksforgeeks";
        String second = "geeksqueksforgiz";
        String expected = "eksforg";
        String output = LongestCommonSubstring.LCSS(first, second);
        assertTrue(expected.equals(output));
    }
}
