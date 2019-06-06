package algorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_Tiling_4xN {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] cache = new int[N + 1];
	
		cache[0] = 1;
		cache[1] = 1;
		cache[2] = 4;
		cache[3] = 2;
		for (int i = 4; i <= N; i++) {
			if (i % 2 == 0) {
				cache[i] = 3;
			}
			else {
				cache[i] = 2;
			}
		}
		
		
		int[] arr = new int[N + 1];
		arr[0] = cache[0];
		arr[1] = arr[0] * cache[1];
		arr[2] = arr[1] * cache[1] + arr[0] * cache[2];
		arr[3] = arr[2] * cache[1] + arr[1] * cache[2] + arr[0] * cache[3];
		
		for (int i = 4; i <= N; i++) {
			arr[i] = 0;
			for (int j = i - 1; j >= 0; j--) {
				arr[i] = (arr[i] + arr[j] * cache[i - j]) % M;
			}
		}
		System.out.println(arr[N]);
	}

}
