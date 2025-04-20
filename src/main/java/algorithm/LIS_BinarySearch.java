package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class LIS_BinarySearch {    // LIS(Longest Increasing Subsequence) Algorithm

    static class DataWithIndex<T extends Comparable<T>> {
        int index;
        T data;

        DataWithIndex(int index, T data) {
            this.index = index;
            this.data = data;
        }

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

    /**
     * This class is used to store the result of the LIS algorithm.
     * @param <T> the type of elements in the list, which must implement Comparable
     */
    static class LISAlgorithmResult<T extends Comparable<T>> {

        /**
         * The original data list
         */
        List<T> originalDataList;

        /**
         * The data list with index
         */
        List<DataWithIndex<T>> dataWithIndexList;

        /**
         * The trace array used to reconstruct the LIS
         */
        int[] trace;

        LISAlgorithmResult(List<T> originalDataList, List<DataWithIndex<T>> dataWithIndexList, int[] trace) {
            this.originalDataList = originalDataList;
            this.dataWithIndexList = dataWithIndexList;
            this.trace = trace;
        }

        /**
         * Get the longest increasing subsequence by using the trace array.
         *
         * @return the longest increasing subsequence
         */
        public List<T> getLIS() {
            List<T> result = new ArrayList<>();
            Stack<T> stack = new Stack<>();

            int index = dataWithIndexList.getLast().index;
            while (index >= 0) {
                stack.push(originalDataList.get(index));
                index = trace[index];
            }

            while (!stack.empty()) {
                result.add(stack.pop());
            }

            return result;
        }

        /**
         * Get the length of the longest increasing subsequence.
         *
         * @return the length of the longest increasing subsequence
         */
        public int getLISLength() {
            return dataWithIndexList.size();
        }
    }

    /**
     * LIS(Longest Increasing Subsequence) Algorithm
     *
     * @param <T>              the type of elements in the list, which must implement Comparable
     * @param originalDataList data list
     * @return the longest increasing subsequence
     */
    public static <T extends Comparable<T>> List<T> getLIS(T[] originalDataList) {
        return getLIS(List.of(originalDataList), false);
    }

    /**
     * LIS(Longest Increasing Subsequence) Algorithm
     *
     * @param <T>              the type of elements in the list, which must implement Comparable
     * @param originalDataList data list
     * @return the longest increasing subsequence
     */
    public static <T extends Comparable<T>> List<T> getLIS(List<T> originalDataList) {
        return getLIS(originalDataList, false);
    }

    /**
     * LIS(Longest Increasing Subsequence) Algorithm
     *
     * @param <T>              the type of elements in the list, which must implement Comparable
     * @param originalDataList data list
     * @param allowSameValue   whether to allow same value in the longest increasing subsequence
     * @return the longest increasing subsequence
     */
    public static <T extends Comparable<T>> List<T> getLIS(T[] originalDataList,
        boolean allowSameValue) {
        return getLIS(List.of(originalDataList), allowSameValue);
    }

    /**
     * LIS(Longest Increasing Subsequence) Algorithm
     *
     * @param <T>              the type of elements in the list, which must implement Comparable
     * @param originalDataList data list
     * @param allowSameValue   whether to allow same value in the longest increasing subsequence
     * @return the longest increasing subsequence
     */
    public static <T extends Comparable<T>> List<T> getLIS(List<T> originalDataList,
        boolean allowSameValue) {
        LISAlgorithmResult<T> algorithmResult = processLISAlgorithm(originalDataList,
            allowSameValue);

        return algorithmResult.getLIS();
    }

    private static <T extends Comparable<T>> LISAlgorithmResult<T> processLISAlgorithm(
        List<T> originalDataList,
        boolean allowSameValue) {
        int[] trace = IntStream.range(0, originalDataList.size()).map(i -> -1).toArray();
        List<DataWithIndex<T>> dataWithIndexList = new ArrayList<>();

        for (int originalDataIndex = 0; originalDataIndex < originalDataList.size();
            originalDataIndex++) {
            DataWithIndex<T> target = new DataWithIndex<>(originalDataIndex,
                originalDataList.get(originalDataIndex));

            int rankIndex = LowerUpperBound.lowerBound(
                dataWithIndexList, target, DataWithIndex.comparator(allowSameValue));

            if (rankIndex < 0) {
                rankIndex = -(rankIndex + 1);
            }

            if (rankIndex < dataWithIndexList.size()) {
                dataWithIndexList.set(rankIndex, target);
            } else {
                dataWithIndexList.add(target);
            }

            if (rankIndex > 0) {
                trace[originalDataIndex] = dataWithIndexList.get(rankIndex - 1).index;
            }
        }

        return new LISAlgorithmResult<>(originalDataList, dataWithIndexList, trace);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{8, 12, 15, 9, 13, 1, 14, 5};
//		Integer[] arr = new Integer[]{1, 2, 2, 2, 3, 1, 1, 2};			// BinarySearch로 LIS 구하는 경우.. 동일값에 대한 처리... 필요..
        int n = arr.length;

        ArrayList<Integer[]> list = new ArrayList<>();
        Integer[] trace = new Integer[n];
        for (int i = 0; i < n; i++) {
            int index = LowerUpperBound.lowerBound(list, new Integer[]{arr[i], i},
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

            if (index < 0) {
                index = -(index + 1);
            }

            Integer[] valueAndIndex = {arr[i], i};
            if (index < list.size()) {
                list.set(index, valueAndIndex);
            } else {
                list.add(valueAndIndex);
            }

            if (index > 0) {
                trace[i] = list.get(index - 1)[1];
            } else {
                trace[i] = -1;
            }
        }

        System.out.println(list.size());
        int index = list.get(list.size() - 1)[1];
        Stack<Integer> stack = new Stack<>();
        while (index >= 0) {
            stack.push(arr[index]);
            index = trace[index];
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    public static int binarySearch(ArrayList<int[]> list, int start, int end, int key) {
        if (start > end) {
            return -(start + 1);
        }

        int mid = (start + end) / 2;
        int midValue = list.get(mid)[0];
        if (midValue < key) {
            return binarySearch(list, mid + 1, end, key);
        } else if (midValue > key) {
            return binarySearch(list, start, mid - 1, key);
        }
        return mid;
    }
}
