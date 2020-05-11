package koitp.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Prob1 {
	public static int N;
	public static int K;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		int currIndex = 0;
		while (true) {
			System.out.print(list.get(currIndex) + " ");
			
			list.remove(currIndex);
			if (list.size() == 0) {
				break;
			}
			
			if (currIndex == list.size()) {
				currIndex = 0;
			}
			currIndex = (currIndex + K - 1) % list.size();
		}
	}

}
