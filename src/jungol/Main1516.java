package jungol;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Main1516 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<TreeMap<String, Integer>> db = new ArrayList<TreeMap<String,Integer>>();
		
		String s;
		while (!(s = in.nextLine()).trim().equals("END")) {
			String[] sa = s.split(" ");
			
			TreeMap<String, Integer> map = new TreeMap<String, Integer>();
			int n = sa.length;
			for (int i = 0; i < n; i++) {
				if (map.get(sa[i]) == null) {
					map.put(sa[i], 1);
				}
				else {
					map.put(sa[i], map.get(sa[i]) + 1);
				}
			}
			db.add(map);
		}
		in.close();
		
		for (TreeMap<String, Integer> map : db) {
			for (String key : map.keySet()) {
				result.add(key + " : " + map.get(key).toString());
			}
		}
		
		for (String i : result) {
			System.out.println(i);
		}
	}
}
