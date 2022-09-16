package koitp.day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine().trim());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			
			int[][][] cache = new int[N][K + 1][2];
			
			cache[0][0][0] = 1;
			cache[0][0][1] = 1;
			
			for (int i = 1; i < N; i++) {
				for (int k = 0; k <= i && k <= K; k++) {
					cache[i][k][0] = cache[i - 1][k][0] + cache[i - 1][k][1];
					cache[i][k][1] = (k == 0 ? 0 : cache[i - 1][k - 1][1]) + cache[i - 1][k][0];
				}
			}
			
			System.out.println(test_case + " " + (cache[N - 1][K][0] + cache[N - 1][K][1]));
		}
	}
}
