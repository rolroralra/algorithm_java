package algorithm;

public class BinaryIndexTree_SegmentTree {
	public static int[] tree;
	public static void main(String[] args) {
		int[] arr = new int[]{4, 6, 3, 2, 4, 3, 1};
		int N = arr.length;
		
		int size = 1;
		for (; size < N; size <<= 1);
		size = (size << 1) - 1;
		
		tree = new int[size];
		
		for (int i = 0; i < N; i++) {
			update(0, N - 1, 0, i, arr[i]);
		}
		
		System.out.println(sum2(0, N - 1, 0, 1, 4));
		
	}
	
	public static void update(int start, int end, int node, int index, int value) {
		if (index < start || end < index) {
			return;
		}
		
		if (start <= index && index <= end) {
			tree[node] += value;
		}
		
		if (start != end) {
			int mid = (start + end) >> 1;
			int leftNode = (node << 1) + 1;
			int rightNode = leftNode + 1;
			update(start, mid, leftNode, index, value);
			update(mid + 1, end, rightNode, index, value);
		}
	}
	
	public static int sum1(int start, int end, int node, int left, int right) {
		if (left < start || end < right) {
			return 0;
		}
		
		if (left <= start && end <= right) {
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
