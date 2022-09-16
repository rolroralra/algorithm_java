package algorithm;

import java.util.Arrays;

public class LIS_DP {	// LIS(Longest Increasing Subsequence) Algorithm
	public static void main(String[] args) {
		int[] arr = new int[]{8, 12, 15, 9, 13, 1, 14, 5};
		int n = arr.length;
		int result = 0;
		int[] memo = new int[n];
		Arrays.fill(memo, 1);
		
		for (int i = 0; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j] && memo[j] + 1 > memo[i]) {
					memo[i] = memo[j] + 1;
				}
 			}
			if (result < memo[i]) {
				result = memo[i];
			}
		}
//		System.out.println(result);
		System.out.println(memo[n - 1]);
	}
}
