package koitp.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Prob6 {
	public static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine().trim());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(in.readLine().trim()));
			if (i % 2 == 0) {
				Collections.sort(list);
				sb.append(list.get((i + 1) / 2)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
