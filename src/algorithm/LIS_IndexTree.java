package algorithm;

/*
 * 다시 정리하면 LIS에서 고려해야 할 것은 2가지인데 일단
 * 	1. LIS에서 자신의 앞에 있는 요소가 자기보다 전부 작아야 한다는 것.
 * 	2. LIS에서 자신의 앞에 있는 요소가 원래 있는 위치보다 앞에 있어야 한다는 것.
 * 여기서 값에 대한 정렬을 해줌으로서 1번에 대한 내용을 삭제할 수 있습니다.
 * 
 * 중복이 있을 수 있는 경우, 값이 동일해도 LIS가 되는 경우와 안되는 경우가 있을 수 있습니다. 
 * 	1. 그럴 땐 인덱스 기준을 큰것부터 나열하게 하면 뒤부터 처리가 되므로 
 * 	   동일값에 대한 LIS를 허용하지 않는 것에 대한 결과가 나오게 되고 (위치가 더 큰 것에 대한 참조X)
 * 	2. 인덱스 기준을 작은것부터 나열하면 앞부터 처리가 되므로 자연스럽게 동일값 허용 LIS에 대한
 *     결과가 나오게 됩니다. 
*/
public class LIS_IndexTree {	// LIS(Longest Increasing Subsequence) Algorithm
	public static void main(String[] args) {
		int[] arr = new int[]{8, 12, 15, 9, 13, 1, 14, 5};
		int n = arr.length;
		
		
	}
}
