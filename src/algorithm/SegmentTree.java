package algorithm;

import java.util.function.BinaryOperator;

public class SegmentTree<T> {
    private static final int rootNodeIndex = 0;

    private final T[] segmentTree;
    private final int originDataSize;
    private final BinaryOperator<T> operator;

    public SegmentTree(int originDataSize, BinaryOperator<T> operator) throws Exception {
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

        segmentTreeSize = (segmentTreeSize << 1) - 1;

        this.segmentTree = (T[]) new Object[segmentTreeSize];
    }

    public SegmentTree(T[] originDataArray, BinaryOperator<T> operator) throws Exception {
        this(originDataArray.length, operator);
        this.init(originDataArray);
    }

    private void init(T[] originDataArray) throws Exception {
        if (originDataArray.length > this.originDataSize) {
            throw new Exception(
                    "Input Data size is overflow! (Input Data Size : " + originDataArray.length +
                    ", Current Data Size : " + this.originDataSize + ")");
        }

        for (int index = 0; index < originDataArray.length; index++) {
            this.update(index, originDataArray[index]);
        }
    }

    public void update(int index, T value) {
        this.updateByValue(index, value, rootNodeIndex, 0, this.originDataSize - 1 );
    }

    // left , right   0-base index
    public T query(int left, int right) {
        return this.query(left, right, rootNodeIndex, 0, this.originDataSize - 1);
    }

    private void updateByValue(int index, T value, int node, int nodeLeft, int nodeRight) {
        // Escaping Condition : index is not in segment [nodeLeft, nodeRight]
        if (index < nodeLeft || nodeRight < index) {
            return;
        }

        if (nodeLeft == nodeRight) {
            segmentTree[node] = value;
            return;
        }

        int nodeMid = (nodeLeft + nodeRight) >> 1;
        int leftNode = (node << 1) + 1;
        int rightNode = leftNode + 1;

        updateByValue(index, value,  leftNode, nodeLeft, nodeMid);
        updateByValue(index, value, rightNode, nodeMid + 1, nodeRight);

        segmentTree[node] = operator.apply(segmentTree[leftNode], segmentTree[rightNode]);
    }

    // left : left Index of Query Range
    // right : right index of Query Range
    private T query(int left, int right, int node, int nodeLeft, int nodeRight) {
        // [left, right] is not in [nodeLeft, nodeRight]
        if (left > nodeRight || right < nodeLeft) {
            return null;
        }

        // [left ... [nodeLeft ... nodeRight] ... left]
        if (left <= nodeLeft && nodeRight <= right) {
            return this.segmentTree[node];
        }

        // Divide & Conquer
        int nodeMid = (nodeLeft + nodeRight) >> 1;
        int leftNode = (node << 1) + 1;
        int rightNode = leftNode + 1;

        T leftResult = query(left, right, leftNode, nodeLeft, nodeMid);
        T rightResult = query(left, right, rightNode, nodeMid + 1, nodeRight);

        if (leftResult != null && rightResult != null) {
            return operator.apply(leftResult, rightResult);
        }
        else if (leftResult == null && rightResult != null) {
            return rightResult;
        }
        else if (leftResult != null && rightResult == null) {
            return leftResult;
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9,10};
//        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, (left, right) -> Integer.sum(left == null ? 0 : left, right == null ? 0 : right));
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, (left, right) -> Integer.max(left == null ? Integer.MIN_VALUE : left, right == null ? Integer.MIN_VALUE : right));


        System.out.println(segmentTree.query(0,3));
        segmentTree.update(0, 5);
        segmentTree.update(2, 10);
        System.out.println(segmentTree.query(0,3));
        System.out.println(segmentTree.query(0,4));

    }
}
