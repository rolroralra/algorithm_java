package koitp.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Prob6_O_N {
    public static int N;
    public static final int MOD = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine().trim());
         
        int[] cache = new int[N + 1];
        cache[0] = 1;
        cache[1] = 1;
         
        for (int i = 2; i <= N; i++) {
            cache[i] = (cache[i - 1] + cache[i - 2]) % MOD;
        }
        
        System.out.println(cache[N]);
    }
}
