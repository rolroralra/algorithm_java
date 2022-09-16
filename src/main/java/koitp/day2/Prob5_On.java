package koitp.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob5_On {
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
		
		int i = 0;
		int j = n - 1;
		while (i < j) {
			int sum = arr[i] + arr[j];
			if (sum == x) {
				L[0] = i;
				L[1] = j;
				break;
			}
			else if (sum > x) {
				j--;
			}
			else {
				i++;
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