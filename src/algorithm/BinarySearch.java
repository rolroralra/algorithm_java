package algorithm;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 8, 10, 14};
		
		System.out.println(binarySearchByLoop(arr, 6, 0, arr.length - 1));
	}
	
	public static int binarySearchByLoop(int[] arr, int value, int low, int high) {
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] > value) {											
				high = mid - 1;
			}
			else if (arr[mid] < value) {
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1 * (low + 1);	//     0     1     2      3  ......          n - 2     n - 1
	}							// -1    -2    -3     -4     -5  .. -(n - 1)       -n        -(n + 1)
	
	public static int binarySearchByRecursive(int[] arr, int value, int low, int high) {
		if (low > high) {
			return -1 * (low + 1);
		}
		
		int mid = (low + high) / 2;
		if (arr[mid] > value) {
			return binarySearchByRecursive(arr, value, low, mid - 1);
		}
		else if (arr[mid] < value) {
			return binarySearchByRecursive(arr, value, mid + 1, high);
		}
		else {
			return mid;
		}
	}
}
