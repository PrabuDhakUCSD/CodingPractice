package test;

import static org.junit.Assert.*;

import org.junit.Test;
import strings.KMP;

public class kmptest {

    @Test
    public void test1() {
        String input = "foobar";
        String pat = "foo";
        int expected = 0;
        int output = KMP.isSubString(input, pat);
        assertEquals(expected, output);
    }
    
    @Test
    public void test2() {
        String input = "foobar";
        String pat = "bar";
        int expected = 3;
        int output = KMP.isSubString(input, pat);
        assertEquals(expected, output);
    }
    
    @Test
    public void test3() {
        String input = "fofofoblah";
        String pat = "fofobl";
        int expected = 2;
        int output = KMP.isSubString(input, pat);
        assertEquals(expected, output);
    }

}
