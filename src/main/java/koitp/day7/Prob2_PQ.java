package koitp.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prob2_PQ {
	public static int N;
	public static int M;
	public static int[][] arr;
	public static int[] Dx = new int[]{1, -1, 0, 0};
	public static int[] Dy = new int[]{0, 0, 1, -1};
	public static int[][] cache;
	public static final int MOD = 1234567;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		cache = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return arr[o2[0]][o2[1]] - arr[o1[0]][o1[1]];
			}
		});
		
		cache[0][0] = 1;
		boolean[][] isChecked = new boolean[M][N];
		isChecked[0][0] = true;
		queue.add(new int[]{0, 0});
		while (!queue.isEmpty()) {
			int[] state = queue.poll();
			int row = state[0];
			int col = state[1];
			
			
			for (int i = 0; i < 4; i++) {
				int nextRow = row + Dx[i];
				int nextCol = col + Dy[i];
				try {
					if (isChecked[nextRow][nextCol]) {
						if (arr[row][col] < arr[nextRow][nextCol]) {
							cache[row][col] += cache[nextRow][nextCol];
							cache[row][col] %= MOD;	
						}
					}
					else {
						if (arr[row][col] > arr[nextRow][nextCol]) {
							isChecked[nextRow][nextCol] = true;
							queue.add(new int[]{nextRow, nextCol});
						}
					}
				} catch (Exception e) {
				}
			}
			
			if (row == M - 1 && col == N - 1) {
				break;
			}
		}
		
		System.out.println(cache[M - 1][N - 1]);
	}
}
