package koitp.day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob3 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		Part[] arr = new Part[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			int fun = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[i] = new Part(start, length, fun, cost);
		}
		
		long[][] cache = new long[L + 1][B + 1];
		for (int i = 0; i <= L; i++) {
			Arrays.fill(cache[i], -1);
		}
		cache[0][0] = 0;
		
		for (int i = 1; i <= L; i++) {	
			for (int k = 0; k < N; k++) {
				if (i != arr[k].start + arr[k].length) {
					continue;
				}
				
			}
		}
		
	}
	
	static class Part {
		int start;
		int length;
		int fun;
		int cost;
		public Part(int start, int length, int fun, int cost) {
			super();
			this.start = start;
			this.length = length;
			this.fun = fun;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Part [start=" + start + ", length=" + length + ", fun=" + fun + ", cost=" + cost + "]";
		}
//		@Override
//		public int compareTo(Part o) {
//			return start == o.start ? length - o.length : start - o.start;
//		}
	}
}
