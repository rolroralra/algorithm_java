package koitp.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Prob7 {
	public static int N;
	public static int[][] P;
	public static Comparator<int[]> compY;
	public static void main(String[] args) throws Exception {
		System.setIn(Prob7.class.getResourceAsStream("input.in"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		P = new int[N][2];
		compY = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		};
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			P[i][0] = Integer.parseInt(st.nextToken());	// X��ǥ
			P[i][1] = Integer.parseInt(st.nextToken());	// Y��ǥ
		}
		
		
		Arrays.sort(P, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		System.out.println(minPairDistance(0, N - 1));
	}
	
	public static int minPairDistance(int left, int right) {
		if (left >= right) {
			return Integer.MAX_VALUE;
		}
		
		int mid = (left + right) >> 1;
		int leftMin = minPairDistance(left, mid);
		int rightMin = minPairDistance(mid + 1, right);
		int tempMin = Math.min(leftMin, rightMin);
		
		int size = right - left + 1;
		int[][] tempArr = new int[size][];
		
		int i = left;
		int j = mid + 1;
		int k = 0;
		
		while (i <= mid && j <= right) {
			if (P[i][1] > P[j][1]) {
				tempArr[k++] = P[j++].clone();
			}
			else {
				tempArr[k++] = P[i++].clone();
			}
		}
		while (i <= mid) {
			tempArr[k++] = P[i++].clone();
		}
		while (j <= right) {
			tempArr[k++] = P[j++].clone();
		}
		
		for (k = 0, i = left; k < size; k++, i++) {
			P[i] = tempArr[k];
		}
		
		int start = mid + 1;
		for (int pivot = left; pivot <= mid; pivot++) {
			while (start <= right && (Math.abs(P[pivot][0] - P[start][0]) > tempMin || Math.abs(P[pivot][1] - P[start][1]) > tempMin)) {
				start++;
			}
			
			int index = start;
			while (index <= right && Math.abs(P[pivot][0] - P[index][0]) <= tempMin && Math.abs(P[pivot][1] - P[index][1]) <= tempMin) {
				int temp = distance(pivot, index);
				if (temp < tempMin) {
					tempMin = temp;
				}
				index++;
			}
		}
		return tempMin;
	}
	
	public static int distance(int i, int j) {
		if (i == j) {
			return 0;
		}
		return (P[i][0] - P[j][0]) * (P[i][0] - P[j][0]) + (P[i][1] - P[j][1]) * (P[i][1] - P[j][1]);
	}
}
