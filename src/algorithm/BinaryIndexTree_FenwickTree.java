package algorithm;

public class BinaryIndexTree_FenwickTree {
	
	public static int[] tree;
	public static int N;
	public static void main(String[] args) {
		int[] arr = new int[]{4, 6, 3, 2, 4, 3, 1};
		N = arr.length;
		
		tree = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			update(i + 1, arr[i]);
		}
		
		System.out.println(sum(4));
	}	
	
	
	// sum[index] = arr[0] + arr[1] + ..... arr[index - 1]
	public static int sum(int index) {
		int ret = 0;
		while (index > 0) {
			ret += tree[index];
			index -= index & -index;
		}
		return ret;
	}
	
	// update(index, value) : arr[index - 1] 의 값을 value만큼 update (arr[index - 1] += value;
	public static void update(int index, int value) {
		while (index <= N) {
			tree[index] += value;
			index += index & -index;
		}
	}
}
