package algorithm;

import java.util.Arrays;

public class UnionFind {
	public static int[] parent;
	public static int[] rank;		// rank 및 depth 이용해서 하는 개선 알고리즘도 있다고 함... 나중에 조사해보자.
	public static int VertexCnt;	// Vertex 총 개수
	public static void main(String[] args) {
		VertexCnt = 10;
		parent = new int[VertexCnt];
		Arrays.fill(parent, -1);
		
		union(0, 1);
		System.out.println(findByLoop(1));
		union(2, 3);
		System.out.println(findByLoop(3));
		union(1, 2);
		System.out.println(findByLoop(3));
	}
	
	public static int findByLoop(int index) {
		int root = index;
		while (parent[root] >= 0) {
			root = parent[root];
		}
		
		while (index != root) {
			int nextIndex = parent[index];
			parent[index] = root;
			index = nextIndex;
		}
		
		return root;
	}
	
	public static int findByRecursive(int index) {
		if (parent[index] < 0) {
			return index;
		}
		
		return parent[index] = findByRecursive(parent[index]);
	}
	
	public static void union(int i, int j) {
//		int root1 = findByLoop(i);
//		int root2 = findByLoop(j);
		i = findByRecursive(i);
		j = findByRecursive(j);
		
		if (i == j) {
			return;
		}
		
		if (parent[i] > parent[j]) {
			i ^= j;
			j ^= i;
			i ^= j;
		}
		
		parent[i] += parent[j];
		parent[j] = i;
	}
}
