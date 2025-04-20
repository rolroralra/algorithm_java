package algorithm;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LIS_SegmentTreeTest {

    @ParameterizedTest
    @MethodSource("provideTestData")
    void getLISLength(Integer[] input, int expected) {
        LIS_SegmentTree<Integer> lisSegmentTree = new LIS_SegmentTree<>(input);

        assertEquals(expected, lisSegmentTree.getLISLength());
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