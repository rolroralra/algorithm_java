package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1169_Recursive {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		//Arrays.fill(arr, 1);
		
		switch(m) {
		case 1:
			printAllCaseOfDice(arr, 0, 1);
			break;
		case 2:
			printAllNotDuplicatedCaseOfDice(arr, 0, 1);
			break;
		case 3:
			printAllDifferentCaseOfDice(arr, 0, 1);
			break;
		}
	}
	
	public static void printAllCaseOfDice(int[] arr, int index, int value) {
		if (index == arr.length) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			arr[index] = i;
			printAllCaseOfDice(arr, index + 1, i);
		}
	}
	
	public static void printAllNotDuplicatedCaseOfDice(int[] arr, int index, int startNum) {
		if (index == arr.length) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = startNum; i <= 6; i++) {
			arr[index] = i;
			printAllNotDuplicatedCaseOfDice(arr, index + 1, i);
		}
	}
	
	public static void printAllDifferentCaseOfDice(int[] arr, int index, int startNum) {
		if (index == arr.length) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			boolean flag = false;
			for (int j = 0 ; j < index; j++) {
				if (arr[j] == i) {
					flag = true;
				}
			}
			if (flag) {
				continue;
			}
			arr[index] = i;
			printAllDifferentCaseOfDice(arr, index + 1, i);
		}
	}
}