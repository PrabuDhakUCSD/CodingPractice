package mathops;

public class PowerFun {
	public static double power(int base, int p) {
		if (base == 0 && p == 0)
			throw new IllegalArgumentException();
		
		if (base == 0)
			return 0;
		
		if (p == 0)
			return 1;
		
		boolean isNegPower = false;
		if (p<0) {
			p = Math.abs(p);
			isNegPower = true;
		}
		
		double halfRes = power(base, p/2);
		halfRes = halfRes * halfRes;
		
		if (p%2 != 0)
			 halfRes *=  base;
		
		if (isNegPower)
			return 1/halfRes;
		
		return halfRes;
	}
	
	public static int intpower(int base, int p) {
		if ((base == 0 && p == 0) || p<0)
			throw new IllegalArgumentException();
		
		if (base == 0)
			return 0;
		
		if (p == 0)
			return 1;
		
		long halfRes = intpower(base, p/2);
		halfRes = halfRes * halfRes;
		
		if (p%2 != 0)
			 halfRes *=  base;
		
		if (halfRes > Integer.MAX_VALUE || halfRes < Integer.MIN_VALUE)
			throw new IllegalArgumentException();
		
		return (int) halfRes;
	}
}
