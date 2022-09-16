package koitp.day7;
import java.io.*;
import java.util.*;
public class Prob8_OYH {
	static int n, max, count;
	static int[][] command;
	static boolean update;
	static ArrayList<Integer> idx = new ArrayList<Integer>();
	static HashMap<Integer, ArrayList<Integer>> status = new HashMap<Integer, ArrayList<Integer>>();
	static PriorityQueue<Integer> clear = new PriorityQueue<Integer>();
	static PriorityQueue<Integer> build = new PriorityQueue<Integer>(new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	});
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(in.readLine().trim());
		command = new int[n][3];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken())+1;
			int z = Integer.parseInt(st.nextToken());
			if(!idx.contains(x)) idx.add(x);
			if(!idx.contains(y)) idx.add(y);
			if(!status.containsKey(x)) status.put(x, new ArrayList<Integer>());
			if(!status.containsKey(y)) status.put(y, new ArrayList<Integer>());
			status.get(x).add(z);
			status.get(y).add(-z);
		}
		
		Collections.sort(idx);
		for(int i : idx) {
			update = false;
			if(build.size() == 0) {
				build.add(0);
				update = true;
			}
			
			max = build.peek();
			for(int j : status.get(i)) {
				if(j > 0) build.add(j);
				else clear.add(j);
			}
			while(!clear.isEmpty() && build.peek() == -clear.peek()) {
				build.poll();
				clear.poll();
			}
			if(build.peek() != max) update = true;
			
			if(update) {
				count++;
				sb.append(i+" "+build.peek()+"\n");
			}
		}
		
		System.out.println(count);
		System.out.println(sb);
		in.close();
	}
}
