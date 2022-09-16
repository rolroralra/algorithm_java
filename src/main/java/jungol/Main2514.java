package jungol;

import java.util.Scanner;

public class Main2514 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String s = in.next();
		in.close();

		int result_KOI = 0;
		int result_IOI = 0;
		int n = s.length();
		for (int i = 0; i < n - 2; i++) {
			String subString = s.substring(i, i + 3);
			if (subString.equals("KOI")) {
				result_KOI++;
			} else if (subString.equals("IOI")) {
				result_IOI++;
			}
		}
		s.matches(s);
		s.equals(s);
		System.out.println(result_KOI);
		System.out.println(result_IOI);
		
		
		s.matches(s);
	}

}
