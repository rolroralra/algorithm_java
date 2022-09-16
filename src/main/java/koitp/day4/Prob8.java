package koitp.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Prob8 {
	public static int N;
	public static HashMap<Integer, HashSet<Integer>> map;
	public static int[][] cache;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		cache = new int[N][N];
		map = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 0; i < N; i++) {
			Arrays.fill(cache[i], -1);
			map.put(i, new HashSet<Integer>());
		}
		
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			
			map.get(s).add(e);
			map.get(e).add(s);
			
		}
		
		int result = 0;
		for (int i = 0; i < N - 1; i++) {
			result += dfs(i, i + 1);
		}
		System.out.println(result);
	}
	
	public static int dfs(int from, int to) {
		if (cache[from][to] != -1) {
			return cache[from][to];
		}
		
		cache[from][to] = N + 1;
		for (int next : map.get(from)) {
			if (next == to) {
				return 1;
			}
			cache[from][to] = Math.min(cache[from][to], dfs(next, to) + 1);
		}
		return cache[from][to];
	}
	
	
}
