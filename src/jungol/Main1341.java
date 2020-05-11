package jungol;

import java.util.Scanner;

public class Main1341 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int s, e;
		boolean flag = false;

		do {
			if ((s = in.nextInt()) > 9 || s < 2)
				flag = true;
			else
				flag = false;
			if ((e = in.nextInt()) > 9 || e < 2)
				flag = true;
		} while (flag);

		int num = Math.abs(s - e) + 1;
		int d = (s > e) ? -1 : 1;
		
		for (int i = 0; i < num; i++) {
			int index = s + d * i;
			for (int j = 0 ; j < 3; j++) {
				System.out.printf("%d * %d = %2d   ", index, 1 + 3 * j, index * (1 + 3 * j));
				System.out.printf("%d * %d = %2d   ", index, 2 + 3 * j, index * (2 + 3 * j));
				System.out.printf("%d * %d = %2d\n", index, 3 + 3 * j, index * (3 + 3 * j));
			}
			System.out.println();
		}
	}
}
