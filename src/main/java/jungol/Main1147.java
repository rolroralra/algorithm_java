package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;


public class Main1147 {
	static class Dice {
		public int[] value;

		public Dice(int[] value) {
			this.value = Arrays.copyOf(value, value.length);
		}
		
		public int getIndexOf(int value) {
			int n = this.value.length;
			for (int i = 0 ; i < n; i++) {
				if (this.value[i] == value) {
					return i;
				}
			}
			return -1;
		}
		
	}
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		

		
		
	}
}