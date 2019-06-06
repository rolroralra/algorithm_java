package algorithm;

public class Extended_Euclidean_Algorithm {

	public static void main(String[] args) {
		int[] x = new int[1];
		int[] y = new int[1];
		int a = 3;
		int b = 5;
		int gcd = extendedEuclideanByRecursive(a, b, x, y);
		System.out.println(a + " x " + x[0] + " + " + b + " x " + y[0] + " = " + gcd);
		
		gcd = extendedEuclideanByLoop(a, b, x, y);
		System.out.println(a + " x " + x[0] + " + " + b + " x " + y[0] + " = " + gcd);
	}
	
	public static int extendedEuclideanByRecursive(int a, int b, int[] x, int[] y) {
		int gcd = a;
		x[0] = 1;
		y[0] = 0;
		
		if (b != 0) {
			gcd = extendedEuclideanByRecursive(b, a % b, y, x);
			y[0] -= a / b * x[0];
		}
		return gcd;
	}
	
	public static int extendedEuclideanByLoop(int a, int b, int[] x, int[] y) {
		int t1 = 1;
		int t2 = 0;
		int s1 = 0;
		int s2 = 1;
		
		int t = 0;
		int s = 0;
		
		int gcd = a;
		while (b != 0) {
			t = t1;
			t1 = t2;
			t2 = t - a / b * t2;
			
			s = s1;
			s1 = s2;
			s2 = s - a / b * s2;
			
			int temp = a % b;
			a = b;
			b = temp;
		}
		
		x[0] = t1;
		y[0] = s1;
		return gcd;
	}
	
	
	

}
