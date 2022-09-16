package koitp.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1 {
	public static int N;
	public static int K;
	public static final int MOD = 1000000;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] cache = new int[K + 1];
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine().trim());
		}
		
		for (int k = 0; k <= K; k++) {
			if (k % arr[0] == 0) {
				cache[k] = 1;
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int k = 0; k <= K; k++) {
				if (k - arr[i] >= 0) {
					cache[k] = cache[k] + cache[k - arr[i]];
					cache[k] %= MOD;
				}
			}
		}
		
		System.out.println(cache[K]);
	}
}
