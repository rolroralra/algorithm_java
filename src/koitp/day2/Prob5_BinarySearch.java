package koitp.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob5_BinarySearch {
	public static final int CM = (int) 1e7;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(in.readLine().trim());
		
		int n = Integer.parseInt(in.readLine().trim());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in.readLine().trim());
		}
		
		Arrays.sort(arr);
		
		x *= CM;
		int[] L = new int[2];
		int result = -1;
		for (int L1 = 0; L1 < n - 1; L1++) {
			int s = L1 + 1;
			int e = n - 1;
			
			if (arr[L1] + arr[e] < x || arr[L1] + arr[s] > x) {
				continue;
			}
			else if (arr[L1] + arr[e] == x) {
				int temp = arr[e] - arr[L1];
				if (result < temp) {
					result = temp;
					L[0] = L1;
					L[1] = e;
				}
				continue;
			}
			
			if (arr[e] - arr[L1] <= result) {
				continue;
			}
			
			int L2 = -1;
			while (s <= e) {
				int mid = (s + e) >> 1;
				int value = arr[L1] + arr[mid];
				if (value < x) {
					s = mid + 1;
				}
				else if (value > x) {
					e = mid - 1;
				}
				else {
					L2 = mid;
					break;
				}
			}
			
			if (L2 != -1) {
				int temp = arr[L2] - arr[L1];
				if (result < temp) {
					result = temp;
					L[0] = L1;
					L[1] = L2;
				}
			}
		}
		
		if (result == -1) {
			System.out.println("danger");
		}
		else {
			System.out.println("yes " + arr[L[0]] + " " + arr[L[1]]);
		}
	}
}