package koitp.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Prob6_FloydWarshall_TLE {
	public static int N;
	public static int M;
	public static int W;
	public static int[][] adj;
	public static int[][] distance;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			adj = new int[N][N];
			distance = new int[N][N];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;
				int time = Integer.parseInt(st.nextToken());
				
				if (adj[s][e] != 0) {
					adj[s][e] = Math.min(adj[s][e], time);
				}
				else {
					adj[s][e] = time;
				}
				
				if (adj[e][s] != 0) {
					adj[e][s] = Math.min(adj[e][s], time);
				}
				else {
					adj[e][s] = time;
				}
			}
			
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(in.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;
				int timeLoss = Integer.parseInt(st.nextToken());
				adj[s][e] = -timeLoss;
			}
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
				for (int j = 0; j < N; j++) {
					if (adj[i][j] == 0) {
						continue;
					}
					distance[i][j] = adj[i][j];
				}
				distance[i][i] = 0;
			}
			
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE) {
							continue;
						}
						if (distance[i][j] > distance[i][k] + distance[k][j]) {
							distance[i][j] = distance[i][k] + distance[k][j];
						}
					}
				}
			}
			
			boolean isPossible = false;
			for (int i = 0; i < N; i++) {
				if (distance[i][i] < 0) {
					isPossible = true;
				}
			}
			
			if (isPossible) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}
	
}
