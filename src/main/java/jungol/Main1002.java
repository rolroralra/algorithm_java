package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Main1002 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n;
		while ((n = in.nextInt()) > 10 || n < 2) ;
		
		int[] a = new int[n];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();
		}
		System.out.println(gcd(a) + " " + lcm(a));
	}
	
	public static int gcd(int[] a) {
		int[] b = new int[a.length - 1];
		b[0] = gcd(a[0],a[1]);
		for (int i = 1; i < b.length; i++) {
			b[i] = a[i + 1];
		}
		if (b.length == 1) {
			return b[0];
		}
		return gcd(b);
	}
	
	public static int lcm(int[] a) {
		int[] b = new int[a.length - 1];
		b[0] = lcm(a[0],a[1]);
		for (int i = 1; i < b.length; i++) {
			b[i] = a[i + 1];
		}
		if (b.length == 1) {
			return b[0];
		}
		return lcm(b);
	}
	
	public static int gcd(int a, int b) {
		/*if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}*/
		
		while (a % b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return b;
	}
	
	
	public static int lcm(int a, int b) {
		return a * b / gcd(a,b);
	}
}
