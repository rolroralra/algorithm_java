package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class LCA_logN {
	public static int N;
	public static ArrayList<ArrayList<Integer>> list;
	public static int[] depth;
	public static int[][] parent;
	public static int LOGN;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			
			list.get(s).add(e);
			list.get(e).add(s);
		}
		
		for (LOGN = 0; (1 << LOGN) < N; LOGN++);
		parent = new int[N][LOGN + 1];
		for (int i = 0; i < N; i++) {
			Arrays.fill(parent[i], -1);
		}
		depth = new int[N];
		
		Stack<Integer> stack = new Stack<Integer>();
		depth[0] = 1;
		stack.push(0);
		
		while (!stack.empty()) {
			int curr = stack.pop();
			
			for (int next : list.get(curr)) {
				if (depth[next] != 0) {
					continue;
				}
				
				parent[next][0] = curr;
				for (int i = 1; i <= LOGN; i++) {
					if (parent[next][i - 1] == -1) {
						break;
					}
					parent[next][i] = parent[parent[next][i - 1]][i - 1];
				}
				depth[next] = depth[curr] + 1;
				
				stack.push(next);
			}
		}
		
		long result = 0;
		for (int i = 0; i < N - 1; i++) {
			int lca = LCA(i, i + 1);
			
			result += depth[i] + depth[i + 1] - (depth[lca] << 1);
		}
		System.out.println(result);
	}
	
	public static int LCA(int a, int b) {
		if (depth[a] < depth[b]) {
			a ^= b;
			b ^= a;
			a ^= b;
		}
		
		for (int i = LOGN; i >= 0 && depth[a] != depth[b]; i--) {
			if (depth[a] - depth[b] >= (1 << i)) {
				a = parent[a][i];
			}
		}
		
		if (a == b) {
			return a;
		}
		
		for (int i = LOGN; i >= 0; i--) {
			if (parent[a][i] != -1 && parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		
		return parent[a][0];
	}
}
