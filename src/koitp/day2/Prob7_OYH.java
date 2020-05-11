package koitp.day2;
import java.io.*;
import java.util.*;
public class Prob7_OYH {
	static int k, n, idx;
	static int[][] lotus, after;
	static boolean[] visited;
	static String command;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		after = new int[n][4];
		lotus = new int[n][5];
		command = in.readLine();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine().trim());
			lotus[i][0] = Integer.parseInt(st.nextToken());
			lotus[i][1] = Integer.parseInt(st.nextToken());
			lotus[i][2] = lotus[i][0] - lotus[i][1];
			lotus[i][3] = lotus[i][0] + lotus[i][1];
			lotus[i][4] = i;	// index
			for(int j=0; j<4; j++)
				after[i][j] = -1;
		}
		
		int x = lotus[0][0];
		int y = lotus[0][1];
		set();
		
		for(int i=0; i<n; i++) {	// find index
			if(lotus[i][3] < x + y) continue;
			if(lotus[i][0] == x) {
				idx = lotus[i][4];
				break;
			}
		}
		
		visited[idx] = true;
		for(int i=0; i<k; i++) {
			int dir = command.charAt(i) - 65;	// ABCD = 0123
			if(move(idx, dir) != -1) {
				idx = move(idx, dir);
				visited[idx] = true;
			}
		}
		
		for(int i=0; i<n; i++)	// find position
			if(lotus[i][4] == idx) {
				x = lotus[i][0];
				y = lotus[i][1];
				break;
			}
				
		System.out.printf("%d %d", x, y);
		in.close();
	}
	
	static int move(int pos, int dir) {
		if(after[pos][dir] != -1 && visited[after[pos][dir]])
			after[pos][dir] = move(after[pos][dir], dir);
		return after[pos][dir];
	}
	
	static void set() {
		Arrays.sort(lotus, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[2] == o2[2]) return o1[0] - o2[0];
				return o1[2] - o2[2];
			}
		});
		
		for(int i=0; i<n-1; i++) {
			if(lotus[i][2] == lotus[i+1][2]) {
				after[lotus[i][4]][0] = lotus[i+1][4];
				after[lotus[i+1][4]][3] = lotus[i][4];
			}
		}
		
		Arrays.sort(lotus, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[3] == o2[3]) return o1[0] - o2[0];
				return o1[3] - o2[3];
			}
		});

		for(int i=0; i<n-1; i++) {
			if(lotus[i][3] == lotus[i+1][3]) {
				after[lotus[i][4]][1] = lotus[i+1][4];
				after[lotus[i+1][4]][2] = lotus[i][4];
			}
		}
	}
}
