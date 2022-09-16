package jungol;/*
 10 이하의 자연수 N을 입력받아 주사위를 N번 던져서 나올 수 있는 모든 경우를 출력하되 중복되는 경우에는 앞에서부터 작은 순으로 1개만 출력하는 프로그램을 작성하시오.

 3

 1 1 1
 1 1 2
 ...
 1 1 6
 1 2 2
 1 2 3
 ...
 5 6 6
 6 6 6

 */

import java.util.Arrays;
import java.util.Scanner;

public class Main590_Recursive {
	static int N;
	static int m;
	static int[] arr = new int[10];
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		call(1, 1);
	}

	static void call(int depth, int startNum) {
		if (depth > N) {
			prt(arr);
			return;	
		}

		for (int i = startNum; i < 7; i++) {
			arr[depth - 1] = i;
			call(depth + 1, i);
		}
	}
	
	static void prt(int arr[]) {
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
