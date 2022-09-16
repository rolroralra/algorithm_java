package algorithm;

public class Combination {
	
	public static int result = 0;
	public static int cnt = 0;
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 6, 7};
		int n = 5;
		int k = 3;
		boolean[] isChecked = new boolean[n];
		
		combination(arr, 0, 0, n, k, isChecked);
		System.out.println(result);
		System.out.println(cnt);
	}
	
	public static void combination2(int[] arr, int index, int count, int n, int k, boolean[] isChecked) {
		cnt++;
//		if (index > n - k + count) {
//			return;
//		}
		
		if (count == k) {
			for (int i = 0; i < index; i++) {
				if (isChecked[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			result++;
			return;
		}
		
//		for (int i = index; i < n; i++) {
		for (int i = index; i <= n - k + count; i++) {
			isChecked[i] = true;
			combination2(arr, i + 1, count + 1, n, k, isChecked);
			isChecked[i] = false;
		}
	}
	
	public static void combination(int[] arr, int index, int count, int n , int k, 
								   boolean[] isChecked) {
		cnt++;
//		if (n - index < k - count) {
//			return;
//		}
		
		if (count == k) {
//			for (int i = 0; i < n; i++) {			// 이럴경우.. depth가 n까지 가지 않고... 
//				if (isChecked[i]) {					// 중간에 재귀를 중단하는거라.. 
//					System.out.print(arr[i] + " ");	// 밑에 isChecked 값 복구안하면 안됨!!!!!
//				}
//			}
			for (int i = 0; i < index; i++) {		
				if (isChecked[i]) {					
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			result++;
			return;
		}
		
		isChecked[index] = true;
		combination(arr, index + 1, count + 1, n, k, isChecked);
		isChecked[index] = false;
		if (index < n - k + count) {
			combination(arr, index + 1, count, n, k, isChecked);
		}
		
//		isChecked[index] = false;
//		combination(arr, index + 1, count, n, k, isChecked);
//		isChecked[index] = true;
//		combination(arr, index + 1, count + 1, n, k, isChecked);
//		isChecked[index] = false;		
		// 처음에 이 함수 호출 될때, false값을 가지고 있었으므로.. 값 복구
	}
}
