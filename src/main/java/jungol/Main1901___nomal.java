package jungol;

import java.util.Random;
import java.util.Scanner;

public class Main1901___nomal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Random r;
		int n;					// 에라토스테네스 체 이용하지 말고.. 그냥 하나씩 하나씩 소수 찾기!
		
		while ((n = in.nextInt()) > 100 || n < 1)
			;
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			while ((a[i] = in.nextInt()) > 1000000 || a[i] < 1)
				;
		}
		in.close();

		int max = a[0];
		for (int i = 1; i < n; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}

		boolean[] flagComposite = new boolean[max * 2 - 2];
	}
}
