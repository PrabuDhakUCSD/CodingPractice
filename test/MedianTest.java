package test;

import static org.junit.Assert.*;
import arrays.MedianOfSorted;

import org.junit.Test;

public class MedianTest {

	@Test
	public void test1() {
		int[] array1 = {1,3,5,7};
		int[] array2 = {2,4,6,8,9};
		double expected = 5;
		double output = MedianOfSorted.median(array1, array2);
		assertEquals(expected, output, 0);
	}
	
	@Test
	public void test2() {
		int[] array1 = {1,3,5,7,10};
		int[] array2 = {2,4,6,8,9};
		double expected = 5.5;
		double output = MedianOfSorted.median(array1, array2);
		assertEquals(expected, output, 0);
	}
	
	@Test
	public void test3() {
		int[] array1 = {1,2,3,4};
		int[] array2 = {5,6,7,8,9};
		double expected = 5;
		double output = MedianOfSorted.median(array1, array2);
		assertEquals(expected, output, 0);
	}
	
	@Test
	public void test4() {
		int[] array1 = {1,2,3,4};
		int[] array2 = {5,6,7,8,9,10,11,12,13};
		double expected = 7;
		double output = MedianOfSorted.median(array1, array2);
		assertEquals(expected, output, 0);
	}
	
	@Test
	public void test5() {
		int[] array1 = {1,2,3,4};
		int[] array2 = {5,6,7,8,9,10,11,12,13,14};
		double expected = 7.5;
		double output = MedianOfSorted.median(array1, array2);
		assertEquals(expected, output, 0);
	}
}
