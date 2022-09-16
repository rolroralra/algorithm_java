package koitp.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prob7 {
	public static int K;
	public static int N;
	public static int[] prime;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(in.readLine().trim());
		N = Integer.parseInt(in.readLine().trim());
		
		prime = new int[K];
		for (int i = 0; i < K; i++) {
			prime[i] = Integer.parseInt(in.readLine().trim());
		}
		
		ArrayList<Long> list = new ArrayList<>(N);
		
		PriorityQueue<MultipicationSmallPrime> queue = new PriorityQueue<MultipicationSmallPrime>();
		queue.add(new MultipicationSmallPrime(1, 0));
		while (list.size() <= N) {
			MultipicationSmallPrime curr = queue.poll();
			long num = curr.num;
			int ps = curr.ps;
			list.add(num);
			
			for (int p = ps; p < K; p++) {
				if (num * prime[p] > (long) Integer.MAX_VALUE) {
					break;
				}
				queue.add(new MultipicationSmallPrime(num * prime[p], p));
			}
		}
		
		System.out.println(list.get(N));
	}
	
	static class MultipicationSmallPrime implements Comparable<MultipicationSmallPrime> {
		long num;
		int ps;
		public MultipicationSmallPrime(long num, int ps) {
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
			long temp = num - o.num;
			if (temp > (long) Integer.MAX_VALUE) {
				return 1;
			}
			if (temp < (long) Integer.MIN_VALUE) {
				return -1;
			}
			return (int) temp;
		}
	}
}
