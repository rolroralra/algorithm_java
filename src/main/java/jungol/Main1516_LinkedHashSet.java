package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main1516_LinkedHashSet {
	public static void main(String[] args) throws IOException {
		//각 문장의 단어장을 저장하는 LinkedHashSet (입력한 문장 순서대로 뽑아야 되니깐..) 
		LinkedHashSet<TreeMap<String, Integer>> resultSet = new LinkedHashSet<TreeMap<String,Integer>>();
		
		// 입력 받은 한 문장씩.. 단어 하나 하나 분석 -> 단어장 TreeMap에 단어 저장 (사전순으로 출력해야 되니깐)
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String word = st.nextToken();
			if (word.equalsIgnoreCase("END")) {
				break;
			}
			TreeMap<String, Integer> map = new TreeMap<String, Integer>();
			map.put(word, 1);
			while(st.hasMoreTokens()) {
				word = st.nextToken();
				if (map.containsKey(word)) {
					map.put(word, map.get(word) + 1);
				}
				else {
					map.put(word, 1);
				}
			}
			resultSet.add(map);
		}
		in.close();
		
		// 단어장 모음집 LinkedHashSet에서 단어장 (TreeMap) 하나씩 꺼내서 단어와 그 단어 나온 횟수 출력
		for (TreeMap<String, Integer> map : resultSet) {
			for (String s : map.keySet()) {
				System.out.println(s + " : " + map.get(s));
			}
		}
	}
}
