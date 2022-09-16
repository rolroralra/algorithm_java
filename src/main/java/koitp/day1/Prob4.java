package koitp.day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob4 {
	public static int N;
	public static int[] col;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine().trim());
		col = new int[N];
		
		System.out.println(backTracking(0));
	}
	
	public static int backTracking(int row) {
		if (row == N) {
			return 1;
		}
		
		int ret = 0;
		for (int c = 0; c < N; c++) {
			boolean flag = true;
			for (int r = 0; r < row; r++) {
				if (col[r] == c || Math.abs(row - r) == Math.abs(c - col[r])) {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				col[row] = c;
				ret += backTracking(row + 1);
			}
		}
		
		return ret;
	}
}
