package algorithm;

import java.util.stream.IntStream;

/**
 * A class that implements a bit mask set.
 * This class uses a byte array to store the bits, where each bit represents a boolean value.
 */
public class BitMaskSet {
    private static final String INDEX_OUT_OF_BOUNDS_MESSAGE_FORMAT = "index must be in range [%d, %d)";

    private final int size;

    private final byte[] bytePackages;

    /**
     * Constructor to create a BitMaskSet with the specified size.
     *
     * @param size the size of the bit mask set
     */
    public BitMaskSet(int size) {
        this.size = size;
        this.bytePackages = new byte[(size + Byte.SIZE - 1) / Byte.SIZE];
    }

    /**
     * Checks if the bit at the specified index is set.
     *
     * @param index the index to check
     * @return true if the bit is set, false otherwise
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public boolean isChecked(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format(INDEX_OUT_OF_BOUNDS_MESSAGE_FORMAT, 0, size));
        }

        return (Byte.toUnsignedInt(bytePackages[index / Byte.SIZE]) & (1 << (index % Byte.SIZE))) != 0;
    }

    /**
     * Sets the bit at the specified index to the specified value.
     *
     * @param index the index to set
     * @param value the value to set (true for set, false for unset)
     * @throws IndexOutOfBoundsException if the index is out of bounds
     * @see #add(int)
     * @see #remove(int)
     */
    public void set(int index, boolean value) {
        if (value) {
            add(index);
        }
        else {
            remove(index);
        }
    }

    /**
     * Adds the bit at the specified index.
     *
     * @param index the index to add
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void add(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format(INDEX_OUT_OF_BOUNDS_MESSAGE_FORMAT, 0, size));
        }

        bytePackages[index / Byte.SIZE] |= (byte) (1 << (index % Byte.SIZE));
    }

    /**
     * Removes the bit at the specified index.
     *
     * @param index the index to remove
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format(INDEX_OUT_OF_BOUNDS_MESSAGE_FORMAT, 0, size));
        }

        bytePackages[index / Byte.SIZE] &= (byte) ~(1 << (index % Byte.SIZE));
    }

    /**
     * Toggles the bit at the specified index.
     *
     * @param index the index to toggle
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public void toggle(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format(INDEX_OUT_OF_BOUNDS_MESSAGE_FORMAT, 0, size));
        }

        bytePackages[index / Byte.SIZE] ^= (byte) (1 << (index % Byte.SIZE));
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
