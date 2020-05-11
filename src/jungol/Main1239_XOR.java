package jungol;

import java.util.Scanner;

public class Main1239_XOR {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] code = { "000000", "001111", "010011", "011100", "100110",
				"101001", "110101", "111010" };
		int n = in.nextInt();

		String s = in.next();
		in.close();

		if (n > 10 || n < 1 || s.length() != 6 * n) {
			System.exit(1);
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int binaryInput = Integer.parseInt(s.substring(6 * i, 6 * i + 6), 2);
			boolean flagValid = false;
			int codeNum = code.length;
			for (int j = 0; j < codeNum; j++) {
				int binaryCode = Integer.parseInt(code[j], 2);
				switch (binaryInput ^ binaryCode) {
				case 0b000000:
				case 0b000001:
				case 0b000010:
				case 0b000100:
				case 0b001000:
				case 0b010000:
				case 0b100000:
					result.append((char) ('A' + j));
					flagValid = true;
					break;
				}
			}
			if (!flagValid) {
				System.out.println(i + 1);
				return;
			}
		}
		System.out.println(result);
	}
}
