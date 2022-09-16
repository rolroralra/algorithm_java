package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Main1124 {
	
	static class WhitePaper {
		private static final int SIZEOFPAPER = 100;
		private int[][] paper;
		
		public WhitePaper() {
			paper = new int[SIZEOFPAPER][SIZEOFPAPER];
		}
		
		public void attachColorPaper(int x, int y, int size) {
			if (x < 0 || y < 0 || x + size > 100 || y + size > 100) {
				System.out.println("Input Error!");
				System.exit(1);
			}
			for (int i = x; i < x + size; i++) {
				for (int j = y; j < y + size; j++) {
					if (paper[i][j] == 0)
						paper[i][j] = 1;
				}
			}
		}
		
		public int upperMaxHeight(int x, int y) {
			if (paper[x][y] == 0) {
				return 0;
			}
			int height = 1;
			for (int i = x + 1; i < SIZEOFPAPER; i++) {
				if (paper[i][y] == 0) {
					break;
				}
				height++;
			}
			return height;
		}
		
		public int lowerMaxHeight(int x, int y) {
			if (paper[x][y] == 0) {
				return 0;
			}
			int height = 1;
			for (int i = x - 1; i >= 0; i--) {
				if (paper[i][y] == 0) {
					break;
				}
				height++;
			}
			return height;
		}
		public int rightMaxWidth(int x, int y) {
			if (paper[x][y] == 0) {
				return 0;
			}
			int length = 1;
			for (int i = y + 1; i < SIZEOFPAPER; i++) {
				if (paper[x][i] == 0) {
					break;
				}
				length++;
			}
			return length;
		}
		
		public int leftMaxWidth(int x, int y) {
			if (paper[x][y] == 0) {
				return 0;
			}
			int length = 1;
			for (int i = y - 1; i >= 0; i--) {
				if (paper[x][i] == 0) {
					break;
				}
				length++;
			}
			return length;
		}
		
		public int upperMaxRectangleArea(int x, int y) {
			int height = upperMaxHeight(x, y);
			int width = 1;
			for (int i = y - 1; i >= 0; i--) {
				if (upperMaxHeight(x, i) < height) {
					break;
				}
				width++;
			}
			for (int i = y + 1; i < SIZEOFPAPER; i++) {
				if (upperMaxHeight(x, i) < height) {
					break;
				}
				width++;
			}
			//System.out.println("width : " + width + ", heigth : " + height + ", area : " + width * height);
			return width * height;
		}
		public int lowerMaxRectangleArea(int x, int y) {
			int height = lowerMaxHeight(x, y);
			int width = 1;
			for (int i = y - 1; i >= 0; i--) {
				if (lowerMaxHeight(x, i) < height) {
					break;
				}
				width++;
			}
			for (int i = y + 1; i < SIZEOFPAPER; i++) {
				if (lowerMaxHeight(x, i) < height) {
					break;
				}
				width++;
			}
			//System.out.println("width : " + width + ", heigth : " + height + ", area : " + width * height);
			return width * height;
		}
		
		public int rigthMaxRectangleArea(int x, int y) {
			int width = rightMaxWidth(x, y);
			int height = 1;
			for (int i = x - 1; i >= 0; i--) {
				if (rightMaxWidth(i, y) < width) {
					break;
				}
				height++;
			}
			for (int i = x + 1; i < SIZEOFPAPER; i++) {
				if (rightMaxWidth(i, y) < width) {
					break;
				}
				height++;
			}
			//System.out.println("width : " + width + ", heigth : " + height + ", area : " + width * height);
			return width * height;
		}
		
		public int leftMaxRectangleArea(int x, int y) {
			int width = leftMaxWidth(x, y);
			int height = 1;
			for (int i = x - 1; i >= 0; i--) {
				if (leftMaxWidth(i, y) < width) {
					break;
				}
				height++;
			}
			for (int i = x + 1; i < SIZEOFPAPER; i++) {
				if (leftMaxWidth(i, y) < width) {
					break;
				}
				height++;
			}
			//System.out.println("width : " + width + ", heigth : " + height + ", area : " + width * height);
			return width * height;
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
		int[] maxValues = new int[4];
		//int maxByRight = 0;   maxValues[0]
		//int maxByLeft = 0;	maxValues[1]
		//int maxByUpper = 0;	maxValues[2]
		//int maxByLower = 0;	maxValues[3]
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (paper.paper[i][j] != 0) {
					int tempMaxByRight = paper.rigthMaxRectangleArea(i, j);
					int tempMaxByLeft = paper.leftMaxRectangleArea(i, j);
					//int tempMaxByUpper = paper.upperMaxRectangleArea(i, j);
					//int tempMaxByLower = paper.lowerMaxRectangleArea(i, j);
					if (tempMaxByRight > maxValues[0]) {
						maxValues[0] = tempMaxByRight;
					}
					/*if (tempMaxByLeft > maxValues[1]) {
						maxValues[1] = tempMaxByLeft;
					}*/
					/*if (tempMaxByUpper > maxValues[2]) {
						maxValues[2] = tempMaxByUpper;
					}	
					if (tempMaxByLower > maxValues[3]) {
						maxValues[3] = tempMaxByLower;
					}*/
				}
			}
		}
		
		Arrays.sort(maxValues);
		System.out.println(maxValues[3]);
	}
}

