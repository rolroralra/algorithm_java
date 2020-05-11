package koitp.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob6_PibonacciMatrix {
	public static int N;
	public static final int MOD = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		int[][] mtx = new int[][]{{1, 1}, {1, 0}};
		N--;
		if (N == 0) {
			System.out.println(1);
			return;
		}
		
		int maxBit = 0;
		boolean[] isBitChecked = new boolean[32];
		for (int i = 0; i < 32; i++) {
			if (((N >> i) & 1) == 1) {
				maxBit = i;
				isBitChecked[i] = true;
			}
		}
		
		int[][][] cache = new int[maxBit + 1][2][2]; 
		
		cache[0][0][0] = mtx[0][0];
		cache[0][0][1] = mtx[0][1];
		cache[0][1][0] = mtx[1][0];
		cache[0][1][1] = mtx[1][1];
		
		for (int i = 1; i <= maxBit; i++) {
			for (int x = 0; x < 2; x++) {
				for (int y = 0; y < 2; y++) {
					for (int k = 0; k < 2; k++) {
						cache[i][x][y] += (int) (((long) cache[i - 1][x][k] * cache[i - 1][k][y]) % MOD);
						cache[i][x][y] %= MOD;
					}
				}
			}
		}
		
		mtx[0][0] = cache[maxBit][0][0];
		mtx[0][1] = cache[maxBit][0][1];
		mtx[1][0] = cache[maxBit][1][0];
		mtx[1][1] = cache[maxBit][1][1];
		int[][] temp = new int[2][2];
		for (int i = maxBit - 1; i >= 0; i--) {
			if (isBitChecked[i]) {
				for (int x = 0; x < 2; x++) {
					for (int y = 0; y < 2; y++) {
						temp[x][y] = 0;
						for (int k = 0; k < 2; k++) {
							temp[x][y] += (int) (((long) mtx[x][k] * cache[i][k][y]) % MOD);
							temp[x][y] %= MOD;
						}
					}
				}
				mtx[0][0] = temp[0][0];
				mtx[0][1] = temp[0][1];
				mtx[1][0] = temp[1][0];
				mtx[1][1] = temp[1][1];
			}
		}
		
		int result = (mtx[0][0] + mtx[0][1]) % MOD;
		System.out.println(result);
	}
}
