package algorithm;

import java.util.Objects;
import java.util.function.BinaryOperator;

public class FenwickTree<T> {

    private final T[] tree;
    private final BinaryOperator<T> addOperator;
    private final int originalDataSize;
    private static final int BASE_INDEX = 1;

    public static int[] fenwickTree;


    public FenwickTree(int originDataSize, BinaryOperator<T> addOperator) throws Exception {
        if (originDataSize <= 0) {
            throw new Exception("Origin Data Size must be positive!");
        }

        if (addOperator == null) {
            throw new Exception("Operator should not null.");
        }

        this.addOperator = addOperator;
        originalDataSize = originDataSize;
        this.tree = (T[]) new Object[originalDataSize + BASE_INDEX];
    }

    public FenwickTree(T[] originDataArray, BinaryOperator<T> addOperator) throws Exception {
        this(originDataArray.length, addOperator);
        this.init(originDataArray);
    }

    private void init(T[] originDataArray) throws Exception {
        if (originDataArray.length > tree.length - 1) {
            throw new Exception(
                    "Input Data size is overflow! (Input Data Size : " + originDataArray.length +
                            ", Current Data Size : " + originalDataSize + ")");
        }

        for (int index = 0; index < originDataArray.length; index++) {
            this.update(index, originDataArray[index]);
        }
    }


    public T query(int index) {
        index += BASE_INDEX;

        T result = null;
        while (index >= BASE_INDEX) {
            result = Objects.isNull(result) ? tree[index] : addOperator.apply(result, tree[index]);
            index -= index & -index;
        }
        return result;
    }

    // update(index, value) : arr[index - 1] 의 값을 value만큼 update (arr[index - 1] += value;
    public void update(int index, T value) {
        index += BASE_INDEX;

        while (index < tree.length) {
            tree[index] = Objects.isNull(tree[index]) ? value : addOperator.apply(tree[index], value);
            index += index & -index;
        }
    }

    public static void main(String[] args) throws Exception {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        FenwickTree<Integer> fenwickTree = new FenwickTree<>(arr, Integer::sum);

        System.out.println(fenwickTree.query(3));
        fenwickTree.update(0, 1);
        System.out.println(fenwickTree.query(3));
        fenwickTree.update(0, -1);
        fenwickTree.update(5, 1);
        System.out.println(fenwickTree.query(3));
        System.out.println(fenwickTree.query(4));
        System.out.println(fenwickTree.query(5));
    }


}
