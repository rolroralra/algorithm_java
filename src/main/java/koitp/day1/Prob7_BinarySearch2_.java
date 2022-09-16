package koitp.day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob7_BinarySearch2_ {
	public static int[] dx = new int[]{1, -1, 0, 0};
	public static int[] dy = new int[]{0, 0, 1, -1};
	public static int N;
	public static int[][] arr;
	public static boolean[][] isVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine().trim());
		arr = new int[N][N];
		
		StringTokenizer st = null;
		int min = 201;
		int max = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i][j]);
				max = Math.max(max, arr[i][j]);
			}
		}
		
		int Answer = 0;
		int low = 0;
		int high = max - min;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (isPossible(mid)) {
				high = mid - 1;
				Answer = mid;
			}
			else {
				low = mid + 1;
			}
		}
		
		System.out.println(Answer);
	}
	
	public static boolean isPossible(int tempAnswer) {
		isVisited = new boolean[N][N];
		return backTracking(0, 0, arr[0][0], arr[0][0], tempAnswer);
	}
	
	public static boolean backTracking(int row, int col, int min, int max, int tempAnswer) {
		if (row == N - 1 && col == N - 1) {
			return true;
//			if (tempAnswer >= max - min) {
//				return true;
//			}
//			else {
//				return false;
//			}
		}
		
		for (int i = 0; i < 4; i++) {
			int nextRow = row + dx[i];
			int nextCol = col + dy[i];
			if (!isInside(nextRow, nextCol) || isVisited[nextRow][nextCol]) {
				continue;
			}
			
			int nextMin = Math.min(min, arr[nextRow][nextCol]);
			int nextMax = Math.max(max, arr[nextRow][nextCol]);
			
			if (nextMax - nextMin > tempAnswer) {
				continue;
			}
			
			isVisited[nextRow][nextCol] = true;
			if (backTracking(nextRow, nextCol, nextMin, nextMax, tempAnswer)) {
				return true;
			}
			isVisited[nextRow][nextCol] = false;
		}
		
		return false;
	}
	
	public static boolean isInside(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < N;
	}
	
}
