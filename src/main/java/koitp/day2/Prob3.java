package koitp.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob3 {
	public static int M;	// ���α���
	public static int N;	// ���α���
	public static int[] map;
	public static boolean[][] check;
	public static int[] count;
	public static int[][] cache;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= C; test_case++) {
			st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			final int MAX_STATE = 1 << N;
			
			map = new int[M];
			check = new boolean[MAX_STATE][MAX_STATE];
			count = new int[MAX_STATE];
			cache = new int[M][MAX_STATE];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine().trim(), ".x", true);
				while (st.hasMoreTokens()) {
					if (st.nextToken().equals("x")) {
						map[i]++;
					}
					map[i] <<= 1;
				}
				map[i] >>= 1;
			}
			
			
			for (int i = 0; i < MAX_STATE; i++) {
				int temp = i;
				int cnt = 0;
				while (temp != 0) {
					temp -= temp & -temp;
					cnt++;
				}
				count[i] = cnt;
				
				for (int j = 0; j < MAX_STATE; j++) {
					if ((i & (j << 1)) == 0 && (i & (j >>> 1)) == 0) {
						check[i][j] = true;
					}
				}
			}
			
			for (int s = 0; s < MAX_STATE; s++) {
				if (check[s][s] && ((s & map[0]) == 0)) {
					cache[0][s] = count[s];
				}
			}
			
			for (int row = 1; row < M; row++) {
				for (int nextState = 0; nextState < MAX_STATE; nextState++) {
					if (!check[nextState][nextState] ||(nextState & map[row]) != 0) {
						continue;
					}
					
					for (int prevState = 0; prevState < MAX_STATE; prevState++) {
						if (check[prevState][nextState]) {
							cache[row][nextState] = Math.max(cache[row][nextState], cache[row - 1][prevState] + count[nextState]);
						}
					}
				}
			}
			
			int result = 0;
			for (int s = 0; s < MAX_STATE; s++) {
				result = Math.max(result, cache[M - 1][s]);
			}
			
			System.out.println(result);
		}
	}
}
