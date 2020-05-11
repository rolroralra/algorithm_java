package koitp.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Prob4_Stack {
	public static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine().trim());
		int[] result = new int[N];
		Stack<int[]> stack = new Stack<int[]>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			int currHeight = Integer.parseInt(st.nextToken());
			
			while (!stack.empty()) {
				int[] lazerTower = stack.peek();
				int height = lazerTower[0];
				int index = lazerTower[1];
				if (height >= currHeight) {
					result[i] = index + 1;
					break;
				}
				else {
					stack.pop();
				}
			}
			stack.push(new int[]{currHeight, i});
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}
