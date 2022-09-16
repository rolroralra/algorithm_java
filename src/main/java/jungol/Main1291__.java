package jungol;

import java.util.Scanner;

public class Main1291__ {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		int s, e;
		boolean flagError = false;
		do {
			if (flagError) {
				System.out.println("INPUT ERROR!");
			}
			if ((s = in.nextInt()) > 9 || s < 2) {
				flagError = true;
			}
			else {
				flagError = false;
			}
			if ((e = in.nextInt()) > 9 || e < 2) {
				flagError = true;
			}
		} while (flagError);
		
		in.close();
		
		int d = (s > e) ? -1 : 1;
		int num = Math.abs(s - e) + 1;
		
		for (int i = 1; i <= 9; i++) {
			int index = s;
			for (int j = 0; j < num; j++) {
				System.out.printf("%d * %d = %2d",index, i,  index * i);
				if (j != num - 1) {
					System.out.print("   ");
				}
				index += d;
			}
			System.out.println();
		}
	}
}
