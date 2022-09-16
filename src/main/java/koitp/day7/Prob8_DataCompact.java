package koitp.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob8_DataCompact {
	public static int N;
	public static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		
		arr = new int[N][3];
		int[][] temp = new int[3 * N][];
		StringTokenizer st = null;
		int index = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arr[i][0] = s;
			arr[i][1] = e;
			arr[i][2] = h;
			
			temp[index][0] = s;
			temp[index++][1] = (i << 1);
			temp[index][0] = e;
			temp[index++][0] = (i << 1) + 1;
		}
		
		Arrays.sort(temp);
		index = 0;
		for (int i = 0; i < N; i++) {
			
		}
		
	}
}
