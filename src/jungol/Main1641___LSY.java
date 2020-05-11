package jungol;

import java.awt.event.ActionListener;
import java.util.Scanner;


public class Main1641___LSY {

	public Main1641___LSY() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		print(n, m);

	}

	public static void main(String[] args) {
		new Main1641();
	}

	public void print(int size, int type) {
		if (size > 0 && size <= 100 && size % 2 != 0) {
			if (type == 1) {
				int d = 1;
				int seq = 1;
				for (int i = 1; i <= size; i++) {
					if (i % 2 == 1) { // 정방향
						for (int j = 0; j < i; j++) {
							System.out.print(seq++ + " ");
						}
					} else { // 역방향
						d += 2;
						for (int j = 0; j < i; j++) {
							System.out.print(seq-- + " ");
						}
					}
					System.out.println();
					seq += d;
				}
			} else if (type == 2) {
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < i; j++) {
						System.out.print("  ");
					}
					for (int j = 0; j < 2 * size - 1 - 2 * i; j++) {
						System.out.print(i + " ");
					}
					System.out.println();
				}

			} else if (type == 3) {
				for (int i = 1; i <= size; i++) {
					if (i > (size) / 2) {
						for (int j = 1; j < size - i + 2; j++) {
							System.out.print(j + " ");
						}
					} else {
						for (int j = 1; j <= i; j++) {
							System.out.print(j + " ");
						}
					}
					System.out.println();
				}

			} else {
				System.out.println("INPUT ERROR!");
			}
		} else {
			System.out.println("INPUT ERROR!");
		}
	}
}
