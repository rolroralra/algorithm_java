package koitp.day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob1 {
	public static int N;
	public static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine().trim());
		arr = new int[N][2];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		long[] min = new long[3];
		int[][] result = new int[3][2];
		Arrays.fill(min, Long.MAX_VALUE);
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int type = 0; type < 3; type++) {
					long temp = distacne(i, j, type);
					if (min[type] > temp) {
						min[type] = temp;
						
						result[type][0] = i + 1;
						result[type][1] = j + 1;
					}
				}
			}
		}
		
		for (int type = 0; type < 3; type++) {
			System.out.println(result[type][0] + " " + result[type][1]);
		}
	}

	
	public static long distacne(int i, int j, int type) throws Exception {
		long dx = 0;
		long dy = 0;
		switch (type) {
		case 0:
			return (arr[i][0] - arr[j][0]) * (arr[i][0] - arr[j][0]) + (arr[i][1] - arr[j][1]) * (arr[i][1] - arr[j][1]);
		case 1:
			dx = Math.abs(arr[i][0] - arr[j][0]);
			dy = Math.abs(arr[i][1] - arr[j][1]);
			return dx + dy;
		case 2:
			dx = Math.abs(arr[i][0] - arr[j][0]);
			dy = Math.abs(arr[i][1] - arr[j][1]);
			return Math.max(dx, dy);
		}
		throw new Exception();
	}
}
