package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main1021_TreeMap_Recursive {
	static TreeMap<Integer, TreeMap<Integer, Integer>> map = new TreeMap<>(new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	});
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		
		StringTokenizer st = null;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int middleComponent = Integer.parseInt(st.nextToken());
			int smallComponent = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (map.containsKey(middleComponent)) {
				if (map.get(middleComponent).containsKey(smallComponent)) {
					map.get(middleComponent).put(smallComponent
							, map.get(middleComponent).get(smallComponent) + num);
				}
				else {
					map.get(middleComponent).put(smallComponent, num);
				}
			}
			else {
				map.put(middleComponent, new TreeMap<Integer, Integer>());
				map.get(middleComponent).put(smallComponent, num);
			}
		}
		TreeMap<Integer, Integer> resultMap = new TreeMap<Integer, Integer>();
		count(map.get(n), resultMap, 1);
		
		for (int i : resultMap.keySet()) {
			System.out.println(i + " " + resultMap.get(i));
		}
	}
	
	public static void count(TreeMap<Integer, Integer> inputMap, TreeMap<Integer, Integer> resultMap, int num) {
		for (int i : inputMap.keySet()) {
			if (map.containsKey(i)) {
				count(map.get(i), resultMap, num * inputMap.get(i));
			}
			else {
				add(resultMap, i, num * inputMap.get(i));
			}
		}
	}
	
	public static void add(TreeMap<Integer, Integer> resultMap, int key, int value) {
		if (resultMap.containsKey(key)) {
			resultMap.put(key, resultMap.get(key) + value);
		}
		else {
			resultMap.put(key, value);
		}
	}
}