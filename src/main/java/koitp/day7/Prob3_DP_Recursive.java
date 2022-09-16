package koitp.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob3_DP_Recursive {
	public static int N;	// ī�� ����
	public static int M;	// ���� ����
	public static int K;	// ���� ����
	public static char[] card;
	public static ArrayList<ArrayList<int[]>> list;
//	public static HashMap<Integer, HashMap<Integer, Character>> map;
	public static int[][] cache;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		card = new char[N];
//		map = new HashMap<Integer, HashMap<Integer, Character>>();
		list = new ArrayList<ArrayList<int[]>>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = st.nextToken().charAt(0);
		}
		
		st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
//			map.put(i, new HashMap<Integer, Character>());
			list.add(new ArrayList<int[]>());
		}
		
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			char load = st.nextToken().charAt(0);
			list.get(u).add(new int[]{v, load});
			list.get(v).add(new int[]{u, load});
//			map.get(u).put(v, load);
//			map.get(v).put(u, load);
		}
		
		cache = new int[N + 1][M];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(cache[i], -1);
		}
		
		System.out.println(dp(0, 0) * 10);
	}
	
	public static int dp(int cardIndex, int index) {
		if (cardIndex == N) {
			return 0;
		}
		
		if (cache[cardIndex][index] != -1) {
			return cache[cardIndex][index];
		}
		
		cache[cardIndex][index] = 0;
//		HashMap<Integer, Character> temp = map.get(index);
		ArrayList<int[]> temp = list.get(index);
		int size = list.get(index).size();
		for (int i = 0; i < size; i++) {
			int[] info = temp.get(i);
			int nextIndex = info[0];
			char load = (char) info[1];
			
			if (card[cardIndex] == load) {
				cache[cardIndex][index] = Math.max(cache[cardIndex][index], dp(cardIndex + 1, nextIndex) + 1);
			}
			else {
				cache[cardIndex][index] = Math.max(cache[cardIndex][index], dp(cardIndex + 1, nextIndex));
			}
		}
//		for (int nextIndex : temp.keySet()) {
//			if (card[cardIndex] == temp.get(nextIndex)) {
//				cache[cardIndex][index] = Math.max(cache[cardIndex][index], dp(cardIndex + 1, nextIndex) + 1);
//			}
//			else {
//				cache[cardIndex][index] = Math.max(cache[cardIndex][index], dp(cardIndex + 1, nextIndex));
//			}
//		}
		return cache[cardIndex][index];
	}
	
}
