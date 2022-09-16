package koitp.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Prob2 {
	public static int N;
	public static int[][] arr;
	public static int[] tree;
	public static int scale;
	public static int size;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		
		arr = new int[N][2];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++ ) {
			arr[i][0] = Integer.parseInt(st.nextToken());		// ��
			arr[i][1] = i;										// index
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
			}
		});
		
		size = 1;
		for (; size < N; size <<= 1);
		scale = size - 1;
		size = (size << 1) - 1;
		tree = new int[size];
		
		for (int i = 0; i < N; i++) {
			int index = arr[i][1];
			int[] LIS = max(0, N - 1, 0, 0, index);
			update(0, N - 1, 0, index, LIS[0] + 1);
		}
		
		System.out.println(max(0, N - 1, 0, 0, N - 1)[0]);
	}
	
	public static int[] max(int start, int end, int node, int left, int right) {
		if (right < start || end < left) {
			return new int[]{0, -1};
		}
		if (left <= start && end <= right) {
			return new int[]{tree[node], start};
		}
		
		int mid = (start + end) >> 1;
		
		int leftChildNode = (node << 1) + 1;
		int rightChildNode = leftChildNode + 1;
		int[] temp1 = max(start, mid, leftChildNode, left, right);
		int[] temp2 = max(mid + 1, end, rightChildNode, left, right);
		
		if (temp1[0] < temp2[0]) {
			return temp2;
		}
		else {
			return temp1;
		}
	}
	
	public static void update(int start, int end, int node, int index, int value) {
		if (index < start || end < index) {
			return;
		}
		
		tree[node] = Math.max(tree[node], value);
		
		if (start != end) {
			int mid = (start + end) >> 1;
			
			int leftChildNode = (node << 1) + 1;
			int rightChildNode = leftChildNode + 1;
			update(start, mid, leftChildNode, index, value);
			update(mid + 1, end, rightChildNode, index, value);
		}
	}
	
}
