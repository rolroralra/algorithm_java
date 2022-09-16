package koitp.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob4 {
	public static int N;
	public static char[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		arr = in.readLine().trim().toCharArray();
		N = arr.length;
		
		int size = N / 5 + (N % 5 == 0 ? 0 : 1);
		int remain = N % 5;
		if (remain == 0) {
			remain = 5;
		}
		char[][] temp = new char[size][5];
		
		int index = 0;
		
		for (int col = 0; col < 5 && index < N; col++) {
			int n = (col < remain ? size : size - 1); 
			for (int row = 0; row < n && index < N; row++) {
				int c = arr[index++] - 3;
				if (c < 'a') {
					c += 'z' - 'a' + 1;
				}
				temp[row][col] = (char) c;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < 5; j++) {
				if (temp[i][j] == '\0') {
					break;
				}
				sb.append(temp[i][j]);
			}
		}
		System.out.println(sb.toString());
	}	
}
