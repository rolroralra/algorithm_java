package jungol;

import java.util.Scanner;

public class Main2814____ {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt(2); // 이진수를 십진수로... Integer Class 이용하지 말고 하기!
		in.close();
		System.out.println((byte)n);

		// 세번째 방법 : 재귀 함수!
		
		// 두번째 방법 : 구간문!
		/*int result = 0;
		int binary = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			switch (s.charAt(i)) {
			case '0':
				break;
			case '1':
				result += binary;
				break;
			default :
				new NumberFormatException().printStackTrace();
			}
			binary *= 2;
		}
		
		System.out.println(result);*/
	}
	
	
}
