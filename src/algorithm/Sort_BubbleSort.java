package algorithm;
import java.util.Arrays;

public class Sort_BubbleSort {

	public static void main(String[] args) {
		int[] a = {4, 3, 1, 5, 2};
		
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
