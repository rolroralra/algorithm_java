package algorithm;

public class BinaryIndexTree_SegmentTree {
	public static int[] tree;
	public static void main(String[] args) throws Exception {
		int[] arr = new int[]{4, 6, 3, 2, 4, 3, 1};
		int N = arr.length;

		int size = 1;

		for (; size < N; size <<= 1);
		size = (size << 1) - 1;

		tree = new int[size];
		
		for (int i = 0; i < N; i++) {
			update(0, N - 1, 0, i, arr[i]);
		}

		int left = 1;
		int right = 4;

		System.out.println(sum1(0, N - 1, 0, left, right));
		System.out.println(sum2(0, N - 1, 0, left, right));

//
//		SegmentTree segmentTree = new SegmentTree(arr);
//		System.out.println(segmentTree.sum(left, right));
//
//		int totalCnt = 0;
//		int cnt = 0;
//		for (int i = 0; i < N; i++) {
//			for (int j = i; j < N; j++) {
//				int result1 = sum1(0, N-1, 0, i, j);
//				int result2 = sum2(0, N-1, 0, i, j);
//				int result3 = segmentTree.sum(i,j);
//				System.out.println("sum1(" + i +","+j +")= " + result1);
//				System.out.println("sum2(" + i +","+j +")= " + result2);
//				System.out.println("segmentTree.sum(" + i +","+j +")= " + result3);
//
//				totalCnt++;
//				if (result1 == result2 && result2 == result3) {
//					cnt++;
//				}
//			}
//		}
//		System.out.println();
//		System.out.println("Count Of Success: " + cnt + ", Total Count : " + totalCnt);
		
	}

	public static void update(int start, int end, int node, int index, int diffValue) {
		// Escaping Condition : index is not in segment [start, end]
		if (index < start || end < index) {
			return;
		}

		// index is in segment [start, end] ==> must be updated!
		if (start <= index && index <= end) {
			tree[node] += diffValue;
		}

		// When start == end, it must be leaf node in Segment Tree.
		if (start != end) {
			int mid = (start + end) >> 1;
			int leftNode = (node << 1) + 1;
			int rightNode = leftNode + 1;
			update(start, mid, leftNode, index, diffValue);
			update(mid + 1, end, rightNode, index, diffValue);
		}
	}

	public static int sum1(int start, int end, int node, int left, int right) {
		// [left, right] is not in [start, end]
		if (left > end || right < start) {
			return 0;
		}

		// [left , right] > [start, end]
		if (left <= start && right >= end) {
			return tree[node];
		}
		
		int mid = (start + end) >> 1;
		int leftNode = (node << 1) + 1;
		int rightNode = leftNode + 1;
		return sum1(start, mid, leftNode, left, right) + sum1(mid + 1, end, rightNode, left, right);
	}
	
	public static int sum2(int start, int end, int node, int left, int right) {
		if (start == left && end == right) {
			return tree[node];
		}
		
		int mid = (start + end) >> 1;
		int leftNode = (node << 1) + 1;
		int rightNode = leftNode + 1;
		
		if (right <= mid) {		// 왼쪽 구간만 호출
			return sum2(start, mid, leftNode, left, right);
		}
		else if (mid + 1 <= left) {	// 오른쪽 구간만 호출
			return sum2(mid + 1, end, rightNode, left, right);
		}
		else {	// 양쪽 구간 모두 호출
			return sum2(start, mid, leftNode, left, mid) + sum2(mid + 1, end, rightNode, mid + 1, right);
		}
	}
}
