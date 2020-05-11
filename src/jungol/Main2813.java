package jungol;

import java.util.Scanner;

public class Main2813 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		int m, n;
		
		while ((m = in.nextInt()) > 2000000 || m < 1) ;
		while ((n = in.nextInt()) > 2000000 || n < 1) ;
		in.close();
		
		
		if (m == 1) {
			m = 2;
		}
		int count = 0;
		for (int i = m; i <= n; i++) {
			boolean flagPrime = true;
			int lastIndex = (int)Math.sqrt(i);
			for (int j = 2; j <= lastIndex; j++) {
				if (i % j == 0) {
					flagPrime = false;
					break;
				}
			}
			if (flagPrime) {
				count++;
			}
		}
		System.out.println(count);
	}
}
