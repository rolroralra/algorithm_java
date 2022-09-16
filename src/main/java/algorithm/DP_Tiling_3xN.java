package algorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP_Tiling_3xN {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine().trim());
		
		if (N % 2 == 1) {
			System.out.println(0);
			System.exit(0);
		}
		
		N /= 2;
		int[] cache = new int[N + 1];
		cache[0] = 1;
		cache[1] = 3;
		int sum = cache[0];
		for (int i = 2; i <= N; i++) {
			cache[i] = cache[i - 1] * 3 + sum * 2;
			sum += cache[i - 1];
		}
		
		System.out.println(cache[N]);
	}
}
