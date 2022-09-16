package jungol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2255__TL {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n;

		while ((n = in.nextInt()) < 0 || n > 20000)
			;

		int[] m = new int[n];
		int[] a = new int[n];
		for (int i = 0; i < m.length; i++) {
			a[i] = i + 1;
			while ((m[i] = in.nextInt()) < 0 || m[i] > m.length)
				;
		}
		in.close();	
		
		mapping(a, m);
		int count = 1;
		while (!flagOriginal(a)) {
			mapping(a, m);
			count++;
		}
		
		System.out.println(count);
		
	}
	public static boolean flagOriginal(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != i + 1) {
				return false;
			}
		}
		return true;
	}
	
	public static void mapping(int[] a, int[] m) {
		int[] temp = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			temp[i] = a[m[i] - 1];
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = temp[i];
		}
	}
}
