package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1175_Recursive {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int numOfDice = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(st.nextToken());
		in.close();
		int[] arr = new int[numOfDice];
		printAll(arr, 0, sum);
		
	}
	
	public static void printAll(int[] arr, int index, int remainSum) {
		if (index == arr.length) {
			if (remainSum == 0) {
				for (int i : arr) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			return;
		}
		if (remainSum > 6 * (arr.length - index)) {
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			arr[index] = i;
			printAll(arr, index + 1, remainSum - i);
		}
	}
	
}