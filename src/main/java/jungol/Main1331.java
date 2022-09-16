package jungol;

import java.util.Arrays;
import java.util.Scanner;


public class Main1331 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n;
		
		while ((n = in.nextInt()) > 100 || n <= 0) ;
		
		in.close();
		
		char[][] a = new char[2 * n - 1][2 * n - 1];
		
		/*for (int i = 0; i < a.length; i++)			//' ' 로 초기화
			Arrays.fill(a[i], ' ');*/
		
		int row = -1;
		int col = n;
		int size = n;
		char index = 'A';
		
		for (int k = 0; k < n; k++) {
			size = n - k;
			for (int i = 0; i < size; i++) {
				a[++row][--col] = index++;
				index = (char)(((index - 'A') % ('Z' - 'A' + 1)) + 'A');
			}
			
			if (--size == 0) {
				break;
			}
			
			for (int i = 0; i < size; i++) {
				a[++row][++col] = index++;
				index = (char)(((index - 'A') % ('Z' - 'A' + 1)) + 'A');
			}
			
			for (int i = 0; i < size; i++) {
				a[--row][++col] = index++;
				index = (char)(((index - 'A') % ('Z' - 'A' + 1)) + 'A');
			}
			
			--size;
				
			for (int i = 0; i < size; i++) {
				a[--row][--col] = index++;
				index = (char)(((index  - 'A') % ('Z' - 'A' + 1)) + 'A');
			}
			row--;
		}
		print(a);
	}
	
	public static void print(char[][]a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++)
					System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

}
