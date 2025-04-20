package algorithm;

import java.util.Comparator;
import java.util.List;

public class LowerUpperBound {
	/**
	 * Returns the index of the first element greater than or equal to the given target in the sorted list.
	 *
	 * @param <T> the type of elements in the list, which must implement Comparable
	 * @param list the sorted list
	 * @param target the target value
	 *
	 * @return the index of the first element greater than or equal to the target
	 */
	public static <T extends Comparable<T>> int lowerBound(List<T> list, T target) {
		return lowerBound(list, target, 0, list.size(), Comparator.naturalOrder());
	}

	/**
	 * Returns the index of the first element greater than or equal to the given target in the sorted list.
	 *
	 * @param <T> the type of elements in the list
	 * @param list the sorted list
	 * @param target the target value
	 * @param startIndexInclusive the starting index (inclusive)
	 * @param endIndexExclusive the ending index (exclusive)
	 * @param comparator the comparator to compare elements
	 * @return the index of the first element greater than or equal to the target
	 */
	public static <T> int lowerBound(List<T> list, T target, int startIndexInclusive, int endIndexExclusive, Comparator<? super T> comparator) {
		int start = startIndexInclusive;
		int end = endIndexExclusive - 1;
		int result = endIndexExclusive;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (comparator.compare(list.get(mid), target) < 0) {
				start = mid + 1;
			} else {
				end = mid - 1;
				result = mid;
			}
		}

		return (result >= startIndexInclusive && result < endIndexExclusive) ? result : -(result + 1);
	}

	/**
	 * Returns the index of the first element strictly greater than the given target in the sorted list.
	 *
	 * @param <T> the type of elements in the list, which must implement Comparable
	 * @param list the sorted list
	 * @param target the target value
	 * @return the index of the last element strictly greater than the target
	 */
	public static <T extends Comparable<T>> int upperBound(List<T> list, T target) {
		return upperBound(list, target, 0, list.size(), Comparator.naturalOrder());
	}

	/**
	 * Returns the index of the first element strictly greater than the given target in the sorted list.
	 *
	 * @param <T> the type of elements in the list
	 * @param list the sorted list
	 * @param target the target value
	 * @param startIndexInclusive the starting index (inclusive)
	 * @param endIndexExclusive the ending index (exclusive)
	 * @param comparator the comparator to compare elements
	 * @return the index of the first element strictly greater than the target
	 */
	public static <T> int upperBound(List<T> list, T target, int startIndexInclusive, int endIndexExclusive, Comparator<? super T> comparator) {
		int start = startIndexInclusive;
		int end = endIndexExclusive - 1;
		int result = endIndexExclusive;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (comparator.compare(list.get(mid), target) <= 0) {
				start = mid + 1;
			} else {
				end = mid - 1;
				result = mid;
			}
		}

		return (result >= startIndexInclusive && result < endIndexExclusive) ? result : -(result + 1);
	}

	public static void main(String[] args) {
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
