package algorithm;

import java.util.stream.IntStream;

public class BitMaskSet {
    private final int size;
    private final byte[] bytePackages;

    public BitMaskSet(int size) {
        this.size = size;
        this.bytePackages = new byte[(size + Byte.SIZE - 1) / Byte.SIZE];
    }

    public boolean isChecked(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("index must be in range [%d, %d)", 0, size));
        }

        return (bytePackages[index / Byte.SIZE] & (1 << (index % Byte.SIZE))) != 0;
    }

    public void set(int index, boolean value) {
        if (value) {
            add(index);
        }
        else {
            remove(index);
        }
    }

    public void add(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("index must be in range [%d, %d)", 0, size));
        }

        bytePackages[index / Byte.SIZE] |= 1 << (index % Byte.SIZE);
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("index must be in range [%d, %d)", 0, size));
        }

        bytePackages[index / Byte.SIZE] &= ~(1 << (index % Byte.SIZE));
    }

    public void toggle(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("index must be in range [%d, %d)", 0, size));
        }

        bytePackages[index / Byte.SIZE] ^= 1 << (index % Byte.SIZE);
    }

    public static void main(String[] args) {
        BitMaskSet bitMaskSet = new BitMaskSet(10);
        bitMaskSet.add(1);
        bitMaskSet.add(2);
        bitMaskSet.add(3);
        bitMaskSet.set(9, true);
        bitMaskSet.set(2, false);

        IntStream.range(0, 10).filter(bitMaskSet::isChecked).forEach(System.out::println);
    }
}
