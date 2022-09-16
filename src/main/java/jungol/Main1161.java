package jungol;

import java.util.Scanner;

public class Main1161 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.close();
		
		if (n > 15 || n < 1) {
			System.exit(1);
		}
		
		hanoi(n, 1, 3);
	}
	// n개 탑을 from에서 to로 이동하는 과정을 출력!
	public static void hanoi(int n, int fromPosition, int toPosition) {
		if (n == 1) {
			System.out.println(n + " : " + fromPosition + " -> " + toPosition);
			return;
		}
		
		int tempPosition = 6 - (fromPosition + toPosition);
		
		hanoi(n - 1, fromPosition, tempPosition);	// n개중 위의 n - 1개를 from에서 temp로
		System.out.println(n + " : " + fromPosition + " -> " + toPosition);	//
		hanoi(n - 1, tempPosition, toPosition);
	}
	
}
