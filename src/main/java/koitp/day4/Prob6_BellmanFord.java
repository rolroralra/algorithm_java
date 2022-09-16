package koitp.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob6_BellmanFord {
	public static int N;
	public static int M;
	public static int W;
	public static ArrayList<int[]> edgeList;
	public static int[] distance;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			edgeList = new ArrayList<int[]>();
			distance = new int[N];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;
				int time = Integer.parseInt(st.nextToken());
				
				edgeList.add(new int[]{s, e, time});
				edgeList.add(new int[]{e, s, time});
			}
			
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(in.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;
				int timeLoss = Integer.parseInt(st.nextToken());
				
				edgeList.add(new int[]{s, e, -timeLoss});
			}
			
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[0] = 0;
			
			for (int i = 0; i < N - 1; i++) {
				for (int[] edge : edgeList) {
					int s = edge[0];
					int e = edge[1];
					int time = edge[2];
					
					int newTime = distance[s] + time;
					if (distance[s] != Integer.MAX_VALUE && distance[e] > newTime) {
						distance[e] = newTime;
					}
				}
			}
			
			boolean isPossible = false;
			for (int[] edge : edgeList) {
				int s = edge[0];
				int e = edge[1];
				int time = edge[2];
				
				int newTime = distance[s] + time;
				if (distance[s] != Integer.MAX_VALUE && distance[e] > newTime) {
					distance[e] = newTime;
					isPossible = true;
					break;
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