package koitp.day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prob5 {
	public static int N;
	public static int K;
	public static int[][] J;
	public static int[] C;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		J = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			J[i][0] = Integer.parseInt(st.nextToken());	// ����
			J[i][1] = Integer.parseInt(st.nextToken());	// ��ġ
		}
		
		C = new int[K];
		for (int i = 0; i < K; i++) {
			C[i] = Integer.parseInt(in.readLine().trim());
		}
		
		Arrays.sort(J, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
			}
		});
		
		Arrays.sort(C);
		
		int result = 0;
		
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		
		int index = 0;
		for (int i = 0; i < K; i++) {
			int capacity = C[i];
			while (index < N && J[index][0] <= capacity) {
				queue.add(J[index++]);
			}
			result += queue.poll()[1];
		}
		System.out.println(result);
	}
}
