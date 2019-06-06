package algorithm;

import java.util.ArrayList;
import java.util.Stack;

public class LIS_BinarySearch {	// LIS(Longest Increasing Subsequence) Algorithm
	public static void main(String[] args) {
		int[] arr = new int[]{8, 12, 15, 9, 13, 1, 14, 5};
//		int[] arr = new int[]{1, 2, 2, 2, 3, 1, 1, 2};			// BinarySearch로 LIS 구하는 경우.. 동일값에 대한 처리... 필요..
		int n = arr.length;
		
		ArrayList<int[]> list = new ArrayList<>();
		int[] trace = new int[n];
		for (int i = 0; i < n; i++) {
			int index = binarySearch(list, 0, list.size() - 1, arr[i]);
			int[] temp = new int[]{arr[i], i};
			if (index >= 0) {
//				System.out.println("!");			// BinarySearch로 LIS 구하는 경우.. 동일값에 대한 처리... 필요..
//				index++;
//				trace[i] = list.get(index - 1)[1];
//				if (index >= list.size()) {
//					list.add(temp);
//				}
//				else {
//					list.set(index, temp);
//				}
			}
			else {
				index = -(index + 1);
				if (index == 0) {
					trace[i] = -1;
				}
				else if (index > 0){
					trace[i] = list.get(index - 1)[1];
				}
				if (index >= list.size()) {
					list.add(temp);
				}
				else {
					list.set(index, temp);
				}
			}
		}
		
		System.out.println(list.size());
		int index = list.get(list.size() -1)[1];
		Stack<Integer> stack = new Stack<>();
		while (index >= 0) {
			stack.push(arr[index]);
			index = trace[index];
		}
		while (!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}
	
	public static int binarySearch(ArrayList<int[]> list, int start, int end, int key) {
		if (start > end) {
			return -(start + 1);
		}
		
		int mid = (start + end) / 2;
		int midValue = list.get(mid)[0];
		if (midValue < key) {
			return binarySearch(list, mid + 1, end, key);
		}
		else if (midValue > key) {
			return binarySearch(list, start, mid - 1, key);
		}
		return mid;
	}
}
