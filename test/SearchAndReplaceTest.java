package test;

import static org.junit.Assert.*;

import org.junit.Test;
import strings.SearchAndReplace;

public class SearchAndReplaceTest {

	@Test
	public void test1() {
		String input = "quick brown fox jumped on another red fox in front of mother fox";
		String pattern = "fox";
		String replacement = "cow";
		
		String expected = "quick brown cow jumped on another red cow in front of mother cow";
		String output = SearchAndReplace.searchAndReplace(input, pattern, replacement);
		assertTrue(expected.equals(output));
	}
	
	@Test
	public void test2() {
		String input = "quick brown fox jumped on another red fox in front of mother fox";
		String pattern = "fox";
		String replacement = "elephant";
		
		String expected = "quick brown elephant jumped on another red elephant in front of mother elephant";
		String output = SearchAndReplace.searchAndReplace(input, pattern, replacement);
		assertTrue(expected.equals(output));
	}
	
	@Test
	public void test3() {
		String input = "quick brown elephant jumped on another red elephant in front of mother elephant";
		String pattern = "elephant";
		String replacement = "fox";
		
		String expected = "quick brown fox jumped on another red fox in front of mother fox";
		String output = SearchAndReplace.searchAndReplace(input, pattern, replacement);
		assertTrue(expected.equals(output));
	}
	
	@Test
	public void test4() {
		String input = "foobarfoobarfoobar";
		String pattern = "foo";
		String replacement = "bar";
		String input1 = SearchAndReplace.searchAndReplace(input, pattern, replacement);
		pattern = "bar";
		replacement = "ice";
		String expected = "iceiceiceiceiceice";
		String output = SearchAndReplace.searchAndReplace(input1, pattern, replacement);
		assertTrue(expected.equals(output));
	}
}
