package koitp.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob2 {
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
			Arrays.fill(cache[i], -1);
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cache[M - 1][N - 1] = 1;
		System.out.println(dp(0, 0));
	}
	
	public static int dp(int row, int col) {
		if (cache[row][col] != -1) {
			return cache[row][col];
		}
		
		cache[row][col] = 0;
		for (int i = 0; i < 4; i++) {
			int nextRow = row + Dx[i];
			int nextCol = col + Dy[i];
			try {
				if (arr[row][col] > arr[nextRow][nextCol]) {
					cache[row][col] += dp(nextRow, nextCol);
					cache[row][col] %= MOD;	
				}
			} catch (Exception e) {
			}
		}
		
		return cache[row][col];
	}
}
