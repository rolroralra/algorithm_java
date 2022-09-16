package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1091 {
	public static void main(String[] args) throws Exception {
		// 분자식에 있는 원소들과 그 원소들이 나오는 횟수 저장하는 HashMap
		HashMap<Character, Integer> atomCountMap = new HashMap<Character, Integer>();
		// 유기물에 들어갈수 있는 원자들 (delimiter로 사용될 예정)
		final String ATOMS = "CHON";
		// C, H, O, N ... 각 원자들의 해당 원자량들을 저장하는 HashMap
		HashMap<Character, Double> atomicWeightMap = new HashMap<Character, Double>();
		atomicWeightMap.put('C', 12.01);
		atomicWeightMap.put('H', 1.008);
		atomicWeightMap.put('O', 16.00);
		atomicWeightMap.put('N', 14.01);
		
		// 사용자가 입력한 분자식(molecularFormula) 저장
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String molecularFormula = in.readLine();
		if (molecularFormula.length() >= 100) { 	// 분자식 길이 100 이상일때 입력 예외상황
			throw new Exception("Too Long Molecular Formula"); 
		}
		
		// 사용자 입력 분자식을 "CHON"을 delimiter로 설정해서 분석!
		StringTokenizer st = new StringTokenizer(molecularFormula, "CHON", true);
		int num = st.countTokens();			// 분석 했을 때 나눠지는 입력요소 총 개수
		String[] parses = new String[num];
		for (int i = 0; i < num; i++) {
			parses[i] = st.nextToken();		// 분석 후 나눠지는 각 입력요소 배열에 저장
		}
		
		for (int i = 0; i < num; i++) {
			if (ATOMS.contains(parses[i])) {	// i번째 입력요소가 C, H, O, N일때 분자식 원소 map에 저장해야됨.
				char atom = parses[i].charAt(0);
				try {	
					if (atomCountMap.containsKey(atom)) {	// 이미 추가된적 있는 원소일때
						atomCountMap.put(atom
								, atomCountMap.get(atom) + Integer.parseInt(parses[i + 1]));
					}
					else {									// 처음 추가되는 원소일때
						atomCountMap.put(atom, Integer.parseInt(parses[i + 1]));
					}
					
					// i + 1 번째 입력요소가 숫자가 아니거나 마지막 입력요소일때
				} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
					if (atomCountMap.containsKey(atom)) {	// 이미 추가된적 있는 원소일때
						atomCountMap.put(atom, atomCountMap.get(atom) + 1);
					}
					else {									// 처음 추가되는 원소일때
						atomCountMap.put(atom, 1);
					}
				}
			}
		}
		
		double molecularWeight = 0;	// 분자량
		for (Character atom : atomCountMap.keySet()) {	// 분자량 합산
			molecularWeight += atomicWeightMap.get(atom) * atomCountMap.get(atom);
		}
		System.out.printf("%.3f\n", molecularWeight);
		
		/*for (Character atom : atomCountMap.keySet()) {
			System.out.println(atom + " " + atomCountMap.get(atom));
		}*/
		/*for (int i = 0; i < num; i++) {
			if (ATOMS.contains(parses[i])) {
				char atom = parses[i].charAt(0);
				try {
					if (ATOMS.contains(parses[i + 1])) {
						if (atomCountMap.containsKey(atom)) {
							atomCountMap.put(atom, atomCountMap.get(atom) + 1);
						}
						else {
							atomCountMap.put(atom, 1);
						}
					}
					else {
						if (atomCountMap.containsKey(atom)) {
							atomCountMap.put(atom
									, atomCountMap.get(atom) + Integer.parseInt(parses[i + 1]));
						}
						else {
							atomCountMap.put(atom, Integer.parseInt(parses[i + 1]));
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					if (atomCountMap.containsKey(atom)) {
						atomCountMap.put(atom, atomCountMap.get(atom) + 1);
					}
					else {
						atomCountMap.put(atom, 1);
					}
				}
			}
		}*/
	}
}
