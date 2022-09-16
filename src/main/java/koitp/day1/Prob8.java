package koitp.day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob8 {
	public static int N;
	public static int M;
	public static int[][] arr;
	public static boolean[][] isVisited;
	public static int[] dx = new int[]{1, -1, 0, 0};
	public static int[] dy = new int[]{0, 0, 1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		isVisited = new boolean[N][M];
		
		int[] count = new int[2];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisited[i][j]) {
					count[arr[i][j]]++;
					isVisited[i][j] = true;
					backTracking(i, j, arr[i][j]);
				}
			}
		}
		
		System.out.println(Math.min(count[0], count[1]));
	}
	
	public static void backTracking(int row, int col, int group) {
		for (int i = 0; i < 4; i++) {
			int nextRow = row + dx[i];
			int nextCol = col + dy[i];
			
			if (isInside(nextRow, nextCol) && arr[nextRow][nextCol] == group && !isVisited[nextRow][nextCol]) {
				isVisited[nextRow][nextCol] = true;
				backTracking(nextRow, nextCol, group);
			}
		}
	}
	
	public static boolean isInside(int row, int col) {
		return row >= 0 && row < N && col >= 0 && col < N;
	}

}
