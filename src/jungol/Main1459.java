package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;


public class Main1459 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 1; i <= n; i++) {
			map.put(i, Integer.parseInt(in.readLine()));
		}
		TreeSet<Integer> domain = new TreeSet<Integer>();
		TreeSet<Integer> range = new TreeSet<Integer>(map.values());
		do {
			domain.clear();
			domain.addAll(range);
			range.clear();
			for (int i : domain) {
				range.add(map.get(i));
			}
		} while(!domain.equals(range));
		System.out.println(range.size());
		for (int i : range) {
			System.out.println(i);
		}
	}
}