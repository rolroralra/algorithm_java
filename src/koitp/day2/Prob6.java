package koitp.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob6 {
	public static int N;
	public static int M;
	public static int[] A;
	public static int[] B;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		B = new int[M];
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		if (N > M) {
			int[] temp = A;
			A = B;
			B = temp;
			
			N ^= M;
			M ^= N;
			N ^= M;
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int[][] dp = new int[N][M];
		dp[0][0] = Math.abs(A[0] - B[0]);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dp[i][j] = (i == 0 || j == 0 ? 0 : dp[i -1][j - 1]) + Math.abs(A[i] - B[j]);
				if (i < j) {
					dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
				}
				else if (i > j) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
				}
			}
		}
		System.out.println(dp[N - 1][M - 1]);
	}
}
