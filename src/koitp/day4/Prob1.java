package koitp.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prob1 {
	public static int W;
	public static int H;
	public static int[][] distance;
	public static int[] Dx = new int[]{1, -1, 0, 0};
	public static int[] Dy = new int[]{0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		
		int sRow = 0;
		int sCol = 0;
		int eRow = 0;
		int eCol = 0;
		
		distance = new int[H][W];
		for (int i = 0 ; i < H; i++) {
			st = new StringTokenizer(in.readLine(), "OXSE", true);
			for (int j = 0; j < W; j++) {
				switch (st.nextToken().charAt(0)) {
				case 'O':
					distance[i][j] = -1;
					break;
				case 'X':
					distance[i][j] = -2;
					break;
				case 'S':
					distance[i][j] = 0;
					sRow = i;
					sCol = j;
					break;
				case 'E':
					distance[i][j] = -1;
					eRow = i;
					eCol = j;
					break;
				}
			}
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[]{sRow, sCol});
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int currRow = pos[0];
			int currCol = pos[1];
			
			if (currRow == eRow && currCol == eCol) {
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nextRow = currRow + Dx[i];
				int nextCol = currCol + Dy[i];
				
				if (isInside(nextRow, nextCol) && distance[nextRow][nextCol] == -1) {
					distance[nextRow][nextCol] = distance[currRow][currCol] + 1;
					queue.add(new int[]{nextRow, nextCol});
				}
			}
		}
		
		System.out.println(distance[eRow][eCol]);
	}
	
	public static boolean isInside(int row, int col) {
		return row >= 0 && row < H && col >= 0 && col < W;
	}
}
