package koitp.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob1 {
	public static int N;
	public static int M;
	public static int L;
	public static int[] X;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		X = new int[N + 1];
		int[] cache = new int[N + 1];
		Arrays.fill(cache, N + 1);
		int start = -1;
		for (int i = 0; i < N; i++) {
			X[i] = Integer.parseInt(in.readLine().trim());
			if (X[i] <= M) {
				cache[i] = 0;
			}
			else if (start == -1){
				start = i;
			}
		}
		X[N] = L;
		
		for (int i = start; i <= N; i++) {
			int index = Arrays.binarySearch(X, X[i] - M);
			if (index < 0) {
				index = -(index + 1);
			}
			
			for (int j = index; j < i; j++) {
				cache[i] = Math.min(cache[i], cache[j] + 1);
			}
		}
	
		System.out.println(cache[N]);
	}
}
