package koitp.day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob3_Sort {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		Part[] arr = new Part[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			int fun = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[i] = new Part(start, length, fun, cost);
		}
		
		long[][] cache = new long[L + 1][B + 1];
		for (int i = 0; i <= L; i++) {
			Arrays.fill(cache[i], -1);
		}
		cache[0][0] = 0;
		
//		Arrays.sort(arr);
		quickSort(arr, 0, N - 1);
		
		for (int i = 0; i < N; i++) {
			int start = arr[i].start;
			int length = arr[i].length;
			int fun = arr[i].fun;
			int cost = arr[i].cost;
			
			int bd = B - cost;
			for (int b = 0; b <= bd; b++) {
				if (cache[start][b] != -1) {
					cache[start + length][b + cost] = Math.max(cache[start + length][b + cost], cache[start][b] + fun);
				}
			}
		}
		
		long result = -1;
		for (int b = 0; b <= B; b++) {
			result = Math.max(result, cache[L][b]);
		}
		
		System.out.println(result);
	}
	
	public static void quickSort(Part[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		
		int pivot = start;
		int index = start;
		
		for (int i = start + 1; i <= end; i++) {
			if (arr[i].start < arr[pivot].start) {
				swap(arr, ++index, i);
			}
			else if (arr[i].start == arr[pivot].start && arr[i].length < arr[pivot].length) {
				swap(arr, ++index, i);
			}
		}
		
		swap(arr, pivot, index);
		quickSort(arr, start, index);
		quickSort(arr, index + 1, end);
	}
	
	public static void swap(Part[] arr, int i , int j) {
		if (i == j) {
			return;
		}
		
		Part temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static class Part {
		int start;
		int length;
		int fun;
		int cost;
		public Part(int start, int length, int fun, int cost) {
			super();
			this.start = start;
			this.length = length;
			this.fun = fun;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Part [start=" + start + ", length=" + length + ", fun=" + fun + ", cost=" + cost + "]";
		}
//		@Override
//		public int compareTo(Part o) {
//			return start == o.start ? length - o.length : start - o.start;
//		}
	}
}