package algorithm;

public class SegmentSumTree {
    private static final int rootNodeIndex = 0;

    private int[] segmentTree;
    private int segmentTreeSize;   // originDataSize * 4
    private int originDataSize;

    public SegmentSumTree(int originDataSize) throws Exception {
        if (originDataSize <= 0) {
            throw new Exception("Origin Data Size must be positive!");
        }

        this.originDataSize = originDataSize;

        for (segmentTreeSize = 1; segmentTreeSize < originDataSize; this.segmentTreeSize <<= 1);

        this.segmentTreeSize = (this.segmentTreeSize << 1) - 1;

        this.segmentTree = new int[this.segmentTreeSize];
    }

    public SegmentSumTree(int[] originDataArray) throws Exception {
        this(originDataArray.length);
        this.init(originDataArray);
    }

    private void init(int[] originDataArray) throws Exception {
        if (originDataArray.length > this.originDataSize) {
            throw new Exception(
                    "Input Data size is overflow! (Input Data Size : " + originDataArray.length +
                    ", Current Data Size : " + this.originDataSize + ")");
        }

        for (int index = 0; index < originDataArray.length; index++) {
            this.update(index, originDataArray[index]);
        }
    }

    public void update(int index, int value) {
        this.updateByValue(index, value, rootNodeIndex, 0, this.originDataSize - 1 );
    }

    public void updateByDiffValue(int index, int diffValue) {
        this.updateByDiffValue(index, diffValue, rootNodeIndex, 0, originDataSize - 1);
    }

    // left , right   0-base index
    public int sum(int left, int right) {
        return this.sum(left, right, rootNodeIndex, 0, this.originDataSize - 1);
    }

    private void updateByValue(int index, int value, int node, int nodeLeft, int nodeRight) {
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

        segmentTree[node] = segmentTree[leftNode] + segmentTree[rightNode];
    }

    private void updateByDiffValue(int index, int diffValue, int node, int nodeLeft, int nodeRight) {
        // Escaping Condition : index is not in segment [nodeLeft, nodeRight]
        if (index < nodeLeft || nodeRight < index) {
            return;
        }

        this.segmentTree[node] += diffValue;

        // When start == end, it must be leaf node in Segment Tree.
        if (nodeLeft != nodeRight) {
            int nodeMid = (nodeLeft + nodeRight) >> 1;
            int leftNode = (node << 1) + 1;
            int rightNode = leftNode + 1;
            updateByDiffValue(index, diffValue,  leftNode, nodeLeft, nodeMid);
            updateByDiffValue(index, diffValue, rightNode, nodeMid + 1, nodeRight);
        }
    }

    // left : left Index of Query Range
    // right : right index of Query Range
    private int sum(int left, int right, int node, int nodeLeft, int nodeRight) {
        // [left, right] is not in [nodeLeft, nodeRight]
        if (left > nodeRight || right < nodeLeft) {
            return 0;
        }

        // [left ... [nodeLeft ... nodeRight] ... left]
        if (left <= nodeLeft && nodeRight <= right) {
            return this.segmentTree[node];
        }

        // Divide & Conquer
        int nodeMid = (nodeLeft + nodeRight) >> 1;
        int leftNode = (node << 1) + 1;
        int rightNode = leftNode + 1;

        return this.sum(left, right, leftNode, nodeLeft, nodeMid) + sum(left, right, rightNode, nodeMid + 1, nodeRight);
    }


    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};

        SegmentSumTree segmentSumTree = new SegmentSumTree(arr);

        System.out.println(segmentSumTree.sum(0, 3));
        segmentSumTree.updateByDiffValue(0, 1);
        System.out.println(segmentSumTree.sum(0, 3));
        System.out.println(segmentSumTree.sum(0, 4));
    }
}
