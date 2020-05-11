package jungol;

import java.util.Scanner;

public class Main2085 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int b, a;
		
		b = in.nextInt();
		a = in.nextInt();
		in.close();
		
		if (b <= a || a < 1 || b < 1 || a > 1000000000 || b > 1000000000) System.exit(1);
		
		/*System.out.println(b / 4 - a / 4 - b / 100 + a / 100 + b / 400 - a / 400);*/
		
		int result = 0;
		for (int i = a + 1; i <= b; i++) {
			if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
				result++;
			}
		}
		System.out.println(result);
	}
}
