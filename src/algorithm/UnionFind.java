package algorithm;

import java.util.Arrays;

public class UnionFind {
	private final int[] parent;
	private final int[] rank; // level or depth

	public UnionFind(int size) {
		parent = new int[size];
		rank = new int[size];
		Arrays.fill(parent, -1);
		Arrays.fill(rank, 1);
	}

	public void union(int leftIndex, int rightIndex) {
		int leftRootIndex = find(leftIndex);
		int rightRootIndex = find(rightIndex);

		if (leftRootIndex == rightRootIndex) {
			return;
		}

		if (parent[leftRootIndex] > parent[rightRootIndex]) {
			leftRootIndex ^= rightRootIndex;
			rightRootIndex ^= leftRootIndex;
			leftRootIndex ^= rightRootIndex;
		}

		parent[leftRootIndex] += parent[rightRootIndex];
		parent[rightRootIndex] = leftRootIndex;
	}

	@Deprecated
	private void unionByRank(int leftIndex, int rightIndex) {
		int leftRootIndex = find(leftIndex);
		int rightRootIndex = find(rightIndex);

		if (leftRootIndex == rightRootIndex) {
			return;
		}

		if (rank[leftRootIndex] < rank[rightRootIndex]) {
			leftRootIndex ^= rightRootIndex;
			rightRootIndex ^= leftRootIndex;
			leftRootIndex ^= rightRootIndex;
		}

		parent[leftRootIndex] += parent[rightRootIndex];
		parent[rightRootIndex] = leftRootIndex;

		if (rank[leftRootIndex] == rank[rightRootIndex]) {
			rank[leftRootIndex]++;
		}
	}



	public int find(int index) {
		return findByRecursive(index);
	}

	private int findByRecursive(int index) {
		if (parent[index] < 0) {
			return index;
		}

		return parent[index] = find(parent[index]);
	}

	private int findByLoop(int index) {
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

	public static void main(String[] args) {
		UnionFind unionFind = new UnionFind(10);
		unionFind.union(0, 1);

		System.out.println(unionFind.find(1));

		unionFind.union(2, 3);

		System.out.println(unionFind.find(3));

		unionFind.union(1, 2);

		System.out.println(unionFind.find(3));
	}
}
