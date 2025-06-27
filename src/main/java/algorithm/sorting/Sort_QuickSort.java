package algorithm.sorting;
import java.util.Arrays;
/**
 * # choose pivot
 * <p>swap a[1,rand(1,n)]
 * <p># 2-way partition
 * <p>k = 1
 * <p>for i = 2:n, if a[i] < a[1], swap a[++k,i]
 * <p>swap a[1,k]
 * <p>→ invariant: a[1..k-1] < a[k] <= a[k+1..n]
 * <p>
 * <p># recursive sorts
 * <p>sort a[1..k-1]
 * <p>sort a[k+1,n]
 */
public class Sort_QuickSort {
	public static int cnt = 0;
	public static void main(String[] args) {
//		int arr[] = {485,241,454,325,452,685,498,890,281};
		int arr[] = {11,11,11,11,11,11,11,11,11};
		
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		System.out.println(cnt);
	}
	
	public static void quickSort(int[] a, int left, int right) {
		cnt++;
		if (left >= right) {
			return;
		}
		int index = left;
		for (int i = left + 1; i <= right; i++) {
			if (a[i] < a[left]) {
				swap(a, i, ++index);
			}
		}
		swap(a, left, index);
		quickSort(a, left, index - 1);
		quickSort(a, index + 1, right);
	}	
	
	public static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}
