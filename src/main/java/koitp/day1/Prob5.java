package koitp.day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prob5 {
	public static final int MAX = (int) 1e5;
	public static boolean[] isPrime;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		isPrime = new boolean[MAX];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i * i < MAX; i++) {
			if (isPrime[i]) {
				for (int j = i; j * i < MAX; j++) {
					isPrime[j * i] = false;
				}
			}
		}
		
		int T = Integer.parseInt(in.readLine().trim());
		
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			Queue<Integer> queue = new LinkedList<Integer>();
			int[] result = new int[9000];
			Arrays.fill(result, -1);
			result[start - 1000] = 0;
			queue.add(start);
			while (!queue.isEmpty()) {
				int currNum = queue.poll();
				
				if (currNum == end) {
					break;
				}
				
				for(int i = 0, pow = 1; i < 4; i++, pow *= 10) {
					int num = (currNum / pow) % 10;
					int tempNum = currNum - num * pow;
					
					int sNum = (i == 3) ? 1 : 0;
					for (int k = sNum; k < 10; k++) {
						if (k == num) {
							continue;
						}
						
						int nextNum = tempNum + k * pow;
						if (nextNum < 10000 && isPrime[nextNum] && result[nextNum - 1000] == -1) {
							result[nextNum - 1000] = result[currNum - 1000] + 1;
							queue.add(nextNum);
						}
					}
				}
			}
			
			if (result[end - 1000] != -1) {
				System.out.println(result[end - 1000]);
			}
			else {
				System.out.println("Impossible");
			}
		}
	}
}
