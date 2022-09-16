package jungol;

import java.util.Scanner;

public class Main1671_ArrayIndexOutOfBound {
	
	static class WhitePaper {
		private static final int SIZEOFPAPER = 100;
		private boolean[][] paper;
		
		public WhitePaper() {
			paper = new boolean[SIZEOFPAPER][SIZEOFPAPER];
		}
		
		public void attachColorPaper(int x, int y, int size) {
			if (x < 0 || y < 0 || x + size > 100 || y + size > 100) {
				System.out.println("Input Error!");
				System.exit(1);
			}

			for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
					if (!paper[i][j]) {
						paper[i][j] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		WhitePaper paper = new WhitePaper();
		int n = in.nextInt();
		if (n > 100 || n < 1) {
			System.exit(1);
		}
		
		for (int i = 0; i < n; i++) {
			paper.attachColorPaper(in.nextInt(), in.nextInt(), 10);
		}
		in.close();
		
		n = WhitePaper.SIZEOFPAPER;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (paper.paper[i][j]) {
					try {
						if (!paper.paper[i - 1][j]) {
							count++;
						}
					} catch (Exception e) {
						count++;
					}
					try {
						if (!paper.paper[i + 1][j]) {
							count++;
						}
					} catch (Exception e) {
						count++;
					}
					try {
						if (!paper.paper[i][j - 1]) {
							count++;
						}
					} catch (Exception e) {
						count++;
					}
					try {
						if (!paper.paper[i][j + 1]) {
							count++;
						}
					} catch (Exception e) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
