package jungol;

import java.util.Scanner;

public class Main2809 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		//while ((n = in.nextInt()) < 2 || n > 2100000000) ;

		int maxcount = (int) Math.sqrt(n);
		int[] a = new int[maxcount];

		int index = -1;
		for (int i = 1; i <= maxcount; i++) {
			if (n % i == 0) {
				a[++index] = i;
				System.out.print(i + " ");
			}
		}

		if (Math.sqrt(n) == maxcount) {
			index--;
		}

		for (int i = index; i >= 0; i--) {
			System.out.print(n / a[i] + " ");
		}
	}
}
