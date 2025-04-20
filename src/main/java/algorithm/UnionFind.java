package algorithm;

import java.util.Arrays;

/**
 * Union-Find (Disjoint Set Union) data structure
 * This class implements the Union-Find data structure with path compression and
 * union by rank.
 * It is used to efficiently manage and merge disjoint sets.
 * <br/><br/>
 * Valid index is from 0 to size - 1.
 */
public class UnionFind {
	private final int[] parent;
	private final int[] rank; // level or depth

	/**
	 * Constructor to initialize the Union-Find structure with a given size.
	 *
	 * @param size the number of elements in the Union-Find structure
	 */
	public UnionFind(int size) {
		parent = new int[size];
		rank = new int[size];
		Arrays.fill(parent, -1);
		Arrays.fill(rank, 1);
	}

	/**
	 * Union operation to merge two teams containing each index.
	 *
	 * @param leftIndex index1
	 * @param rightIndex index2
	 */
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

	/**
	 * @deprecated replace union() with unionByRank()
	 * @see #union(int, int)
	 */
	@SuppressWarnings("unused")
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

	/**
	 * Find operation to get the root index of the team containing the given index.
	 *
	 * @param index the index to find
	 * @return the root index of the team containing the given index
	 */
	public int find(int index) {
		return findByRecursive(index);
	}

	/**
	 * Find operation to get the root index of the team containing the given index.
	 * This method uses path compression to optimize the find operation.
	 * This method is implemented using recursive approach.
	 *
	 * @param index the index to find
	 * @return the root index of the team containing the given index
	 */
	private int findByRecursive(int index) {
		if (parent[index] < 0) {
			return index;
		}

		return parent[index] = find(parent[index]);
	}

	/**
	 * Find operation to get the root index of the team containing the given index.
	 * This method uses path compression to optimize the find operation.
	 * This method is implemented using iterative approach.
	 *
	 * @param index the index to find
	 * @return the root index of the team containing the given index
	 */
	@SuppressWarnings("unused")
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
