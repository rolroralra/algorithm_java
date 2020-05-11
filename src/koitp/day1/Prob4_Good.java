package koitp.day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob4_Good {
	public static int N;
	public static boolean[] col;
	public static boolean[] sum;
	public static boolean[] diff;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine().trim());
		col = new boolean[N];
		sum = new boolean[2 * N - 1];
		diff = new boolean[2 * N - 1];
		
		System.out.println(backTracking(0));
	}
	
	public static int backTracking(int row) {
		if (row == N) {
			return 1;
		}
		
		int ret = 0;
		for (int c = 0; c < N; c++) {
			if (sum[row + c] || diff[N - 1 + row - c] || col[c]) {
				continue;
			}
			
			col[c] = true;
			sum[row + c] = true;
			diff[N - 1 + row - c] = true;
			
			ret += backTracking(row + 1);
			
			col[c] = false;
			sum[row + c] = false;
			diff[N - 1 + row - c] = false;
		}
		
		return ret;
	}
}
