package algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * 다시 정리하면 LIS에서 고려해야 할 것은 2가지인데 일단
 * 	1. LIS에서 자신의 앞에 있는 요소가 자기보다 전부 작아야 한다는 것.
 * 	2. LIS에서 자신의 앞에 있는 요소가 원래 있는 위치보다 앞에 있어야 한다는 것.
 * 여기서 값에 대한 정렬을 해줌으로서 1번에 대한 내용을 삭제할 수 있습니다.
 *
 * 중복이 있을 수 있는 경우, 값이 동일해도 LIS가 되는 경우와 안되는 경우가 있을 수 있습니다.
 * 	1. 그럴 땐 인덱스 기준을 큰것부터 나열하게 하면 뒤부터 처리가 되므로
 * 	   동일값에 대한 LIS를 허용하지 않는 것에 대한 결과가 나오게 되고 (위치가 더 큰 것에 대한 참조X)
 * 	2. 인덱스 기준을 작은것부터 나열하면 앞부터 처리가 되므로 자연스럽게 동일값 허용 LIS에 대한
 *     결과가 나오게 됩니다.
 */
public class LIS_SegmentTree<T extends Comparable<T>> {    // LIS(Longest Increasing Subsequence) Algorithm

    private final T[] originalDataArray;
    private final DataWithIndex<T>[] sortedDataArray;
    private final SegmentTree<Integer> segmentTreeForLisLength;

    record DataWithIndex<T extends Comparable<T>>(
        int index,
        T data
    ) {

        static <T extends Comparable<T>> Comparator<DataWithIndex<T>> comparator(
            boolean allowedSameValue) {
            return (o1, o2) -> {
                int dataComparingResult = o1.data.compareTo(o2.data);
                if (dataComparingResult == 0) {
                    return allowedSameValue ? o1.index - o2.index : o2.index - o1.index;
                }

                return dataComparingResult;
            };
        }
    }

    public LIS_SegmentTree(List<T> originalDataList) {
        this(originalDataList, false);
    }

    public LIS_SegmentTree(T[] originalDataArray) {
        this(originalDataArray, false);
    }

    @SuppressWarnings("all")
    public LIS_SegmentTree(List<T> originalDataList, boolean allowedSameValue) {
        this((T[]) originalDataList.toArray(), allowedSameValue);
    }

    @SuppressWarnings("unchecked")
    public LIS_SegmentTree(T[] originalDataArray, boolean allowedSameValue) {
        this.originalDataArray = originalDataArray;
        this.sortedDataArray = new DataWithIndex[originalDataArray.length];
        for (int i = 0; i < originalDataArray.length; i++) {
            this.sortedDataArray[i] = new DataWithIndex<>(i, originalDataArray[i]);
        }

        Arrays.sort(this.sortedDataArray, DataWithIndex.comparator(allowedSameValue));

        this.segmentTreeForLisLength = new SegmentTree<>(originalDataArray.length, Integer::max);

        for (int i = 0; i < originalDataArray.length; i++) {
            segmentTreeForLisLength.update(i, 0);
        }

        for (DataWithIndex<T> dataWithIndex : sortedDataArray) {
            int index = dataWithIndex.index;
            int lisLength = segmentTreeForLisLength.query(0, index);
            segmentTreeForLisLength.update(index, lisLength + 1);
        }
    }

    public DataWithIndex<T>[] getSortedDataArray() {
        return sortedDataArray;
    }

    public Integer getLISLength() {
        return segmentTreeForLisLength.query(0, originalDataArray.length - 1);
    }

    public static void main(String[] args) {
//		int[] arr = new int[]{8, 12, 15, 9, 13, 1, 14, 5};
//		int[] arr = new int[]{1, 2, 2, 2, 3, 1, 1, 2};
        Integer[] arr = new Integer[]{10, 20, 10, 30, 20, 50};
        int n = arr.length;

        LIS_SegmentTree<Integer> lis = new LIS_SegmentTree<>(arr, true);

        System.out.println(lis.getLISLength());

        SegmentTree<Integer> segmentTree = new SegmentTree<>(n, Integer::max);

        int[][] arrWithIndex = new int[n][2];

        for (int i = 0; i < n; i++) {
            arrWithIndex[i][0] = i;
            arrWithIndex[i][1] = arr[i];
            segmentTree.update(i, 0);
        }

        Arrays.sort(arrWithIndex, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        System.out.println(Arrays.deepToString(arrWithIndex));

        for (int i = 0; i < n; i++) {
            int index = arrWithIndex[i][0];
            int value = arrWithIndex[i][1];
            int max = segmentTree.query(0, index);
            segmentTree.update(index, max + 1);
        }

        System.out.println(segmentTree.query(0, -1));

        System.out.println(segmentTree.query(0, n - 1));
    }
}
