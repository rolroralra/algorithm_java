package jungol;

import java.util.Scanner;

public class Main1430 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] a = new int[3];
		
		for (int i = 0; i < a.length; i++) {
			while ((a[i] = in.nextInt()) < 100 || a[i] >= 1000) ;
		}
		in.close();
		
		int[] n = new int[10];
		
		n = f(a[0] * a[1] * a[2]);
		for (int i = 0; i <= 9; i++) {
			System.out.println(n[i]);
		}
	}
	
	public static int[] f(int n) {
		int[] a = new int[10];
		String s = String.valueOf(n);
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j < s.length(); j++) {
				if (Integer.parseInt(s.substring(j, j + 1)) == i) {
					a[i]++;
				}
			}
		}
		return a;
	}
}
