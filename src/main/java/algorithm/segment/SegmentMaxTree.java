package algorithm.segment;

public class SegmentMaxTree {
    private static final int rootNodeIndex = 0;

    private int[] segmentTree;
    private int segmentTreeSize;   // originDataSize * 4
    private int originDataSize;

    public SegmentMaxTree(int originDataSize) throws Exception {
        if (originDataSize <= 0) {
            throw new Exception("Origin Data Size must be positive!");
        }

        this.originDataSize = originDataSize;

        for (segmentTreeSize = 1; segmentTreeSize < originDataSize; this.segmentTreeSize <<= 1);

        this.segmentTreeSize = (this.segmentTreeSize << 1) - 1;

        this.segmentTree = new int[this.segmentTreeSize];
    }

    public SegmentMaxTree(int[] originDataArray) throws Exception {
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

    // left , right   0-base index
    public int max(int left, int right) {
        return this.max(left, right, rootNodeIndex, 0, this.originDataSize - 1);
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

        segmentTree[node] = Math.max(segmentTree[leftNode], segmentTree[rightNode]);
    }

    // left : left Index of Query Range
    // right : right index of Query Range
    private int max(int left, int right, int node, int nodeLeft, int nodeRight) {
        // [left, right] is not in [nodeLeft, nodeRight]
        if (left > nodeRight || right < nodeLeft) {
            return Integer.MIN_VALUE;
        }

        // [left ... [nodeLeft ... nodeRight] ... left]
        if (left <= nodeLeft && nodeRight <= right) {
            return this.segmentTree[node];
        }

        // Divide & Conquer
        int nodeMid = (nodeLeft + nodeRight) >> 1;
        int leftNode = (node << 1) + 1;
        int rightNode = leftNode + 1;

        return Math.max(max(left, right, leftNode, nodeLeft, nodeMid), max(left, right, rightNode, nodeMid + 1, nodeRight));
    }


    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{2, 4, 1, 5, 8, 10};

        SegmentMaxTree segmentMaxTree = new SegmentMaxTree(arr);

        System.out.println(segmentMaxTree.max(0, 3));
        segmentMaxTree.update(0, 6);
        System.out.println(segmentMaxTree.max(0, 3));
        segmentMaxTree.update(0, 1);
        segmentMaxTree.update(3, 3);
        System.out.println(segmentMaxTree.max(0, 3));


    }
}
