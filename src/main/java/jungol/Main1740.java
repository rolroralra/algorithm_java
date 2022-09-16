package jungol;

import java.util.Scanner;

public class Main1740 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int m, n;
		
		while ((m = in.nextInt()) > 10000 || m < 1) ;
		while ((n = in.nextInt()) > 10000 || n < 1) ;
		in.close();
		
		if (m > n) {
			int temp = m;
			m = n;
			n = temp;
		}
		
		if (m == 1) {
			m = 2;
		}
		int minPrime = 10001;
		int primeSum = 0;
		for (int i = m; i <= n; i++) {
			boolean flagPrime = true;
			for (int j = 2; j * j <= i; j++) {
				if (i % j == 0) {
					flagPrime = false;
					break;
				}
			}
			if (flagPrime) {
				primeSum += i;
				if (minPrime > i) {
					minPrime = i;
				}
			}
		}
		
		if (primeSum == 0) {
			System.out.println("-1");
		}
		else {
			System.out.println(primeSum);
			System.out.println(minPrime);
		}
		
	}
}
