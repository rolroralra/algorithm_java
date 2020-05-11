package koitp.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob5 {
	public static long A;
	public static long M;
	public static final int MOD = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		A = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int maxBit = 1;
		boolean[] isBitChecked = new boolean[64];
		for (int i = 0; i < 64; i++) {
			if (((M >> i) & 1) == 1) {
				maxBit = i;
				isBitChecked[i] = true;
			}
		}
		
		int[] cache = new int[maxBit + 1];
		cache[0] = (int) (A % MOD);
		
		for (int i = 1; i <= maxBit; i++) {
			cache[i] = (int) (((long) cache[i - 1] * cache[i - 1]) % MOD); 
		}
		
		int result = cache[maxBit];
		for (int i = maxBit - 1; i >= 0; i--) {
			if (isBitChecked[i]) {
				result = (int) (((long) result * cache[i]) % MOD);
			}
		}
		System.out.println(result);
	}
}
