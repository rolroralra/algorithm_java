package koitp.day9;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2_PointInPolygon {

	public static int N;
	public static int[][] arr;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		arr = new int[N][2];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] P = new int[2][2];
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(in.readLine());
			P[i][0] = Integer.parseInt(st.nextToken());
			P[i][1] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] result = new boolean[2];
		for (int i = 0; i < 2; i++) {
			int prevIndex = N - 1;
			for (int currIndex = 0; currIndex < N; currIndex++) {
				if ((arr[currIndex][1] < P[i][1] && P[i][1] <= arr[prevIndex][1]) ||
					(arr[prevIndex][1] < P[i][1] && P[i][1] <= arr[currIndex][1])) {
					if ((double) (P[i][1] - arr[currIndex][1]) * (arr[currIndex][0] - arr[prevIndex][0]) / (arr[currIndex][1] - arr[prevIndex][1])
							+ arr[currIndex][0] < (double) P[i][0]) {
						result[i] = !result[i];
					}
				}
				
				prevIndex = currIndex;
			}
		}
		
		for (int i = 0; i < 2; i++) {
			System.out.println(result[i] ? "in" : "out");
		}
	}
}
