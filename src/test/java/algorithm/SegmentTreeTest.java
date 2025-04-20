package algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SegmentTreeTest {
    private SegmentTree<Integer> segmentTree;

    @BeforeEach
    void setUp() {
        segmentTree = new SegmentTree<>(new Integer[] {
            1, 2, 3, 4, 5, 6, 7, 8
        }, Integer::sum);
    }

    @Test
    void getCurrentDataArray() {
        assertArrayEquals(new Integer[] {
            1, 2, 3, 4, 5, 6, 7, 8
        }, segmentTree.getCurrentDataArray());

        segmentTree.update(0, 5);
        assertArrayEquals(new Integer[] {
            5, 2, 3, 4, 5, 6, 7, 8
        }, segmentTree.getCurrentDataArray());

        segmentTree.update(3, 3);
        assertArrayEquals(new Integer[] {
            5, 2, 3, 3, 5, 6, 7, 8
        }, segmentTree.getCurrentDataArray());
    }

    @Test
    void update() {
        segmentTree.update(0, 5);
        assertEquals(14, segmentTree.query(0, 3));
        segmentTree.update(3, 3);
        assertEquals(13, segmentTree.query(0, 3));
        segmentTree.update(4, 2);
        assertEquals(23, segmentTree.query(4, 7));
        segmentTree.update(7, 1);
        assertEquals(29, segmentTree.query(0, 7));

    }

    @Test
    void query() {
        assertEquals(10, segmentTree.query(0, 3));
        assertEquals(26, segmentTree.query(4, 7));
        assertEquals(36, segmentTree.query(0, 7));
        assertEquals(null, segmentTree.query(8, 9));
    }
}