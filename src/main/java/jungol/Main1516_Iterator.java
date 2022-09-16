package jungol;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main1516_Iterator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		ArrayList<String> result = new ArrayList<String>();
		
		String s;
		while (!(s = in.nextLine()).trim().equals("END")) {
			String[] sa = s.split(" ");
			//Arrays.sort(sa);
			
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
			
			Iterator<String> iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				result.add(key + " : " + map.get(key).toString());
			}
			//map.clear();
		}
		in.close();
		
		int n = result.size();
		for (int i = 0; i < n; i++) {
			System.out.println(result.get(i));
		}
	}
}
