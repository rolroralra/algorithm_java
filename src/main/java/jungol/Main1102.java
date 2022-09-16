package jungol;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Main1102 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Stack<Integer> stack = new Stack<Integer>();

		int n = in.nextInt();

		if (n > 10000 || n < 1) {
			System.exit(1);
		}
		
		for (int i = 0; i < n; i++) {
			String cmd = in.next();
			switch(cmd.charAt(0)) {
			case 'i':
				stack.push(in.nextInt());
				break;
			case 'o':
				try {
					System.out.println(stack.pop());
				} catch (EmptyStackException e) {
					System.out.println("empty");
				}
				break;
			case 'c':
				System.out.println(stack.size());
				break;
			}
		}
		in.close();
	}
}
