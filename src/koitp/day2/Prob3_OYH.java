package koitp.day2;
import java.io.*;
import java.util.*;
public class Prob3_OYH {
	static int m, n, state, answer;
	static int[] count, map;
	static int[][] cache;
	static String input;
	static boolean[][] check;
	static HashMap<Integer, HashSet<Integer>> friend = new HashMap<Integer, HashSet<Integer>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		count = new int[1024];
		check = new boolean[1024][1024];
		for(int i=0; i<1024; i++) {
			friend.put(i, new HashSet<Integer>());
			for(int j=0; j<1024; j++) {
				if(((i<<1) & j) == 0 && ((j<<1) & i) == 0) {
					check[i][j] = true;
					friend.get(i).add(j);
				}
			}
		}
		for(int i=0; i<1024; i++) {
			int tmp = i;
			while(tmp > 0) {
				if(tmp%2 == 1) count[i]++;
				tmp /= 2;
			}
		}
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			map = new int[m];
			state = (int)Math.pow(2, n);
			cache = new int[m][state];
			for(int i=0; i<m; i++) {
				input = br.readLine();
				int tmp = 0;
				int two = 1;
				for(int j=n-1; j>-1; j--) {
					if(input.charAt(j) == 'x')
						tmp += two;
					two *= 2;
				}
				map[i] = tmp;
			}
			
			for(int i=0; i<state; i++)
				if((i & map[0]) == 0)
					cache[0][i] = count[i];
			
			for(int i=1; i<m; i++) {
				for(int j=0; j<state; j++) {
					if((j & map[i]) == 0) {
						for(int k : friend.get(j)) {
							if(k >= state) continue;
							cache[i][j] = Math.max(cache[i][j], cache[i-1][k] + count[j]);
						}
					}
				}
			}
			
			answer = 0;
			for(int i=0; i<state; i++)
				answer = Math.max(answer, cache[m-1][i]);
			
			System.out.println(answer);
		}
		br.close();
	}
}