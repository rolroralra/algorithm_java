package koitp.day1;
public class Main {
	public static void main(String[] args) throws Exception {
		
		int[] arr = new int[]{1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3};
		
		int s = 0;
		int e = arr.length - 1;
		int lb = 0;
		int ub = 0;
		int key = 2;
		while (s <= e) {
			int mid = (s + e) >> 1;
//			if (arr[mid] >= key) {
//				e = mid - 1;
//				lb = mid;
//			}
//			else {
//				s = mid + 1;
//			}
			if (arr[mid] <= key) {
				s = mid + 1;
				ub = mid;
			}
			else {
				e = mid - 1;
			}
		}
		
//		System.out.println(lb);
		System.out.println(ub);
	}
}
