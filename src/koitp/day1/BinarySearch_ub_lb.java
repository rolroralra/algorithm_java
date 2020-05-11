package koitp.day1;
public class BinarySearch_ub_lb {
	public static void main(String[] args) throws Exception {
		
		int[] arr = new int[]{1, 1, 2, 2, 3, 3, 3, 5, 5, 5, 5};
		
		int s = 0;
		int e = arr.length - 1;
		int lb = arr.length;
		int key = 4;
		while (s <= e) {
			int mid = (s + e) >> 1;
			if (arr[mid] >= key) {
				e = mid - 1;
				lb = mid;
			}
			else {
				s = mid + 1;
			}
		}
		
		s = 0;
		e = arr.length - 1;
		int ub = -1;
		while (s <= e) {
			int mid = (s + e) >> 1;
			if (arr[mid] <= key) {
				s = mid + 1;
				ub = mid + 1;
			}
			else {
				e = mid - 1;
			}
		}
		System.out.println(lb);
		System.out.println(ub);
	}
}
