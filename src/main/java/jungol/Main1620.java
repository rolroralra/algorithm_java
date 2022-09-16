package jungol;

import java.util.Scanner;

public class Main1620 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String pNum;
		
		pNum = in.next();
		int p = in.nextInt();
		int m = in.nextInt();
		in.close();
		
		String[] pSubNums = pNum.split("-", -1);
		
		if (pNum.length() > 100 || p < 0 || p > 9 || m > pSubNums.length)  {
			System.exit(1);
		}
		
		int n = pSubNums.length;
		for (int i = 0; i < n; i++) {
			if (pSubNums[i].length() > 4) {
				System.out.println("INPUT ERROR!");
				return;
			} 
		}
		
		int length = pSubNums[m - 1].length();
		for (int i = 0; i < 4 - length; i++) {
			System.out.print(p);
		}
		for (int i = 0; i < length; i++) {
			System.out.print((pSubNums[m - 1].charAt(i) - '0' + p) % 10);
		}
	}
}
