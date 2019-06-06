package algorithm;

import java.util.Arrays;

public class LIS_DP_Recursive {	// LIS(Longest Increasing Subsequence) Algorithm
	public static int N;
	public static int[] cache;
	public static int[] arr;
	public static void main(String[] args) {
		arr = new int[]{17, 12, 15, 9, 13, 1, 14, 5};
		N = arr.length;
		cache = new int[N];
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max(result, dp(i));
		}
		System.out.println(result); 
	}
	
	public static int dp(int index) {
		if (cache[index] != 0) {
			return cache[index];
		}
		
		cache[index] = 1;
		
		for (int i = index + 1; i < N; i++) {
			if (arr[i] > arr[index]) {
				cache[index] = Math.max(cache[index], dp(i) + 1);
			}
		}
		
		return cache[index];
	}
}
