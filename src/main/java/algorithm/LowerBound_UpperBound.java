package algorithm;

public class LowerBound_UpperBound {
	public static void main(String[] args) throws Exception {
		int[] arr = new int[]{1, 3, 5, 5, 5, 7};
		
		int s = 0;
		int e = arr.length - 1;
		int key = 8;
		
		int lbt = arr.length;
		// lowerBound(s, e, key) --> [s, e] 범위에서 key값 보다 크거나 같은 최초의 index
		while (s <= e) {		// lowerBound Code
			int mid = (s + e) >> 1;
			if (arr[mid] < key) {
				s = mid + 1;
			}
			else {
				lbt = mid;
				e = mid - 1;
			}
		}
		System.out.println("lowerBound = " + s);
		System.out.println("lbt = " + lbt);
		
		
		s = 0;
		e = arr.length - 1;
		int ubt = -1;
		// upperBound(s, e, key) --> [s, e] 범위에서 key값 보다 큰 최초의 index
		while (s <= e) {		// upperBound Code
			int mid = (s + e) >> 1;
			if (arr[mid] <= key) {
				s = mid + 1;
			}
			else {
				ubt = mid;
				e = mid - 1;
			}
		}
		System.out.println("upperBound = " + s);
		System.out.println("ubt = " + ubt);
		System.out.println();
		
		// ************ lowerBound ******************************
		s = 0;
		e = arr.length - 1;
		// s, e, key : [s, e] 범위에서 key값 보다 크거나 같은 최초의 index
		int lb = arr.length;	// lowerBound Code
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
		System.out.println("lowerBound = " + lb);
		
		
		// ************ upperBound ******************************
		s = 0;
		e = arr.length - 1;
		// s, e, key : [s, e] 범위에서 key값 보다 작거나 같은 최후의 index
		int ub = -1;			// upperBound Code
		while (s <= e) {
			int mid = (s + e) >> 1;
			if (arr[mid] <= key) {
				s = mid + 1;
				ub = mid;
			}
			else {
				e = mid - 1;
			}
		}
		System.out.println("upperBound = " + ub);
	}
}
