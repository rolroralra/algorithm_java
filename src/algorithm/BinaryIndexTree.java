package algorithm;

public class BinaryIndexTree {
	public static void main(String[] args) {
		int[] arr = new int[]{4, 6, 3, 2, 4, 3, 1};
		int n = arr.length;
		int size = 1;
		for (; size < n; size <<= 1);
		int[] indexTree = new int[2 * size - 1];
		for (int i = 0; i < size; i++) {
			if (i < n) {
				indexTree[size - 1 + i] = arr[i];
			}
			else {
				indexTree[size - 1 + i] = Integer.MIN_VALUE;
			}
		}
		
		for (int parent = size - 2; parent >= 0; parent--) {
			int left = 2 * parent + 1;
			int right = 2 * parent + 2;
			
			if (indexTree[left] > indexTree[right]) {
				indexTree[parent] = indexTree[left];
			}
			else {
				indexTree[parent] = indexTree[right];
			}
		}
		
		int start = 2 + size - 1;
		int end = 6 + size - 1;
		int max = Integer.MIN_VALUE;
		while (start < end) {
			if (start % 2 == 0) {
				max = Math.max(max, indexTree[start++]);
			}
			
			if (end % 2 == 1) {
				max = Math.max(max, indexTree[end--]);
			}
			
			
			start = (start - 1) >> 1;
			end = (end - 1) >> 1;
			
			if (start == end) {
				max = Math.max(max, indexTree[start]);
			}
		}
		System.out.println(max);
	}
}
