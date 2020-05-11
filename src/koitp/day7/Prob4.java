package koitp.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob4 {
	public static int N;
	public static int[][] arr;
	public static int[] result;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		arr = new int[N][N];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = new int[2];
		parse(0, 0, N);
		
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	
	public static int parse(int row, int col, int size) {
		if (((size & 1) ^ 1) == 0) {
			return arr[row][col];
		}
		
		int halfSize = size >> 1;
		
			
		int[] temp = new int[4];
		temp[0] = parse(row, col, halfSize);
		temp[1] = parse(row + halfSize, col, halfSize);
		temp[2] = parse(row, col + halfSize, halfSize);
		temp[3]  = parse(row + halfSize, col + halfSize, halfSize);
		
		if (temp[0] != -1 && temp[0] == temp[1] && temp[1] == temp[2] && temp[2] == temp[3]) {
			return temp[0];
		}
		
		for (int i = 0; i < 4; i++) {
			if (temp[i] == -1) {
				continue;
			}
			result[temp[i]]++;
		}
		return -1;
	}
	
}
