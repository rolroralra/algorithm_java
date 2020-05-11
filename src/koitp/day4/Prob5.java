package koitp.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prob5 {
	public static int N;
	public static int M;
	public static int X;
	public static HashMap<Integer, HashMap<Integer, Integer>> map;
	public static int[] result;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()) - 1;
		
		map = new HashMap<Integer, HashMap<Integer, Integer>>();
		result = new int[N];
		for (int i = 0; i < N; i++) {
			map.put(i, new HashMap<Integer, Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int time = Integer.parseInt(st.nextToken());
			
			HashMap<Integer, Integer> temp = map.get(s);
			if (temp.containsKey(e)) {
				temp.put(e, Math.min(time, temp.get(e)));
			}
			else {
				temp.put(e, time);
			}
		}
		
		PriorityQueue<State> queue = new PriorityQueue<State>();
		for (int start = 0; start < N; start++) {
			if (start == X) {
				continue;
			}
			
			queue.clear();
			int[] time = new int[N];
			Arrays.fill(time, Integer.MAX_VALUE);
			time[start] = 0;
			queue.add(new State(start, 0));
			while (!queue.isEmpty()) {
				State currState = queue.poll();
				int currIndex = currState.index;
				int currTime = currState.time;
				
				if (currIndex == X) {
					break;
				}
				
				HashMap<Integer, Integer> temp = map.get(currIndex);
				for (int nextIndex : temp.keySet()) {
					int nextTime = currTime + temp.get(nextIndex);
					if (time[nextIndex] > nextTime) {
						time[nextIndex] = nextTime;
						queue.add(new State(nextIndex, nextTime));
					}
				}
			}
			
			result[start] = time[X];
		}
		
		queue.clear();
		int[] time = new int[N];
		Arrays.fill(time, Integer.MAX_VALUE);
		time[X] = 0;
		queue.add(new State(X, 0));
		while (!queue.isEmpty()) {
			State currState = queue.poll();
			int currIndex = currState.index;
			int currTime = currState.time;
			
			HashMap<Integer, Integer> temp = map.get(currIndex);
			for (int nextIndex : temp.keySet()) {
				int nextTime = currTime + temp.get(nextIndex);
				if (time[nextIndex] > nextTime) {
					time[nextIndex] = nextTime;
					queue.add(new State(nextIndex, nextTime));
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (result[i] == Integer.MAX_VALUE || time[i] == Integer.MAX_VALUE) {
				continue;
			}
			
			result[i] += time[i];
			max = Math.max(result[i], max);
		}
		System.out.println(max);
	}
	
	static class State implements Comparable<State> {
		int index;
		int time;
		public State(int index, int time) {
			super();
			this.index = index;
			this.time = time;
		}
		@Override
		public String toString() {
			return "State [index=" + index + ", time=" + time + "]";
		}
		@Override
		public int compareTo(State o) {
			return time - o.time;
		}
	}
}
