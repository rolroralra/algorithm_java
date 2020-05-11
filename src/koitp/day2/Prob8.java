package koitp.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob8 {
	public static int N;
	public static int K;
	public static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine().trim());
		}
		
		quickSort(0, N - 1);
		System.out.println(arr[K - 1]);
	}
	
	public static void quickSort(int start, int end) {
		if (start >= end) {
			return;
		}
		
		int pivot = start;
		int index = pivot;
		for (int i = start + 1; i <= end; i++) {
			if (arr[i] < arr[pivot]) {
				swap(++index, i);
			}
		}
		
		swap(index, pivot);
		
		if (index == K - 1) {
			return;
		}
		
		if (index < K - 1) {
			quickSort(index + 1, end);
		}
		else if (index > K - 1) {
			quickSort(start, index - 1);
		}
	}
	
	public static void swap(int i, int j) {
		if (i == j) {
			return;
		}
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
