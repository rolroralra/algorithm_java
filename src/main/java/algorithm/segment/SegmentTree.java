package algorithm.segment;

import java.util.Objects;
import java.util.function.BinaryOperator;

/**
 * Segment Tree is a data structure that allows querying the elements of an array
 * in logarithmic time. It is useful for answering range queries, such as
 * sum, minimum, maximum, greatest common divisor (GCD), etc.
 *
 * @param <T> Type of Data
 *
 * @author rolroralra@gmail.com
 * @since 2021.06.15
 */
public class SegmentTree<T> {
    private static final int ROOT_NODE_BASE_INDEX = 0;

    private final T[] nodeTree;
    private final int originDataSize;
    private final BinaryOperator<T> accumulator;

    static class Node<T> {
        private T value;
        private int leftIndex;
        private int rightIndex;

        public Node(T value, int leftIndex, int rightIndex) {
            this.value = value;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }

    /**
     * Constructor for SegmentTree
     *
     * @param originDataSize Size of the original data
     * @param accumulator Function to combine two elements
     */
    @SuppressWarnings("unchecked")
    public SegmentTree(int originDataSize, BinaryOperator<T> accumulator) {
        if (originDataSize <= 0) {
            throw new RuntimeException("Origin Data Size must be positive!");
        }

        if (accumulator == null) {
            throw new RuntimeException("Operator should not null.");
        }

        this.accumulator = accumulator;

        this.originDataSize = originDataSize;

        // originDataSize * 4
        int segmentTreeSize = 1;
        for (; segmentTreeSize < originDataSize; segmentTreeSize <<= 1);

        segmentTreeSize = (segmentTreeSize << 1) - 1;

        this.nodeTree = (T[]) new Object[segmentTreeSize];
    }

    /**
     * Constructor for SegmentTree
     *
     * @param originDataArray Original data array
     * @param accumulator Function to combine two elements
     */
    public SegmentTree(T[] originDataArray, BinaryOperator<T> accumulator) {
        this(originDataArray.length, accumulator);
        this.init(originDataArray);
    }

    /**
     * Get current data array
     *
     * @return Current data array
     */
    @SuppressWarnings("unchecked")
    public T[] getCurrentDataArray() {
        T[] result = (T[]) new Object[originDataSize];

        System.arraycopy(nodeTree, (nodeTree.length + 1) / 2 - 1, result, 0, originDataSize);

        return result;
    }

    /**
     * Update the value at the specified index
     *
     * @param index 0-based index of the value to update
     * @param value updated value
     */
    public void update(int index, T value) {
        this.updateByValue(index, value, ROOT_NODE_BASE_INDEX, 0, this.originDataSize - 1 );
    }

    /**
     * Query the value in the range [left, right]
     *
     * @param left left index of the range (inclusive)
     * @param right right index of the range (inclusive)
     * @return result of the query, or null if not found
     */
    // left , right   0-base index
    public T query(int left, int right) {
        return this.query(left, right, ROOT_NODE_BASE_INDEX, 0, this.originDataSize - 1);
    }

    /**
     * Initialize the segment tree with the original data array
     *
     * @param originDataArray Original data array
     */
    private void init(T[] originDataArray) {
        if (originDataArray.length > this.originDataSize) {
            throw new RuntimeException(
                "Input Data size is overflow! (Input Data Size : " + originDataArray.length +
                    ", Current Data Size : " + this.originDataSize + ")");
        }

        for (int index = 0; index < originDataArray.length; index++) {
            this.update(index, originDataArray[index]);
        }
    }

    /**
     * Update the value at the specified index
     *
     * @param index 0-based index of the value to update
     * @param value updated value
     * @param node current node index
     * @param nodeLeft left index of the current node
     * @param nodeRight right index of the current node
     */
    private void updateByValue(int index, T value, int node, int nodeLeft, int nodeRight) {
        // Escaping Condition : index is not in segment [nodeLeft, nodeRight]
        if (index < nodeLeft || nodeRight < index) {
            return;
        }

        if (nodeLeft == nodeRight) {
            nodeTree[node] = value;
            return;
        }

        int nodeMid = (nodeLeft + nodeRight) >> 1;
        int leftNode = (node << 1) + 1;
        int rightNode = leftNode + 1;

        // Update the left and right child nodes
        updateByValue(index, value,  leftNode, nodeLeft, nodeMid);
        updateByValue(index, value, rightNode, nodeMid + 1, nodeRight);

        // Post order traversal
        if (Objects.nonNull(nodeTree[leftNode]) && Objects.nonNull(nodeTree[rightNode])) {
            nodeTree[node] = accumulator.apply(nodeTree[leftNode], nodeTree[rightNode]);
        }
        else if (Objects.nonNull(nodeTree[leftNode])) {
            nodeTree[node] = nodeTree[leftNode];
        }
        else if (Objects.nonNull(nodeTree[rightNode])) {
            nodeTree[node] = nodeTree[rightNode];
        }
    }

    /**
     * Query the value in the range [left, right]
     *
     * @param left left index of the range (inclusive)
     * @param right right index of the range (inclusive)
     * @param node current node index
     * @param nodeLeft left index of the current node
     * @param nodeRight right index of the current node
     * @return result of the query, or null if not found
     */
    private T query(int left, int right, int node, int nodeLeft, int nodeRight) {
        // [left, right] is not in [nodeLeft, nodeRight]
        if (left > nodeRight || right < nodeLeft) {
            return null;
        }

        // [left ... [nodeLeft ... nodeRight] ... right]
        if (left <= nodeLeft && nodeRight <= right) {
            return this.nodeTree[node];
        }

        // Divide & Conquer
        int nodeMid = (nodeLeft + nodeRight) >> 1;
        int leftNode = (node << 1) + 1;
        int rightNode = leftNode + 1;

        T leftResult = query(left, right, leftNode, nodeLeft, nodeMid);
        T rightResult = query(left, right, rightNode, nodeMid + 1, nodeRight);

        if (Objects.nonNull(leftResult) && Objects.nonNull(rightResult)) {
            return accumulator.apply(leftResult, rightResult);
        }
        else if (Objects.nonNull(leftResult)) {
            return leftResult;
        }
        else if (Objects.nonNull(rightResult)) {
            return rightResult;
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9,10};
//        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, (left, right) -> Integer.sum(left == null ? 0 : left, right == null ? 0 : right));
//        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, (left, right) -> Integer.max(left == null ? Integer.MIN_VALUE : left, right == null ? Integer.MIN_VALUE : right));

        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, Integer::sum);

        System.out.println(segmentTree.query(0,3));
        segmentTree.update(0, 5);
        segmentTree.update(2, 10);
        System.out.println(segmentTree.query(0,3));
        System.out.println(segmentTree.query(0,4));

    }
}
