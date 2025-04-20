package algorithm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BitMaskSetTest {

    @Test
    void test() {
        BitMaskSet bitMaskSet = new BitMaskSet(10);
        bitMaskSet.remove(0);
        bitMaskSet.add(1);
        bitMaskSet.add(2);
        bitMaskSet.set(2, false);
        bitMaskSet.add(3);
        bitMaskSet.toggle(4);
        bitMaskSet.toggle(5);
        bitMaskSet.add(6);
        bitMaskSet.remove(6);
        bitMaskSet.set(7, true);
        bitMaskSet.set(8, false);
        bitMaskSet.set(9, true);
        bitMaskSet.toggle(9);

        assertAll(
            () -> assertTrue(bitMaskSet.isChecked(1)),
            () -> assertFalse(bitMaskSet.isChecked(2)),
            () -> assertTrue(bitMaskSet.isChecked(3)),
            () -> assertTrue(bitMaskSet.isChecked(4)),
            () -> assertTrue(bitMaskSet.isChecked(5)),
            () -> assertFalse(bitMaskSet.isChecked(6)),
            () -> assertTrue(bitMaskSet.isChecked(7)),
            () -> assertFalse(bitMaskSet.isChecked(8)),
            () -> assertFalse(bitMaskSet.isChecked(9))
        );
    }
}