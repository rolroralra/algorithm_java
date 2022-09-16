package koitp.day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = in.readLine().trim().toCharArray();
		int N = arr.length;
		
		char[][] bridge = new char[2][];
		
		bridge[0] = in.readLine().trim().toCharArray();
		bridge[1] = in.readLine().trim().toCharArray();
		int M = bridge[0].length;
		
		int[][][] cache = new int[2][M][N];
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 2; k++) {
					cache[k][i][j] = (i > 0 ? cache[k][i - 1][j] : 0) 
							+ (bridge[k][i] == arr[j] ? (j > 0 ? (i > 0 ? cache[1 - k][i - 1][j - 1] : 0) : 1) : 0);
				}
			}
		}
		
		int result = cache[0][M - 1][N - 1] + cache[1][M - 1][N - 1];
		System.out.println(result);
	}
}
