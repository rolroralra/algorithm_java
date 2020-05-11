package jungol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2255 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n;

		while ((n = in.nextInt()) < 0 || n > 20000)
			;

		int[] m = new int[n];

		for (int i = 0; i < m.length; i++) {
			m[i] = in.nextInt();
		}
		in.close();

		boolean[] flagChecked = new boolean[m.length];

		ArrayList<Integer> cycleLength = new ArrayList<Integer>();

		for (int i = 0; i < m.length; i++) {
			if (flagChecked[i]) {
				continue;
			}
			
			int index = i;
			int count = 1;
			while (m[index] != i + 1) {
				flagChecked[index] = true;
				index = m[index] - 1;
				count++;
			}
			cycleLength.add(Integer.valueOf(count));
		}
		
		if (cycleLength.size() == 1) {
			System.out.println(cycleLength.get(0));
			return;
		}
		
		long lcm = lcm(cycleLength.get(0),cycleLength.get(1));
		for (int i = 2; i < cycleLength.size(); i++) {
			lcm = lcm(lcm,cycleLength.get(i));
		}
		System.out.println(lcm);
	}
	
	public static long lcm(long a, long b) {
		int gcd = 1;
		for (int i = 1; i <= Math.min(a, b); i++) {
			if (a % i == 0 && b % i == 0) {
				gcd = i;
			}
		}
		return a / gcd * b;
	}
}
