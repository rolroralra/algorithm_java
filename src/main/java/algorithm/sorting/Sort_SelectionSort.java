package algorithm.sorting;
import java.util.Arrays;

public class Sort_SelectionSort {

	public static void main(String[] args) {
		int[] a = {4, 3, 1, 5, 2};
		
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int index = i;
			int min = a[i];
			for (int j = i + 1; j < n; j++) {
				if (min > a[j]) {
					index = j;
					min = a[j];
				}
			}
			int temp = a[index];
			a[index] = a[i];
			a[i] = temp;
		}
		System.out.println(Arrays.toString(a));
	}
}
