package koitp.day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Prob7_LIS_IndexTree2 {
	public static int N;
	public static int[][] arr;
	public static int[] tree;
	public static int n;
	public static int size;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		
		arr = new int[N][2];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = i;
		}
		
		for (size = 1; size < N; size <<= 1);
		n = size;
		size = (size << 1) - 1;
		tree = new int[size];
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
			}
		});
		
		for (int i = 0; i < N; i++) {
			int index = arr[i][1];
			update(0, N - 1, 0, index, max(0, N - 1, 0, 0, index - 1) + 1);
		}
		
		System.out.println(max(0, N - 1, 0, 0, N - 1));
	}
	
	
	public static void update(int start, int end, int node, int index, int value) {
		if (index < start || end < index) {
			return;
		}
		
		tree[node] = Math.max(tree[node], value);
		
		if (start != end) {
			int mid = (start + end) >> 1;
			int leftNode = (node << 1) + 1;
			int rightNode = leftNode + 1;
			update(start, mid, leftNode, index, value);
			update(mid + 1, end, rightNode, index, value);
		}
	}
	
	public static int max(int start, int end, int node, int left, int right) {
		if (right < start || end < left) {
			return 0;
		}
		
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		int ret = 0;
		int mid = (start + end) >> 1;
		int leftNode = (node << 1) + 1;
		int rightNode = leftNode + 1;
		ret = Math.max(ret, max(start, mid, leftNode, left, right));
		ret = Math.max(ret, max(mid + 1, end, rightNode, left, right));
 		return ret;
	}
	
}
