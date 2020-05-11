package koitp.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Prob5 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = in.readLine().trim().toCharArray();
		int N = arr.length;
		
		ArrayList<String> suffixList = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		for (int i = N - 1; i >= 0; i--) {
			sb.insert(0, arr[i]);
			suffixList.add(sb.toString());
		}
		
		Collections.sort(suffixList);
		for (String s : suffixList) {
			System.out.println(s);
		}
	}	
}
