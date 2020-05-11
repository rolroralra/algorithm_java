package koitp.day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob3 {
	public static int N;
	public static char[] arr;
	public static int[][] cache;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		arr = in.readLine().trim().toCharArray();
		N = arr.length;
		
		cache = new int[N][];
		for (int i = 0; i < N; i++) {
			cache[i] = new int[N - i + 1];
			Arrays.fill(cache[i], -1);
			cache[i][0] = 0;
			cache[i][1] = 1;
		}
		
		int result = 1;
		for (int length = 2; length <= N; length++) {
			for (int s = 0; s <= N - length; s++) {
				int e = s + length - 1;
				if (arr[s] == arr[e] && cache[s + 1][length - 2] != -1) {
					cache[s][length] = cache[s + 1][length - 2] + 2;
					result = Math.max(result, cache[s][length]);
				}
				else {
					cache[s][length] = -1;
				}
			}
		}
		System.out.println(result);
	}
}
