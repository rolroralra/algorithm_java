package algorithm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import algorithm.unionfind.UnionFind;

class UnionFindTest {

    private UnionFind unionFind;
    private static final int TEST_SIZE = 10;

    @BeforeEach
    void setUp() {
        unionFind = new UnionFind(TEST_SIZE);

        IntStream.range(0, TEST_SIZE).forEach(i -> assertThat(unionFind.find(i)).isEqualTo(i));
    }

    @DisplayName("UnionFind::find() 테스트")
    @Test
    void testUnionFind() {
        unionFind.union(0, 1);
        assertThat(unionFind.find(0)).isEqualTo(unionFind.find(1));


        unionFind.union(2, 3);
        assertThat(unionFind.find(2)).isEqualTo(unionFind.find(3));

        unionFind.union(1, 2);
        assertAll(
            () -> assertThat(unionFind.find(0)).isEqualTo(unionFind.find(1)),
            () -> assertThat(unionFind.find(1)).isEqualTo(unionFind.find(0)),
            () -> assertThat(unionFind.find(2)).isEqualTo(unionFind.find(0)),
            () -> assertThat(unionFind.find(3)).isEqualTo(unionFind.find(0)),
            () -> assertThat(unionFind.find(4)).isEqualTo(4),
            () -> assertThat(unionFind.find(5)).isEqualTo(5),
            () -> assertThat(unionFind.find(6)).isEqualTo(6),
            () -> assertThat(unionFind.find(7)).isEqualTo(7),
            () -> assertThat(unionFind.find(8)).isEqualTo(8),
            () -> assertThat(unionFind.find(9)).isEqualTo(9)
        );
    }
}