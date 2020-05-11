package koitp.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob4 {
	public static int N;
	public static int M;
	public static int[] parent;
	public static int[] depth;
	public static int[] person;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		parent = new int[N];
		Arrays.fill(parent, -1);
		depth = new int[N];
		person = new int[2];
		
		person[0] = Integer.parseInt(st.nextToken()) - 1;
		person[1] = Integer.parseInt(st.nextToken()) - 1;
		
		M = Integer.parseInt(in.readLine().trim());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int p = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			
			parent[c] = p;
			depth[c] = depth[p] + 1;
		}
		
		int a = person[0];
		int b = person[1];
		
		while (depth[a] > depth[b]) {
			a = parent[a];
		}
		
		while (depth[a] < depth[b]) {
			b = parent[b];
		}
		
		while (a >= 0 && b >= 0 && a != b) {
			a = parent[a];
			b = parent[b];
		}
		
		if (a < 0) {
			System.out.println("-1");
		}
		else {
			System.out.println(depth[person[0]] + depth[person[1]] - 2 * depth[a]);
		}
	}
}
