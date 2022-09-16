package jungol;

import java.awt.event.ActionListener;
import java.util.Scanner;


public class Main1641 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n, m;
		boolean flag = false;
		/*while ((n = in.nextInt()) > 100 || n <= 0 || n % 2 == 0) {
			System.out.println("INPUT ERROR!");
		}
	
		while ((m = in.nextInt()) > 3 || m <= 0 ) {
			System.out.println("INPUT ERROR!");
		}*/
		
		n = in.nextInt();
		m = in.nextInt();
		
		if (n > 100 || n <= 0 || n % 2 == 0) {
			flag = true;
		}
		else if (m > 3 || m <= 0) {
			flag = true;
		}
		
		String s;
		
		if (flag) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		switch (m) {
		case 1:
/*			for (int i = 1; i <= n; i++) {
				if (i % 2 == 1) {
					int startIndex = (i - 1) * i / 2 + 1;
					for (int j = 0; j < i; j++) {
						System.out.printf(startIndex++ + " ");
					}
				}
				else {
					int startIndex = (i + 1) * i / 2;
					for (int j = 0; j < i; j++) {
						System.out.print(startIndex-- + " ");
					}
				}
				System.out.println();
			}
*/
			int start = 0;
			for(int i = 1; i<=n; i++){
				if(i%2==1){
					for(int j = 1; j<=i; j++){
						System.out.print(++start + " ");
					}
					System.out.println();
				} else{
					start = start + i;						// Key Point!
					int temp = start;						// Key Point!
					for(int j = 1; j<=i; j++){
						System.out.print(temp-- + " ");
					}
					System.out.println();
				}
			}
			
			/*int[][] a = new int[n][];
			int index = 1;
			
			for (int i = 0; i < n; i++) {
				a[i] = new int[i + 1];
				if (i % 2 == 0) {
					for (int j = 0; j < a[i].length; j++) {
						a[i][j] = index++;
					}
				}
				else {
					for (int j = a[i].length - 1; j >= 0; j--) {
						a[i][j] = index++;
					}
				}
				System.out.println();
			}
			
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}*/
			break;
		case 2:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print("  ");
				}
				for (int j = 0; j < 2 * n - 1 - 2 * i; j++) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			break;
		case 3:
			for (int i = 0; i < n; i++) {
				int startIndex = 1;
				for (int j = 0; j < (n + 1) / 2 - Math.abs((n - 1) / 2 - i); j++) {
					System.out.print(startIndex++ + " ");
				}
				System.out.println();
			}
			break;
		}
	}
}
