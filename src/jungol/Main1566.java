package jungol;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Main1566 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		String inputString = in.next();
		in.close();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int n = inputString.length();
		for (int i = 0; i < n; i++) {
			if (map.get(inputString.charAt(i)) == null) {	// map에 업으면 추가
				map.put(inputString.charAt(i), 1);
			}
			else {		// map에 있으면 value++
				map.put(inputString.charAt(i), map.get(inputString.charAt(i)) + 1);
			}
		}
		
		boolean flag = false;
		for (Character i : map.keySet()) {
			if (isPrime(map.get(i))) {
				System.out.print(i);
				// flag가 true
				if (!flag) {
					flag = true;
				}
			}
		}
		
		if (!flag) {
			System.out.print("NONE");
		}
	}
	
	public static boolean isPrime(int n) {
		if (n == 1) {
			return false;
		}
		
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
