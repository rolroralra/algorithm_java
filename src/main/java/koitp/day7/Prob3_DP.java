package koitp.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob3_DP {
	public static int N;	// ī�� ����
	public static int M;	// ���� ����
	public static int K;	// ���� ����
	public static char[] card;
	public static ArrayList<ArrayList<int[]>> list;
	public static int[][] cache;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		card = new char[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = st.nextToken().charAt(0);
		}
		
		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<ArrayList<int[]>>(M);
		for (int i = 0; i < M; i++) {
			list.add(i, new ArrayList<int[]>());
		}
		
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			char load = st.nextToken().charAt(0);
			list.get(u).add(new int[]{v, load});
			list.get(v).add(new int[]{u, load});
		}
		
		cache = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(cache[i], -1);
		}
		
		for (int[] state : list.get(0)) {
			int index = state[0];
			char load = (char) state[1];
			if (card[0] == load) {
				cache[0][index] = 1;
			}
			else {
				cache[0][index] = 0;
			}
		}
		
		for (int c = 1; c < N; c++) {
			for (int i = 0; i < M; i++) {
				for (int[] state : list.get(i)) {
					int prevIndex = state[0];
					char load = (char) state[1];
					if (cache[c - 1][prevIndex] == -1) {
						continue;
					}
					
					if (card[c] == load) {
						cache[c][i] = Math.max(cache[c][i], cache[c - 1][prevIndex] + 1);
					}
					else {
						cache[c][i] = Math.max(cache[c][i], cache[c - 1][prevIndex]);
					}
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < M; i++) {
			result = Math.max(result, cache[N - 1][i]);
		}
		System.out.println(result * 10);
	}
}
