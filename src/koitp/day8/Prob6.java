package koitp.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Prob6 {
	public static String A;
	public static String B;
	public static int N;
	public static int M;
	public static int[] f;
	public static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<Integer>();
		
		A = in.readLine().trim();
		B = in.readLine().trim();
		
		N = A.length();
		M = B.length();
		
		f = new int[M + 1];
		
		failureFunction();
		KMP();
		
		System.out.println(list.size());
		for (int i : list) {
			System.out.println(i);
		}
	}
	
	public static void KMP() {
		int i = 0, j = 0;
		while (i < N) {
			if (j == -1 || A.charAt(i) == B.charAt(j)) {
				i++; j++;
			}
			else {
				j = f[j];
			}
			
			if (j == M) {
				list.add(i - M  + 1);
				j = f[j];
			}
		}
	}
	
	public static void failureFunction() {
		int i = 0, j = -1;
		f[0] = -1;
		while (i < M) {
			if (j == -1 || B.charAt(i) == B.charAt(j)) {
				f[++i] = ++j;
			}
			else {
				j = f[j];
			}
		}
	}
}
