package koitp.day9;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1_PolygonArea {

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
		
		double area = 0;
		for (int i = 1; i < N; i++) {
			area += outerProduct(i - 1, i);
			area = (double) Math.round(area * 1000) / 1000;
		}
		area += outerProduct(N - 1, 0);
		if (area < 0) {
			area *= -1;
		}
		System.out.printf("%.1f\n", area);
	}
	
	public static double outerProduct(int i, int j) {
		return ((double) arr[i][0] * arr[j][1] - (double) arr[i][1] * arr[j][0]) / 2;
	}

}
