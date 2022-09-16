package koitp.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Prob8 {
	public static String S;
	public static String T;
	public static int N;
	public static int M;
	public static int[] f;
	public static Stack<int[]> stack;
	public static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		S = in.readLine().trim();
		T = in.readLine().trim();
		
		N = S.length();
		M = T.length();
		
		f = new int[M + 1];
		cnt = 0;
		
		stack = new Stack<int[]>();
		failureFunction();
		KMP();
		
		
		
		for (int i = 0; i < N; i++) {
			System.out.print(S.charAt(i));
		}
		System.out.println();
	}
	
	public static void KMP() {
		int i = 0, j = 0;
		while (i < N) {
			if (j == -1 || S.charAt(i) == T.charAt(j)) {
				i++; j++;
			}
			else {
				j = f[j];
			}
			
			if (j == M) {
				for (int k = 0; k < M; k++) {
					stack.pop();
				}
				
				if (stack.empty()) {
					j = f[j];
				}
				else {
					j = stack.peek()[1];
				}
			}
		}
	}
	
	public static void failureFunction() {
		int i = 0, j = -1;
		f[0] = -1;
		while (i < M) {
			if (j == -1 || T.charAt(i) == T.charAt(j)) {
				f[++i] = ++j;
			}
			else {
				j = f[j];
			}
		}
	}
}
