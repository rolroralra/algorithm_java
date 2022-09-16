package algorithm;

import java.util.Arrays;
						
public class LCS {	// LCS(Longest Common Subsequence) Algorithm
	public static void main(String[] args) {
		
		String s1 = new String("abcdefghijklmnopqrstuvwxyz");
		String s2 = new String("a0b0c0d0e0f0g0h0i0j0k0l0m0n0o0p0q0r0s0t0u0v0w0x0y0z0");
		
		// way1	- 반복문 DP
		int n1 = s1.length();
		int n2 = s2.length();
		int[][] LCS = new int[n1 + 1][n2 + 1];
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				}
				else {
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
				}
			}
		}
		System.out.println(LCS[n1][n2]);
		
		// way2	- 재귀함수 DP
		int[][] cache = new int[s1.length()][s2.length()];
		for (int i = 0; i < s1.length(); i++) {
			Arrays.fill(cache[i], -1);
		}
		System.out.println(lcs(s1.length() - 1, s2.length() - 1, s1, s2, cache));
	}
	
	public static int lcs(int i, int j, String s1, String s2, int[][] cache) {
		if (i < 0 || j < 0) {
			return 0;
		}
		
		if (cache[i][j] != -1) {
			return cache[i][j];
		}
		
		
		if (s1.charAt(i) == s2.charAt(j)) {
			cache[i][j] = lcs(i - 1, j - 1, s1, s2, cache) + 1;
			return cache[i][j];
		}
		else {
			cache[i][j] = Math.max(lcs(i - 1, j, s1, s2, cache), lcs(i, j - 1, s1, s2, cache));
			return cache[i][j];
		}
	}
}
