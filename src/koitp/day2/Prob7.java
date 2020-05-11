package koitp.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob7 {
	public static int N;
	public static int K;
	public static Flower[] arr;
	public static char[] cmd;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new Flower[N];
		cmd = in.readLine().trim().toCharArray();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			arr[i] = new Flower(row, col);
		}
		
		Flower currFlower = arr[0];
		
		Flower.quickSort(arr, 0, N - 1, 0);
		
		for (int i = 0; i < N - 1; i++) {
			if (arr[i].diff == arr[i + 1].diff) {
				arr[i].next[0] = arr[i + 1];
				arr[i + 1].next[3] = arr[i];
			}
		}
		
		Flower.quickSort(arr, 0, N - 1, 1);
		for (int i = 0; i < N - 1; i++) {
			if (arr[i].sum == arr[i + 1].sum) {
				arr[i].next[1] = arr[i + 1];
				arr[i + 1].next[2] = arr[i];
			}
		}
		
		for (int i = 0; i < K; i++) {
			switch (cmd[i]) {
			case 'A':
				currFlower = currFlower.move(0);
				break;
			case 'B':
				currFlower = currFlower.move(1);
				break;
			case 'C':
				currFlower = currFlower.move(2);
				break;
			case 'D':
				currFlower = currFlower.move(3);
				break;
			}
		}
		
		System.out.println(currFlower.row + " " + currFlower.col);
	}
	
	static class Flower {
		int row;
		int col;
		Flower[] next;
		int diff;
		int sum;

		public Flower(int row, int col) {
			super();
			this.row = row;
			this.col = col;
			diff = row - col;
			sum = row + col;
			this.next = new Flower[4];
		}

		public Flower move(int moveType) {
			if (next[moveType] == null) {
				return this;
			}
			
			int revMoveType = 3 - moveType;
			
			int moveType1 = (moveType + 2) % 4;
			int moveType2 = 3 - moveType1;
			
			if (next[revMoveType] != null) {
				next[revMoveType].next[moveType] = next[moveType];
			}
			next[moveType].next[revMoveType] = next[revMoveType];
			
			if (next[moveType1] != null) {
				next[moveType1].next[moveType2] = next[moveType2];
			}
			
			if (next[moveType2] != null) {
				next[moveType2].next[moveType1] = next[moveType1];
			}
			
			return next[moveType];
		}
		
		public static void quickSort(Flower[] arr, int start, int end, int moveType) throws Exception {
			if (start >= end) {
				return;
			}
			
			int pivot = start;
			int index = pivot;
			for (int i = start + 1; i <= end; i++) {
				switch (moveType) {
				case 0: case 3:
					if (arr[i].diff < arr[pivot].diff || (arr[i].diff == arr[pivot].diff && arr[i].row < arr[pivot].row)) {
						swap(arr, ++index, i);
					}
					break;
				case 1: case 2:
					if (arr[i].sum < arr[pivot].sum || (arr[i].sum == arr[pivot].sum && arr[i].row < arr[pivot].row)) {
						swap(arr, ++index, i);
					}
					break;
				default:
					throw new Exception();
				}
//				if (comp(arr[i], arr[pivot], moveType) < 0) {
//					swap(arr, ++index, i);
//				}
			}
			
			swap(arr, index, pivot);
			quickSort(arr, start, index - 1, moveType);
			quickSort(arr, index + 1, end, moveType);
		}
		
		public static void swap(Flower[] arr, int i, int j) {
			if (i == j) {
				return;
			}
			
			Flower temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		public int comp(Flower o, int moveType) throws Exception {
			switch (moveType) {
			case 0: case 3:
				return diff == o.diff ? row - o.row : diff - o.diff;
			case 1: case 2:
				return sum == o.sum ? row - o.row : sum - o.sum;
			}
			throw new Exception();
		}
		
		public static int comp(Flower o1, Flower o2, int moveType) throws Exception {
			switch (moveType) {
			case 0: case 3:
				return o1.diff == o2.diff ? o1.row - o2.row : o1.diff - o2.diff;
			case 1: case 2:
				return o1.sum == o2.sum ? o1.row - o2.row : o1.sum - o2.sum;
			}
			throw new Exception();
		}

		@Override
		public String toString() {
			return "Flower [row=" + row + ", col=" + col + "]";
		}
	}
}
