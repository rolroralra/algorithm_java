package jungol;

import java.util.Scanner;

public class Main1274 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String s = in.next();
		in.close();
		int length = s.length();
		int[] a = new int[length];
		for (int i = 0; i < length; i++) {
			a[i] = Integer.valueOf(s.substring(i, i + 1));
		}
		
		boolean flag = false;
		if (a[0] == 1) {
			flag = true;
			int lastIndex = length - 1;
			for (int i = length - 1; i >= 0; i--) {
				if (a[i] == 1) {
					lastIndex = i;
					break;
				}
			}

			for (int i = 0; i < lastIndex; i++) {
				a[i] = (a[i] == 0) ? 1 : 0;
			}
		}
		
		int result = 0;
		for (int i = 0; i < length - 1; i++) {
			if (a[length - i - 1] == 1) {
				result += (int)Math.pow(2, i);
			}
		}
		
		if (flag) {
			result *= -1;
		}
		
		System.out.println(result);
	}
}
