package koitp.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob5_SegmentTree {
	public static int N;
	public static int Q;
	public static int[] arr;
	public static long[] tree;
	public static int size;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		Q = Integer.parseInt(in.readLine().trim());
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		
		for (size = 1 ;size < N; size <<= 1);
		size = (size << 1) - 1;
		tree = new long[size];
		
		initialize(0, 0, N - 1);
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(in.readLine());
			int qType = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			switch (qType) {
			case 0:
				update(0, 0, N - 1, x - 1, y - arr[x - 1]);
				arr[x - 1] = y;
				break;
			case 1:
				sb.append(sum(0, 0, N - 1, x - 1, y - 1)).append("\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static long initialize(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start + end) >> 1;
		return tree[node] = initialize((node << 1) + 1, start, mid) + initialize(((node + 1) << 1), mid + 1, end);
	}
	
	public static long sum(int node, int start, int end, int targetLeft, int targetRight) {
		if (targetLeft <= start && end <= targetRight) {
			return tree[node];
		}
		
		if (targetRight < start || end < targetLeft) {
			return 0;
		}
		
		int mid = (start + end) >> 1;
		return sum((node << 1) + 1, start, mid, targetLeft, targetRight) 
				+ sum(((node + 1) << 1), mid + 1, end, targetLeft, targetRight);
	}
	
	public static void update(int node, int start, int end, int index, int changeValue) {
		if (index < start || end < index) {
			return;
		}
		
		int mid = (start + end) >> 1;
		tree[node] += changeValue;
		
		if (start != end) {
			update((node << 1) + 1, start, mid, index, changeValue);
			update(((node + 1) << 1), mid + 1, end, index, changeValue);
		}
	}
}
