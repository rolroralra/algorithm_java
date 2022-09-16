package jungol;

import java.util.Scanner;

public class Main2815____Recursive {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.close();
		
		System.out.println(toBinaryString(n));
	}
	
	public static String toBinaryString(int num) {
		if (num <= 1) {
			return String.valueOf(num);
		}
		return toBinaryString(num / 2) + toBinaryString(num % 2);
	}
}
