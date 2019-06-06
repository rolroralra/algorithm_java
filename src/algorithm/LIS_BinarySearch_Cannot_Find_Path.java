package algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class LIS_BinarySearch_Cannot_Find_Path {	// LIS(Longest Increasing Subsequence) Algorithm
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 2, 2, 3, 1, 1, 2};
//		int[] arr = new int[]{8, 12, 15, 9, 13, 1, 14, 5};
		int n = arr.length;
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int index = Collections.binarySearch(list, arr[i]);
			if (index >= 0) {
				if (index + 1 >= list.size()) {
					list.add(arr[i]);
				}
				else {
					list.set(index + 1, arr[i]);
				}
			}
			else {
				index++;
				index *= -1;
				if (index >= list.size()) {
					list.add(arr[i]);
				}
				else {
					list.set(index, arr[i]);
				}
			}
		}
		
		System.out.println(list.size());
	}
}
