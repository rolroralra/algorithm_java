package jungol;

import java.util.Scanner;

public class Main2815 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.close();
		
		StringBuilder sb = new StringBuilder();
		
		while (n > 1) {
			//sb.insert(0, n % 2);
			sb.append(n % 2);
			n /= 2;
		}
		if (n == 1) {
			//sb.insert(0, 1);
			sb.append(1);
		}
		System.out.println(sb.reverse());
	}
}
