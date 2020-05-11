package koitp.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob2 {
	public static int N;
	public static int K;
	public static int[][] cache;
	public static final int MOD = (int) 1e9;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		cache = new int[K][N + 1];
		Arrays.fill(cache[0], 1);
		for (int k = 1; k < K; k++) {
			for (int p = 0; p <= N; p++) {
				for (int i = p; i <= N; i++) {
					cache[k][i] += cache[k - 1][i - p];
					cache[k][i] %= MOD;
				}
			}
		}
		
		System.out.println(cache[K - 1][N]);
	}
}
