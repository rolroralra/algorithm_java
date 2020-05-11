package koitp.day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Prob1 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine().trim());
		
		long[][] cache = new long[N][2];
		
		cache[0][0] = 0;
		cache[0][1] = 1;
		
		for (int i = 1; i < N; i++) {
			cache[i][0] = cache[i - 1][0] + cache[i - 1][1];
			cache[i][1] = cache[i - 1][0];
		}
		
		long result = cache[N - 1][0] + cache[N - 1][1];
		System.out.println(result);
	}

}
