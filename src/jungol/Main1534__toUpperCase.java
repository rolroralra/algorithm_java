package jungol;

import java.util.Scanner;

public class Main1534__toUpperCase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int radix = in.nextInt();
		in.close();						//String, Integer 클래스내 메서드 이용해서 풀어보기!
		
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
