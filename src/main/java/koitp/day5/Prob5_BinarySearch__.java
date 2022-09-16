package koitp.day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Prob5_BinarySearch__ {
	public static int N;
	public static int[] arr;
	public static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
		N = Integer.parseInt(in.readLine().trim());
		arr = new int[N];
		long result = 0;
		list = new ArrayList<	>();
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]  = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N - 1; i >= 0; i--) {
			int index = Collections.binarySearch(list, arr[i]);
			if (index < 0) {
				index = -(index + 1);
			}
			list.add(index, arr[i]);
			result += index;
		}
		System.out.println(result);
	}
}
