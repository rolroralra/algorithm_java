package koitp.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prob3 {
	public static int N;
	public static int M;
	public static int T;
	public static HashMap<Integer, HashMap<Integer, Integer>> map;
	public static int[] distance;
	public static final int MAX_DISTANCE = 3000 * 1000;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		T = Integer.parseInt(in.readLine().trim()) - 1;
		
		map = new HashMap<Integer, HashMap<Integer, Integer>>();
		for (int i = 0; i < N; i++) {
			map.put(i, new HashMap<Integer, Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int length = Integer.parseInt(st.nextToken());
			
			HashMap<Integer, Integer> temp = map.get(s);
			
			if (temp.containsKey(e)) {
				temp.put(e, Math.min(length, temp.get(e)));
			}
			else {
				temp.put(e, length);
			}
		}
		
		distance = new int[N];
		Arrays.fill(distance, MAX_DISTANCE);
		distance[0] = 0;
		PriorityQueue<State> queue = new PriorityQueue<State>();
		queue.add(new State(0, 0));
		while (!queue.isEmpty()) {
			State currState = queue.poll();
			int currIndex = currState.index;
			int currDistacne = currState.distance;
			
			if (currIndex == T) {
				break;
			}
			
			HashMap<Integer, Integer> temp = map.get(currIndex);
			for (int nextIndex : temp.keySet()) {
				int newDistance = currDistacne + temp.get(nextIndex);
				if (distance[nextIndex] > newDistance) {
					distance[nextIndex] = newDistance;
					queue.add(new State(nextIndex, newDistance));
				}
			}
		}
		
		int result = distance[T];
		if (result == MAX_DISTANCE) {
			System.out.println("NO");
			return;
		}
		
		Arrays.fill(distance, MAX_DISTANCE);
		distance[T] = 0;
		queue.clear();
		queue.add(new State(T, 0));
		while (!queue.isEmpty()) {
			State currState = queue.poll();
			int currIndex = currState.index;
			int currDistacne = currState.distance;
			
			if (currIndex == 0) {
				break;
			}
			
			HashMap<Integer, Integer> temp = map.get(currIndex);
			for (int nextIndex : temp.keySet()) {
				int newDistance = currDistacne + temp.get(nextIndex);
				if (distance[nextIndex] > newDistance) {
					distance[nextIndex] = newDistance;
					queue.add(new State(nextIndex, newDistance));
				}
			}
		}
		
		if (distance[0] == MAX_DISTANCE) {
			System.out.println("NO");
			return;
		}
		
		result += distance[0];
		System.out.println("YES");
		System.out.println(result);
	}
	
	static class State implements Comparable<State> {
		int index;
		int distance;
		public State(int index, int distance) {
			super();
			this.index = index;
			this.distance = distance;
		}
		@Override
		public String toString() {
			return "State [index=" + index + ", distance=" + distance + "]";
		}
		@Override
		public int compareTo(State o) {
			return distance - o.distance;
		}
	}
}
