package algorithm;
import java.util.Arrays;


// TODO: Implementation for Counting Sort
public class Sort_CountingSort {
	public static int cnt = 0;
	public static void main(String[] args) {
		int arr[] = {485,241,454,325,452,685,498,890,281};
//		int arr[] = {11,11,11,11,11,11,11,11,11};
		
		System.out.println(Arrays.toString(arr));
		System.out.println(cnt);
	}
	
	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
