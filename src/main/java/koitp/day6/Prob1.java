package koitp.day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine().trim());
		
		int[][] arr = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] cache = new int[N][N];
		
		cache[0][0] = arr[0][0];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cache[i][j] = Math.max(i > 0 ? cache[i - 1][j] : 0, j > 0 ? cache[i][j - 1] : 0) + arr[i][j];
			}
		}
		
		System.out.println(cache[N - 1][N - 1]);
	}
}
