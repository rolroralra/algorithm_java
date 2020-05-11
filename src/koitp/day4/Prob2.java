package koitp.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class Prob2 {
	public static int K;
	public static int N;
	public static int M;
	public static int[] start;
	public static HashMap<Integer, HashSet<Integer>> map;
	public static boolean[][] isVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		start = new int[K];
		map = new HashMap<Integer, HashSet<Integer>>();
		isVisited = new boolean[K][N];
		
		for (int i = 0; i < K; i++) {
			start[i] = Integer.parseInt(in.readLine().trim()) - 1;
		}
		
		for (int i = 0; i < N; i++) {
			map.put(i, new HashSet<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			map.get(s).add(e);
		}
		
		for (int i = 0; i < K; i++) {
			Stack<Integer> stack = new Stack<Integer>();
			isVisited[i][start[i]] = true;
			stack.push(start[i]);
			while (!stack.empty()) {
				int currIndex = stack.pop();
				
				for (int nextIndex : map.get(currIndex)) {
					if (!isVisited[i][nextIndex]) {
						isVisited[i][nextIndex] = true;
						stack.push(nextIndex);
					}
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			boolean flag = true;
			for (int k = 0; k < K; k++) {
				if (!isVisited[k][i]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}
