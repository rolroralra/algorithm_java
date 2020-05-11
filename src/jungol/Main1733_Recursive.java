package jungol;

import java.util.Scanner;

public class Main1733_Recursive {
	private static int[][] checkerBoard = null;
	private static final int EMPTY = 0;
	//private static final int BLACK = 1;
	//private static final int WHITE = 2;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		final int SIZE = 19;
		checkerBoard = new int[SIZE][SIZE];
		int result = 0;
		int[] resultPosition = new int[2];
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				checkerBoard[i][j] = in.nextInt();
			}
		}
		in.close();
		
		for (int i = 0; i < SIZE && result == 0; i++) {
			for (int j = 0; j < SIZE && result == 0; j++) {
				int color = checkerBoard[j][i];
				if (color != EMPTY) {
					if (checkFiveStone(j, i, color)) {
						result = color;
						resultPosition[0] = j + 1;
						resultPosition[1] = i + 1;
					}
				}
			}
		}
		
		System.out.println(result);
		if (result != 0) {
			System.out.println(resultPosition[0] + " " + resultPosition[1]);
		}
	}
	public static boolean checkFiveStone(int x, int y, int color) {
		if (checkerBoard[x][y] != color) {
			return false;
		}
		// direction 가로 방향 오목 체크, (4, 8)
		if ((countStraightStone(x, y, 4, color) + countStraightStone(x, y - 1, 8, color)) == 5) {
			return true;
		}
		// direction 세로 방향 오목 체크, (2, 6)
		else if ((countStraightStone(x, y, 2, color) + countStraightStone(x + 1, y, 6, color)) == 5) {
			return true;
		}
		// direction 대각선 방향 오목 체크, (1, 5)
		else if ((countStraightStone(x, y, 1, color) + countStraightStone(x + 1, y + 1, 5, color)) == 5) {
			return true;
		}
		// direction 대각선 방향 오목 체크, (3, 7)
		else if ((countStraightStone(x, y, 3, color) + countStraightStone(x + 1, y - 1, 7, color)) == 5) {
			return true;
		}
		return false;
	}
	
	public static int countStraightStone(int x, int y, int direction, int color) {
		try {
			if (checkerBoard[x][y] == EMPTY) {
				return 0;
			}
			else if (checkerBoard[x][y] == color) {
				switch(direction) {
				case 1:	x--; y--;	break;
				case 2: x--;	 	break;
				case 3: x--; y++;	break;
				case 4: y++;		break;
				case 5: x++; y++;	break;
				case 6:	x++;		break;
				case 7: x++; y--;	break;
				case 8:	y--;		break;
				}
				return (1 + countStraightStone(x, y, direction, color));
			} 
			return 0;
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
}
