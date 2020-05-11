package jungol;

import java.util.Scanner;

public class Main2514___ {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String s = in.next();
		in.close();

		int result_KOI = 0;
		int result_IOI = 0;

		int index = 1;
		while ((index = s.indexOf("OI", index)) != -1) {
			switch (s.charAt(index - 1)) {
			case 'K':
				result_KOI++;
				break;
			case 'I':
				result_IOI++;
				break;
			}
			index += 2;
		}

		System.out.println(result_KOI);
		System.out.println(result_IOI);
	}

}
