package koitp.day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob4 {
	public static int N;
	public static int[] cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine().trim());
		int result = 0;
		cnt = new int[1000000];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (cnt[input] > 0) {
				cnt[input]--;
				cnt[input - 1]++;
			}
			else {
				cnt[input - 1]++;
				result++;
			}
		}
		
		System.out.println(result);
	}
}
