package jungol;

import java.util.Scanner;

public class Main2604 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		in.close();

		int result = 10;
		int length = s.length();
		for (int i = 1; i < length; i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				result += 5;
			} else {
				result += 10;
			}
		}
		System.out.println(result);
	}
}
