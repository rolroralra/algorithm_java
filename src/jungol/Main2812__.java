package jungol;

import java.util.Scanner;

public class Main2812__ {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s;
		
		s = in.next();
		in.close();
		
		StringBuilder sb = new StringBuilder(s);
		do {
			System.out.println(f(sb).toString());
		} while (Long.parseLong(sb.toString()) >= 10);
	}
	
	public static String f(StringBuilder s) {
		long n = Long.parseLong(s.toString());
		
		int num = String.valueOf(n).length();
		
		int[] a = new int[num];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = (int)(n / (long)Math.pow(10, i) - (long)(n / (long)Math.pow(10, i + 1)) * 10);
		}
		
		int sum = 0;
		for (int i : a) {
			sum += i;
		}
		
		s.delete(0, s.length());
		return s.append(sum).toString();
	}
}
