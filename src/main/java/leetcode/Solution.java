package leetcode;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static List<Integer> solution(int X, List<Integer> arr, List<Integer> indexes) {
        List<Integer> indexResult = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == X) {
                indexResult.add(i + 1);
            }
        }

        return indexes.stream()
                .map(i ->
                        isInvalidIndex(i, indexResult.size()) ? -1 : indexResult.get(i - 1)
                )
                .collect(Collectors.toList());
    }

    public static List<Integer> solution2(List<Integer> A, List<Integer> B) {
        A.sort(Comparator.naturalOrder());
//        B.sort(Comparator.naturalOrder());

        return B.stream()
                .mapToInt(i -> upperBound(A, i))
                .boxed()
                .collect(Collectors.toList());
    }

    public static int upperBound(List<Integer> list, int key) {
        int start = 0;
        int end = list.size() - 1;
        // s, e, key : [s, e] 범위에서 key값 보다 크거나 같은 최초의 index
        int upperBound = list.size();	// lowerBound Code
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (list.get(mid) > key) {
                end = mid - 1;
                upperBound = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return upperBound;
    }

    public static int solution3(int n, List<Integer> infectedHouses) {
        boolean[] isVisited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        infectedHouses.stream()
                .map(i -> i - 1)
                .forEach(i -> {
                    isVisited[i] = true;
                    queue.add(i);
                });

        int result = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currIndex = queue.poll();

                processNextIndex(currIndex - 1, queue, isVisited);
                processNextIndex(currIndex + 1, queue, isVisited);
            }

            int nodeCountWithHavingEqualDepth = queue.size();

            result = result * factorial(nodeCountWithHavingEqualDepth) % MOD;
        }

        return result;
    }
    public static void processNextIndex(int nextIndex, Queue<Integer> queue, boolean[] isVisited) {
        if (isValidIndex(nextIndex, isVisited.length) && !isVisited[nextIndex]) {
            queue.add(nextIndex);
            isVisited[nextIndex] = true;
        }
    }
    public static boolean isValidIndex(int input, int maxSize) {
        return input >= 0 && input < maxSize;
    }
    public static boolean isInvalidIndex(int input, int maxSize) {
        return input <= 0 || input > maxSize;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, Arrays.asList(1,2,20,8,8,1,2,5,8,0), Arrays.asList(4, 2)));
        System.out.println(solution2(Arrays.asList(1,4,2,4), Arrays.asList(0,1)));
        System.out.println(solution3(8, Arrays.asList(3,5)));
    }

    public static final int MOD = (int) Math.pow(10, 9) + 7;
    public static int factorial(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * i % MOD;
        }

        return result;
    }



}
