package jungol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;


public class Main1697 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		
		int n = in.nextInt();
		if (n > 10000 || n < 1) {
			System.exit(1);
		}
		
		for (int i = 0; i < n; i++) {
			String cmd = in.next();
			switch (cmd.charAt(0)) {
			case 'i':
				q.add(in.nextInt());
				break;
			case 'o':
				try {
					System.out.println(q.remove());
				} catch (NoSuchElementException e) {
					System.out.println("empty");
				}
				break;
			case 'c':
				System.out.println(q.size());
				break;
			}
		}
		in.close();
	}
}
