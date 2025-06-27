package algorithm.sorting;
import java.util.Arrays;


public class Sort_MergeSort {

	public static void main(String[] args) {
		int[] a = {4, 3, 1, 5, 2};
		mergeSort(a, 0, 4);
		System.out.println(Arrays.toString(a));
		
	}
	
	public static void merge(int[] a, int startIndex, int midIndex, int endIndex) {
		int[] b = new int[endIndex - startIndex + 1];
		int x = startIndex;
		int y = midIndex;
		int i = 0;
		
		while (x < midIndex && y <= endIndex) {
			if (a[x] < a[y])
				b[i++] = a[x++];
			else 
				b[i++] = a[y++];
		}
		
		while (x < midIndex)
			b[i++] = a[x++];
		while (y <= endIndex)
			b[i++] = a[y++];
		x = startIndex;
		for (i = 0; i < endIndex - startIndex + 1 ; i++) {
			a[x] = b[i];
			x++;
		}
	}
	
	public static void mergeSort(int[] a, int startIndex, int endIndex) {
		if (startIndex >= endIndex)
			return;
		mergeSort(a, startIndex, (startIndex + endIndex) / 2);
		mergeSort(a, (startIndex + endIndex) / 2 + 1, endIndex);
		merge(a, startIndex, (startIndex + endIndex) / 2 + 1, endIndex);
	}
}
