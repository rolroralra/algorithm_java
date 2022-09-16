package jungol;

import java.util.Scanner;
import java.util.Stack;


public class Main1221_PostfixNotation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		if (n > 11 || n < 3) {
			System.exit(1);
		}
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			int temp;
			char c = in.next().charAt(0);
			switch (c) {
			case '+':
				s.push(s.pop() + s.pop());
				break;
			case '-':
				temp = s.pop();
				s.push(s.pop() - temp);
				break;
			case '*':
				s.push(s.pop() * s.pop());
				break;
			case '/':
				temp = s.pop();
				s.push(s.pop() / temp);
				break;
			default:
				s.push(c - '0');
			}
		}
		in.close();
		System.out.println(s.pop());
	}
}
