package jungol;

import java.util.Scanner;

public class Main1239 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] code = {"000000", "001111", "010011", "011100", "100110","101001", "110101", "111010"};
		int n = in.nextInt();
		
		String s = in.next(); 
		in.close();
		
		if (n > 10 || n < 1 || s.length() != 6 * n) {
			System.exit(1);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n ; i++) {
			int resultPosition = -1;
			for (int j = 0; j < 8; j++) {
				int countError = 0;
				for (int k = 0; k < 6; k++) {
					if (s.charAt(6 * i + k) != code[j].charAt(k)) {
						countError++;
						if (countError == 2) {
							break;
						}
					}
				}
				if (countError < 2) {
					sb.append((char)('A' + j));	
					resultPosition = j;
					break;
				}
			}
			if (resultPosition == -1) {
				System.out.println(i + 1);
				return;
			}
		}
		
		if (sb.length() == n) {
			System.out.println(sb);
		}
	}
}
