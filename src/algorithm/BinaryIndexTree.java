package algorithm;

import java.util.Objects;
import java.util.function.BinaryOperator;

public class BinaryIndexTree<T> {
	private static final int rootNodeIndex = 0;

	private final T[] tree;
	private final int originDataSize;
	private final BinaryOperator<T> operator;
	private final int baseIndex;

	public BinaryIndexTree(int originDataSize, BinaryOperator<T> operator) throws Exception {
		if (originDataSize <= 0) {
			throw new Exception("Origin Data Size must be positive!");
		}

		if (operator == null) {
			throw new Exception("Operator should not null.");
		}

		this.operator = operator;
		this.originDataSize = originDataSize;

		// originDataSize * 4
		int segmentTreeSize = 1;
		for (; segmentTreeSize < originDataSize; segmentTreeSize <<= 1);

		baseIndex = segmentTreeSize - 1;

		segmentTreeSize = (segmentTreeSize << 1) - 1;

		this.tree = (T[]) new Object[segmentTreeSize];
	}

	public BinaryIndexTree(T[] originData, BinaryOperator<T> operator) throws Exception {
		this(originData.length, operator);
		init(originData);
	}

	private void init(T[] originDataArray) throws Exception {
		if (originDataArray.length > this.originDataSize) {
			throw new Exception(
					"Input Data size is overflow! (Input Data Size : " + originDataArray.length +
							", Current Data Size : " + this.originDataSize + ")");
		}

		System.arraycopy(originDataArray, 0, tree, baseIndex, originDataArray.length);

		for (int parent = baseIndex - 1; parent >= 0; parent--) {
			int leftChild = parent * 2 + 1;
			int rightChild = leftChild + 1;

			if (Objects.isNull(tree[leftChild])) {
				continue;
			}

			if (Objects.isNull(tree[rightChild])) {
				tree[parent] = tree[leftChild];
				continue;
			}

			tree[parent] = operator.apply(tree[leftChild], tree[rightChild]);
		}
	}

	public void update(int index, T value) {
		int node = baseIndex + index;
		tree[node] = value;

		while (node > rootNodeIndex) {
			refresh(node);

			node = (node - 1) / 2;
		}
	}

	public T query(int left, int right) {
		T result = null;

		int leftNode = baseIndex + left;
		int rightNode = baseIndex + right;
		while (leftNode < rightNode) {
			if (leftNode % 2 == 0) {
				result = Objects.isNull(result) ? tree[leftNode] : operator.apply(result, tree[leftNode]);
				leftNode++;
			}

			if (rightNode % 2 == 1) {
				result = Objects.isNull(result) ? tree[rightNode] : operator.apply(result, tree[rightNode]);
				rightNode--;
			}

			leftNode = (leftNode - 1) / 2;
			rightNode = (rightNode - 1) / 2;
		}

		if (leftNode == rightNode) {
			result = Objects.isNull(result) ? tree[leftNode] : operator.apply(result, tree[leftNode]);
		}

		return result;
	}

	private void refresh(int node) {
		if (node >= baseIndex) {
			return;
		}

		int leftChildNode = node * 2 + 1;
		int rightChildNode = leftChildNode + 1;

		tree[node] = operator.apply(tree[leftChildNode], tree[rightChildNode]);
	}

	public static void main(String[] args) throws Exception {
		Integer[] array = new Integer[]{4, 5, 3, 6, 2};
//		BinaryIndexTree<Integer> binaryIndexTree = new BinaryIndexTree<>(array, Integer::min);
		BinaryIndexTree<Integer> binaryIndexTree = new BinaryIndexTree<>(array, Integer::max);
//		BinaryIndexTree<Integer> binaryIndexTree = new BinaryIndexTree<>(array, Integer::sum);

		System.out.println(binaryIndexTree.query(0, 3));
		binaryIndexTree.update(3, 2);
		System.out.println(binaryIndexTree.query(0, 3));
		System.out.println(binaryIndexTree.query(1, 4));
	}

	public static void binaryIndexTreeSample() {
		int[] arr = new int[]{4, 6, 3, 2, 4, 3, 1};
		int n = arr.length;
		int size = 1;
		for (; size < n; size <<= 1);

		// By BaseIndex, 최하위 레벨에 원본 데이터 복사
		int[] indexTree = new int[2 * size - 1];
		for (int i = 0; i < size; i++) {
			if (i < n) {
				indexTree[size - 1 + i] = arr[i];
			}
			else {
				indexTree[size - 1 + i] = Integer.MIN_VALUE;
			}
		}

		// 부모노드 업데이트
		for (int parent = size - 2; parent >= 0; parent--) {
			int left = 2 * parent + 1;
			int right = 2 * parent + 2;

			if (indexTree[left] > indexTree[right]) {
				indexTree[parent] = indexTree[left];
			}
			else {
				indexTree[parent] = indexTree[right];
			}
		}

		int start = 2 + size - 1;
		int end = 6 + size - 1;
		int max = Integer.MIN_VALUE;
		while (start < end) {
			if (start % 2 == 0) {
				max = Math.max(max, indexTree[start++]);
			}

			if (end % 2 == 1) {
				max = Math.max(max, indexTree[end--]);
			}

			start = (start - 1) >> 1;
			end = (end - 1) >> 1;

			if (start == end) {
				max = Math.max(max, indexTree[start]);
			}
		}
		System.out.println(max);
	}
}
