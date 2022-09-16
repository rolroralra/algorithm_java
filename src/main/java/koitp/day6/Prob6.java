package koitp.day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Prob6 {
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
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return -(o1[1] * o2[0] - o2[1] * o1[0]);
			}
		});
		
		long result = 0;
		long time = arr[0][0] << 1;
		for (int i = 1; i < N; i++) {
			result += time * arr[i][1];
			time += arr[i][0] << 1;
		}
		System.out.println(result);
	}
}
