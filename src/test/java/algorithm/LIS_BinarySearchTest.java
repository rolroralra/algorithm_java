package algorithm;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LIS_BinarySearchTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    void getLIS(Integer[] input, int expected) {
        List<Integer> lis = LIS_BinarySearch.getLIS(input);

        assertEquals(expected, lis.size());
        assertLIS(lis);
        System.out.println(lis);
        System.out.println(String.join(" ", lis.stream().map(Object::toString).toList()));
    }

    private void assertLIS(List<Integer> list) {
        assertLIS(list, false);
    }

    private void assertLIS(List<Integer> list, boolean allowedSameValue) {
        for (int i = 1; i < list.size(); i++) {
            if (allowedSameValue) {
                assertTrue(list.get(i - 1) <= list.get(i), "This is not a valid LIS: " + list);
            } else {
                assertTrue(list.get(i - 1) < list.get(i), "This is not a valid LIS: " + list);
            }
        }
    }

    static Stream<Arguments> provideTestData() {
        return Stream.of(
            Arguments.of(new Integer[] {1, 2, 1, 3, 2, 5}, 4),
            Arguments.of(new Integer[] {10, 9, 2, 5, 3, 7, 101, 18}, 4),
            Arguments.of(new Integer[] {0, 1, 0, 3, 2, 3}, 4),
            Arguments.of(new Integer[] {7, 7, 7, 7}, 1)
        );
    }
}