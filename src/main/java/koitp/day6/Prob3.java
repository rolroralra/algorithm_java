package koitp.day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob3 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine().trim());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(in.readLine(), "01", true);
		for (int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][][] cache = new int[N][N][];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				cache[i][j] = new int[]{0, 0};
			}
		}
		
		for (int gap = 1; gap < N; gap += 2) {
			for (int i = 0; i < N - gap; i++) {
				int j = i + gap;
				cache[i][j] = new int[]{Integer.MAX_VALUE, 0};
				for (int k = i + 1; k <= j; k += 2) {
					if (cache[i][k] == null || k + 1 >= N || cache[k + 1][j] == null) {
						continue;
					}
					
					int temp = cache[i][k][0] + cache[k + 1][j][0];
					if (cache[i][j][0] >  temp) {
						cache[i][j][0] = temp;
						cache[i][j][1] = Math.max(cache[i][k][1], cache[k + 1][j][1]);
					}
				}
				
				if (arr[i] != arr[j] && cache[i + 1][j - 1] != null) {
					int height = cache[i + 1][j - 1][1] + 1;
					int length = cache[i + 1][j - 1][0] + gap + (height << 1);
					if (cache[i][j][0] == Integer.MAX_VALUE || cache[i][j][0] > length) {
						cache[i][j][0] = length;
						cache[i][j][1] = height;
					}
				}
				
				if (cache[i][j][0] == Integer.MAX_VALUE) {
					cache[i][j] = null;
				}
			}	
		}
		
		System.out.println(cache[0][N - 1][0]);
	}
}
