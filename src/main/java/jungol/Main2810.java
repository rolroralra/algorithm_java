package jungol;

import java.util.Scanner;

public class Main2810 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int x;
		int y;
		
		while ((x = in.nextInt()) > 10000000 || x < 1) ;
		
		while ((y = in.nextInt()) > 10000000 || y < 1) ;

		
		int tempx = x;
		int tempy = y;
		int gcd = (x > y) ? y : x;
		while (tempx % tempy != 0) {
			int temp = tempx % tempy;
			tempx = tempy;
			tempy = temp;
			gcd = tempy;
		}
		System.out.println((x / gcd) * (y / gcd));
	}
}
