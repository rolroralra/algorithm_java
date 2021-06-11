package algorithm;

public class SegmentTree {

    private int[] segmentTree;
    private int segmentTreeSize;   // originDataSize * 4
    private int originDataSize;
    private int[] orginDataArrayPointer;

    public static final int rootNodeIndex = 0;

    public SegmentTree(int originDataSize) throws Exception {
        if (originDataSize <= 0) {
            throw new Exception("Origin Data Size must be positive!");
        }

        this.originDataSize = originDataSize;

        for (segmentTreeSize = 1; segmentTreeSize < originDataSize; this.segmentTreeSize <<= 1);
        this.segmentTreeSize = (this.segmentTreeSize << 1) - 1;

        this.segmentTree = new int[this.segmentTreeSize];
    }

    public SegmentTree(int[] originDataArray) throws Exception {
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

    public void update(int index, int diffValue) {
        this.update(0, this.originDataSize - 1, this.rootNodeIndex, index, diffValue);
    }

    public int sum(int left, int right) {
        return this.sum(0, this.originDataSize - 1, this.rootNodeIndex, left, right);
    }

    private void update(int start, int end, int node, int index, int diffValue) {
        // Escaping Condition : index is not in segment [start, end]
        if (index < start || end < index) {
            return;
        }

        // index is in segment [start, end] ==> must be updated!
        if (start <= index && index <= end) {
            this.segmentTree[node] += diffValue;
        }

        // When start == end, it must be leaf node in Segment Tree.
        if (start != end) {
            int mid = (start + end) >> 1;
            int leftNode = (node << 1) + 1;
            int rightNode = leftNode + 1;
            update(start, mid, leftNode, index, diffValue);
            update(mid + 1, end, rightNode, index, diffValue);
        }
    }

    private int sum(int start, int end, int node, int left, int right) {
        // [left, right] is not in [start, end]
        if (left > end || right < start) {
            return 0;
        }

        // [left ... [start ... end] ... left]
        if (left <= start && end <= right) {
            return this.segmentTree[node];
        }

        // Divide & Conquer
        int mid = (start + end) >> 1;
        int leftNode = (node << 1) + 1;
        int rightNode = leftNode + 1;

        return this.sum(start, mid, leftNode, left, right) + sum(mid + 1, end, rightNode, left, right);
    }
}
