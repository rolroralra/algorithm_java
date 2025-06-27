package leetcode;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class SolutionTest {
    public static List<Integer> solution(int X, List<Integer> indexes) {
        int count = 0;

        List<Integer> indexResult = new ArrayList<>();

        for (int i = 0; i < indexes.size(); i++) {
            if (indexes.get(i) == X) {
                indexResult.add(i);
                count++;
            }
        }

        return indexes.stream()
                .map(i ->
                        isValidIndex(i, indexResult.size()) ? -1 : indexes.get(i - 1)
                )
                .collect(Collectors.toList());
    }

    public static boolean isValidIndex(int input, int maxSize) {
        return input <= 0 || input > maxSize;
    }

    @Test
    public void test() {
        System.out.println(SolutionTest.solution(8, Arrays.asList(1, 2, 20, 8, 8, 1, 2, 5, 8, 0)));
    }


}