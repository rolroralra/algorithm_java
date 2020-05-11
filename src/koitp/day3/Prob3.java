package koitp.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prob3 {
	public static int N;
	public static int[] prime = new int[]{2, 3, 5, 7};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> list = new ArrayList<>(5842);
		
		PriorityQueue<MultipicationSmallPrime> queue = new PriorityQueue<MultipicationSmallPrime>();
		queue.add(new MultipicationSmallPrime(1, 0));
		while (list.size() < 5842) {
			MultipicationSmallPrime curr = queue.poll();
			int num = curr.num;
			int ps = curr.ps;
			list.add(num);
			
			for (int p = ps; p < 4; p++) {
				if (num > Integer.MAX_VALUE / prime[p] + 1) {
					break;
				}
				queue.add(new MultipicationSmallPrime(num * prime[p], p));
			}
		}
		
		int T = Integer.parseInt(in.readLine().trim());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine());
			System.out.println(list.get(N - 1));
		}
	}
	
	static class MultipicationSmallPrime implements Comparable<MultipicationSmallPrime> {
		int num;
		int ps;
		public MultipicationSmallPrime(int num, int ps) {
			super();
			this.num = num;
			this.ps = ps;
		}
		@Override
		public String toString() {
			return "MulipleSmallPrime [num=" + num + ", ps=" + ps + "]";
		}
		@Override
		public int compareTo(MultipicationSmallPrime o) {
			return num - o.num;
		}
	}
}
