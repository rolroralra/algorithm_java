package jungol;

import java.util.HashMap;
import java.util.Scanner;

public class Main2518__HashMap {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n, length;
		
		n = in.nextInt();
		
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		
		for (int i = 0; i < n; i++) {
			map.put(in.next().toCharArray()[0], in.next().toCharArray()[0]);
		}
		
		n = in.nextInt();
		
		for (int i = 0; i < n; i++) {
			char c = in.next().charAt(0);
//			System.out.print((map.get(c) == null) ? c : map.get(c));
		}
	}
}
