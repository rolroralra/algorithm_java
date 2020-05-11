package koitp.day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prob5_BinaryIndexTree {
	public static int N;
	public static int[] tree;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
		N = Integer.parseInt(in.readLine().trim());
		
		tree = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int result = 0;
		for (int i = 0; i < N; i++) {
			int index = Integer.parseInt(st.nextToken());
			result += index - 1 - sum(index - 1);
			
			update(index, 1);
		}
		
		System.out.println(result);
	}

	public static void update(int index, int change) {
		while (index <= N) {
			tree[index] += change;
			index += index & -index;
		}
	}
	
	public static int sum(int index) {
		int ret = 0;
		while (index > 0) {
			ret += tree[index];
			index -= index & -index;
		}
		return ret;
	}
}
