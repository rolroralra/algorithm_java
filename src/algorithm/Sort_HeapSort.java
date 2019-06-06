package algorithm;
import java.util.Arrays;

public class Sort_HeapSort {
	public static int cnt = 0;
	public static void main(String[] args) {
		int arr[] = {485,241,454,325,452,685,498,890,281};
//		int arr[] = {11,11,11,11,11,11,11,11,11};
		
		heapSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		System.out.println(cnt);
	}
	
	public static void heapSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		
//		heapify_bottom_up(arr, left, right);
		heapify_top_down(arr, left, right);
		int end = right;
		while (end > left) {
			swap(arr, left, end--);
			siftDown(arr, left, end, 0);
		}
	}	
	
	public static void heapify_top_down(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int size = right - left + 1;
		for (int end = 1; end < size; end++) {
			siftUp(arr, left, right, end);
		}
	}
	
	public static void heapify_bottom_up(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		
		int size = right - left + 1;
		for (int heapIndex = (size - 1) >> 1; heapIndex >= 0; heapIndex--) {
			siftDown(arr, left, right, heapIndex);
		}
	}
	
	public static void siftUp(int[] arr, int left, int right, int heapIndex) {
		while (heapIndex > 0) {
			int parentHeapIndex = (heapIndex - 1) >> 1;
			if (arr[left + heapIndex] > arr[left + parentHeapIndex]) {
				swap(arr, left + heapIndex, left + parentHeapIndex);
				heapIndex = parentHeapIndex;
			}
			else {
				return;
			}
		}
	}
	
	public static void siftDown(int[] arr, int left, int right, int heapIndex) {
		int size = right - left + 1;
		int leftIndex = (heapIndex << 1) + 1;
		int rightIndex = leftIndex + 1;
		while (leftIndex < size) {
			int maxIndex = heapIndex;
			if (arr[maxIndex] < arr[leftIndex]) {
				maxIndex = leftIndex;
			}
			if (rightIndex < size && arr[maxIndex] < arr[rightIndex]) {
				maxIndex = rightIndex;
			}
			
			if (maxIndex != heapIndex) {
				swap(arr, left + maxIndex, left + heapIndex);
				heapIndex = maxIndex;
				leftIndex = (heapIndex << 1) + 1;
				rightIndex = leftIndex + 1;
			}
			else {
				return;
			}
		}
	}
	
	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
