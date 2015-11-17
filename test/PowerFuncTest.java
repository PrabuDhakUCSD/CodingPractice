package test;

import static org.junit.Assert.*;
import mathops.PowerFun;

import org.junit.Test;

public class PowerFuncTest {

	@Test
	public void test1() {
		int base = 3;
		int power = 6;
		double expected = Math.pow(base, power);
		double output = PowerFun.power(base, power);
		assertEquals(expected, output, 0);
	}
	
	@Test
	public void test2() {
		int base = 3;
		int power = 9;
		double expected = Math.pow(base, power);
		double output = PowerFun.power(base, power);
		assertEquals(expected, output, 0);
	}
	
	@Test
	public void test3() {
		int base = 3;
		int power = 0;
		double expected = Math.pow(base, power);
		double output = PowerFun.power(base, power);
		assertEquals(expected, output, 0);
	}
	
	@Test
	public void test4() {
		int base = 0;
		int power = 6;
		double expected = Math.pow(base, power);
		double output = PowerFun.power(base, power);
		assertEquals(expected, output, 0);
	}
	
	@Test
	public void test5() {
		int base = -4;
		int power = 6;
		double expected = Math.pow(base, power);
		double output = PowerFun.power(base, power);
		assertEquals(expected, output, 0);
	}
	
	@Test
	public void test6() {
		int base = -4;
		int power = 9;
		double expected = Math.pow(base, power);
		double output = PowerFun.power(base, power);
		assertEquals(expected, output, 0);
	}
	
	@Test
	public void test7() {
		int base = 4;
		int power = -4;
		double expected = Math.pow(base, power);
		double output = PowerFun.power(base, power);
		assertEquals(expected, output, 0);
	}
	
	@Test
	public void test8() {
		int base = 4;
		int power = -7;
		double expected = Math.pow(base, power);
		double output = PowerFun.power(base, power);
		assertEquals(expected, output, 0);
	}
	
	// int power test
	@Test(expected = IllegalArgumentException.class)
	public void test9() {
		int base = 4;
		int power = -7;
		int output = PowerFun.intpower(base, power);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test10() {
		int base = 2;
		int power = 31;
		int output = PowerFun.intpower(base, power);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test11() {
		int base = -2;
		int power = 32;
		int output = PowerFun.intpower(base, power);
	}
	
	@Test
	public void test12() {
		int base = -2;
		int power = 31;
		int output = PowerFun.intpower(base, power);
		int expected = (int) Math.pow(base, power);
		assertEquals(expected, output, 0);
	}
	
	@Test
	public void test13() {
		int base = 2;
		int power = 30;
		int output = PowerFun.intpower(base, power);
		int expected = (int) Math.pow(base, power);
		assertEquals(expected, output, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test14() {
		int base = 2;
		int power = 100;
		int output = PowerFun.intpower(base, power);
	}
}
