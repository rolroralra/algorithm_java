package jungol;

import java.util.Arrays;
import java.util.Scanner;


public class Main1295_BinarySearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		if (n > 50000 || n < 1) {
			System.exit(1);
		}
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		
		int num = in.nextInt();
		if (num > 10000 || num < 1) {
			System.exit(1);
		}
		
		int[] b = new int[num];
		for (int i = 0; i < num; i++) {
			b[i] = in.nextInt();
		}
		in.close();
		
		for (int i = 0; i < num; i++) {
			System.out.println(binarySearch(b[i], a, 0, n - 1));
		}
		
	}
	
	public static int binarySearch(int key, int[] a, int startIndex, int endIndex) {
		
		/*while (fromIndex <= toIndex) {
			int midIndex = (fromIndex + toIndex) >>> 1;
			if (a[midIndex] < key) {
				fromIndex = midIndex + 1;
			} 
			else if (a[midIndex] > key) {
				toIndex = midIndex - 1;
			}
			else {
				return midIndex + 1;
			}
		}
		return 0;*/
		
		
		// 종료조건
		if (startIndex >= endIndex) {
			if (key == a[startIndex]) {
				return startIndex + 1;
			}
			else {
				return 0;
			}
		}
		
		// 재귀!!!
		int midIndex = (startIndex + endIndex) / 2;
		if (key > a[midIndex]) {
			return binarySearch(key, a, midIndex + 1, endIndex);
		}
		else if (key < a[midIndex]) {
			return binarySearch(key, a, startIndex, midIndex - 1);
		}
		else {
			return midIndex + 1;
		}
	}
}
