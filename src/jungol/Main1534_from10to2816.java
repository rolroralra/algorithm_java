package jungol;

import java.util.Scanner;

public class Main1534_from10to2816 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int radix = in.nextInt();
		in.close();
		
		StringBuilder sb = new StringBuilder(Integer.toString(n, radix));
		
		if (radix == 16) {
			int length = sb.length();
			for (int i = 0; i < length; i++) {
				switch(sb.charAt(i)) {
				case 'a' :
					sb.setCharAt(i, 'A');
					break;
				case 'b' :
					sb.setCharAt(i, 'B');
					break;
				case 'c' :
					sb.setCharAt(i, 'C');
					break;
				case 'd' :
					sb.setCharAt(i, 'D');
					break;
				case 'e' :
					sb.setCharAt(i, 'E');
					break;
				case 'f' :
					sb.setCharAt(i, 'F');
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
