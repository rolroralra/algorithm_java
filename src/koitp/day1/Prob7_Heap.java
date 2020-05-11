package koitp.day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Prob7_Heap {
	public static ArrayList<State> list;
	public static int[] dx = new int[]{1, -1, 0, 0};
	public static int[] dy = new int[]{0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine().trim());
		int[][] arr = new int[N][N];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] isVisited = new boolean[N][N];
		
		list = new ArrayList<State>();
		isVisited[0][0] = true;
		list.add(new State(0, 0, arr[0][0], arr[0][0]));
		
		int result = Integer.MAX_VALUE;
		
		while (!list.isEmpty()) {
			State currState = list.get(0);
			swap(0, list.size() - 1);
			list.remove(list.size() - 1);
			sift_topDown(0);
			
			int currRow = currState.row;
			int currCol = currState.col;
			int currMin = currState.min;
			int currMax = currState.max;
			
			if (currRow == N - 1 && currCol == N - 1) {
				result = Math.min(result, currMax - currMin);
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int nextRow = currRow + dx[i];
				int nextCol = currCol + dy[i];
				
				if (isInside(nextRow, nextCol, N) && !isVisited[nextRow][nextCol]) {
					int nextMin = Math.min(currMin, arr[nextRow][nextCol]);
					int nextMax = Math.max(currMax, arr[nextRow][nextCol]);
					isVisited[nextRow][nextCol] = true;
					list.add(new State(nextRow, nextCol, nextMin, nextMax));
					sift_bottomUp(list.size() - 1);
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static void swap(int i, int j) {
		if (i == j) {
			return;
		}
		
		State temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	public static boolean isInside(int row, int col, int N) {
		return row >= 0 && row < N && col >= 0 && col < N;
	}
	
	public static void sift_bottomUp(int index) {
		int parent = (index - 1) >> 1;
		while (parent >= 0) {
			if (list.get(parent).getValue() > list.get(index).getValue()) {
				swap(parent, index);
				index = parent;
				parent = (index - 1) >> 1;
			}
			else {
				break;
			}
		}
	}
	
	public static void sift_topDown(int index) {
		int parent = index;
		int leftChild = (parent << 1) + 1;
		int rightChild = leftChild + 1;
		
		while (leftChild < list.size()) {
			int minIndex = parent;
			if (list.get(minIndex).getValue() > list.get(leftChild).getValue()) {
				minIndex = leftChild;
			}
			
			if (rightChild < list.size() && list.get(minIndex).getValue() > list.get(rightChild).getValue()) {
				minIndex = rightChild;
			}
			
			if (minIndex == parent) {
				break;
			}
			else {
				swap(minIndex, parent);
				parent = minIndex;
				leftChild = (parent << 1) + 1;
				rightChild = leftChild + 1;
			}
		}
	}
	
	static class State {
		int row;
		int col;
		int min;
		int max;
		public State(int row, int col, int min, int max) {
			super();
			this.row = row;
			this.col = col;
			this.min = min;
			this.max = max;
		}
		@Override
		public String toString() {
			return "State [row=" + row + ", col=" + col + ", min=" + min + ", max=" + max + "]";
		}
		
		public int getValue() {
			return max - min;
		}
	}
}
