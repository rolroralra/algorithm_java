package jungol;

import java.util.Scanner;

public class Main1071 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		int[] a = new int[n];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();
		}
		
		int m = in.nextInt();
		in.close();
		
		int sumDivisor = 0;
		int sumMultiple = 0;
		for (int i = 0; i < a.length; i++) {
			if (m % a[i] == 0) {
				sumDivisor += a[i];
			}
			if (a[i] % m == 0) {
				sumMultiple += a[i];
			}
		}
		System.out.println(sumDivisor);
		System.out.println(sumMultiple);
	}
}
