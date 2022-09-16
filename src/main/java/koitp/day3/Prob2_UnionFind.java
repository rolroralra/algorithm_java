package koitp.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob2_UnionFind {
	public static int N;
	public static int Q;
	public static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		Q = Integer.parseInt(in.readLine().trim());
		
		parent = new int[N];
		Arrays.fill(parent, -1);
		
		StringTokenizer st = null;
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(in.readLine());
			int qType = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			switch (qType) {
			case 0:
				union(a, b);
				break;
			case 1:
				int rootA = find(a);
				int rootB = find(b);
				if (rootA == rootB) {
					System.out.println("1");
				}
				else {
					System.out.println("0");
				}
				break;
			}
		}
	}

	
	public static void union(int i, int j) {
		int root1 = find(i);
		int root2 = find(j);
		
		if (root1 == root2) {
			return;
		}
		
		if (parent[root1] > parent[root2]) {
			root1 ^= root2;
			root2 ^= root1;
			root1 ^= root2;
		}
		
		parent[root1] += parent[root2];
		parent[root2] = root1;
	}
	
	public static int find(int i) {
		int root = i;
		while (parent[root] >= 0) {
			root = parent[root];
		}
		
		while (i != root) {
			int next = parent[i];
			parent[i] = root;
			i = next;
		}
		return root;
	}
}
