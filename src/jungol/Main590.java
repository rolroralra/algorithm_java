package jungol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main590 {

	public static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n;

		while ((n = s.nextInt()) > 10 || n <= 0) ;
		
		//int maxSize = factorial(n+5)/factorial(n)/factorial(5);
		int maxSize = (int) Math.pow(6, n);
		//ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		int[][] a = new int[maxSize][n];
		int[] b= new int[n];
		int[] c= new int[n];
		
		
		for (int i = 0; i < n; i++)
			b[i] = 1;
		
		int count = 0;

		while (b[0] != 7) {
			System.arraycopy(b, 0, c, 0, n);
			mergeSort(c,0,n-1);
			
			boolean isExists = false;
			for (int i = 0; i < count; i++) {
				if (equals(a[i], c)) {
					isExists = true;
					break;
				}
			}
			if (!isExists) {
				for (int i = 0; i < n; i++)
					a[count][i] = c[i];
				count++;
				print(c);
			}
			
			b[n - 1]++;
			for (int i = n - 1; i >= 0; i--) {
				if (b[i] == 7) {
					if (i == 0) {
						System.out.println("END");
						break;
					}
					else {
						b[i] = 1;
						b[i - 1]++;
					}
				} 
			}
		}
	}
	
	public static boolean equals(int[] a, int[] c) {
		int n = a.length;
		for (int i = 0; i < n; i++)
			if (a[i] != c[i])
				return false;
		return true;
	}
	
	public static int factorial(int n) {
		if (n == 1)
			return 1;
		else
			return n * factorial(n-1);
	}
	
	public static void print(int[]a) {
		int n = a.length;
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	public static void mergeSort(int[] a, int i, int j) {
		if (i == j)
			return;
		else {
			mergeSort(a, i, (i+j)/2);
			mergeSort(a, (i+j)/2 + 1, j);
			merge(a,i, (i+j)/2 + 1, j);
		}
	}
	
	
	public static void merge(int[] a, int start, int middle, int last) {
		int[] b = new int[last - start + 1];
		int x = start;
		int y = middle;
		int i = 0;
		
		while (x < middle && y <= last) {
			if (a[x] < a[y])
				b[i++] = a[x++];
			else 
				b[i++] = a[y++];
		}
		
		while (x < middle)
			b[i++] = a[x++];
		while (y <= last)
			b[i++] = a[y++];
		x = start;
		for (i = 0; i < last - start + 1 ; i++) {
			a[x] = b[i];
			x++;
		}
	}

}
