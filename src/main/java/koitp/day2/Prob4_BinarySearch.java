package koitp.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob4_BinarySearch {
	public static int N;
	public static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine().trim());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine().trim());
		}
		
		Arrays.sort(arr);
		
		int maxCnt = 0;
		int result = 0;
		int key = 0;
		while (key < N) {
			int s = key;
			int e = N - 1;
			int upperBound = -1;
			while (s <= e) {
				int mid = (s + e) >> 1;
				if (arr[mid] <= arr[key]) {
					s = mid + 1;
					upperBound = mid;
				}
				else {
					e = mid - 1;
				}
			}
			
			if (maxCnt < upperBound - key + 1) {
				maxCnt = upperBound - key + 1;
				result = arr[key];
			}
			
			key = upperBound + 1;
		}
		System.out.println(result);
	}
}
