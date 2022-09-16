package jungol;

import java.util.Scanner;

public class Main1331_1 {
	public Main1331_1() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		char[][] arr = new char[2 * n - 1][];
		int size = -1;
		for (int i = 0; i < n; i++) {
			arr[i] = new char[size += 2];
		}
		for (int i = n; i < arr.length; i++) {
			arr[i] = new char[size -= 2];
		}
		// 마름모꼴 배열 생성 완료

		char ch = 'A';

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n - 2 * i - 1; j++) {
//				System.out.println("["+(j+i)+"]["+i+"]"+ch);
				arr[j + i][i] = ch++;
				if (ch > 'Z')
					ch = 'A';
			}
			for (int j = 0; j < n - i - 1; j++) {
//				System.out.println("["+(2 * n - i - j - 3)+"]["+((j + 1) * 2 + i)+"]"+ch);
				arr[2 * n - i - j - 3][(j + 1) * 2 + i] = ch++;
				if (ch > 'Z')
					ch = 'A';
			}
			for (int j = n - i - 1; j < 2 * n - 2 * i - 3; j++) {
//				System.out.println("["+(2 * n - i - j - 3)+"]["+(4 * n - 2 * j - 3 * i - 6)+"]"+ch);
				arr[2 * n - i - j - 3][4 * n - 2 * j - 3 * i - 6] = ch++;
				if (ch > 'Z')
					ch = 'A';
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (i < n - 1) {
				for (int j = 0; j < n - 1 - i; j++) {
					System.out.print("  ");
				}
			} else {
				for (int j = 0; j < i - n + 1; j++) {
					System.out.print("  ");
				}
			}
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		new Main1331_1();
	}
}
