package algorithm;

public class Permutation {
	public static int result = 0;
	public static int cnt = 0;
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 6, 7};
		int n = 3;
		int k = 2;
		boolean[] isChecked = new boolean[n];
		int[] permutation = new int[k];
		
		permutationByBacktracking(arr, 0, n, k, isChecked, permutation);
		//permutation(arr, 0, n, k);
		System.out.println(result);
		System.out.println(cnt);
	}
	
	public static void permutation(int[] arr, int depth, int n, int k) {
		cnt++;
		if (depth == k) {
			for (int i = 0; i < k; i++) 
				System.out.print(arr[i] + " ");
			System.out.println();
			result++;
			return;
		}
		
		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, k);
			swap(arr, depth, i);
		}
	}
	
	public static void permutationByBacktracking(int[] arr, int depth, int n, int k, 
											 	 boolean[] isChecked, int[] permutation) {
		cnt++;
		if (depth == k) {
			for (int i = 0; i < k; i++)	
				System.out.print(permutation[i] + " ");
			System.out.println();
			result++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isChecked[i]) {
				continue;
			}
			permutation[depth] = arr[i];
			isChecked[i] = true;
			permutationByBacktracking(arr, depth + 1, n, k, isChecked, permutation);
			isChecked[i] = false;
		}
	}
	
	public static void swap(int[] arr, int x, int y) {
		if (arr[x] == arr[y]) {
			return;
		}
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
