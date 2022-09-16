package algorithm;

import java.util.ArrayList;

public class LCA_N__ {	// LCA(Lowest Common Ancestor) Algorithm
	public static int[][] parent;
	public static int[] depth;
	public static boolean[] isNotRoot;
	public static int[][] relationTable;
	public static final int VERTEX_CNT = 8;
	public static int LOG_VERTEX;
	public static ArrayList<ArrayList<Integer>> adj;
	public static void main(String[] args) {
		relationTable = new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {5, 6}, {5, 7}};
		isNotRoot = new boolean[VERTEX_CNT];
		
		adj = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < VERTEX_CNT; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < relationTable.length; i++) {
			isNotRoot[relationTable[i][1]] = true;
			adj.get(relationTable[i][0]).add(relationTable[i][1]);
		}
		
		for (LOG_VERTEX = 0; (1 << LOG_VERTEX) < VERTEX_CNT; LOG_VERTEX++);
		
		
		
		
		for (int vertex = 0; vertex < VERTEX_CNT; vertex++) {
			if (!isNotRoot[vertex]) {
				depth[vertex] = 1;
				dfs(vertex);
			}
		}
		
		
		
		
		
		
		
		
		
	}
	
	public static void dfs(int vertex) {
		for (int nextVertex : adj.get(vertex)) {
			if (depth[nextVertex] == 0) {
				depth[nextVertex] = depth[vertex] + 1;
				dfs(nextVertex);
			}
		}
		
		
	}
	
	
}
