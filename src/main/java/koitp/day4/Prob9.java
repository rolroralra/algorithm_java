package koitp.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob9 {
	public static int a;
	public static int b;
	public static int d;
	public static int N;
	public static int[] memo;
	public static final int MOD = 1000;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		memo = new int[d];
		memo[0] = 1;
		int first = 0;
		int cntOfNewBaby = 0;
		int remainCnt = 1;
		for (int day = 0; day < N; day++) {
			first--;
			if (first < 0) {
				first = d - 1;
			}
			
			cntOfNewBaby += memo[(first + a) % d];
			cntOfNewBaby -= memo[(first + b) % d];
			cntOfNewBaby %= MOD;
			
			remainCnt -= memo[first];
			remainCnt += cntOfNewBaby;
			remainCnt %= MOD;
			memo[first] = cntOfNewBaby;
		}
		
		System.out.println(remainCnt);
	}
	
	
}
