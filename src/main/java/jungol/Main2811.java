package jungol;

import java.util.Scanner;

public class Main2811 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] a = new int[5];
		
		for (int i = 0; i < 5; i++) {
			while ((a[i] = in.nextInt()) > 1000000000 || a[i] < 1) ;
		}								 
		in.close();
		
		for (int i = 0; i < 5; i++) {
			if (a[i] == 1) {
				System.out.println("number one");
				continue;
			}
			
			boolean isCompositeNumber = false;
			int lastIndex = (int)Math.sqrt(a[i]);
			for (int j = 2; j <= lastIndex; j++) {
				if (a[i] % j == 0) {
					System.out.println("composite number");
					isCompositeNumber = true;
					break;
				}
			}
			if (!isCompositeNumber) {
				System.out.println("prime number");
			}
		}
	}
}
