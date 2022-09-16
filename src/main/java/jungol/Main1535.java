package jungol;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1535 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> listWord = new ArrayList<String>();
		
		String inputString;
		while (!(inputString = in.nextLine()).equals("END")) {
			String[] sa = inputString.split(" ");
			int n = sa.length;
			for (int i = 0; i < n; i++) {
				if (!listWord.contains(sa[i])) {
				//if (listWord.indexOf(sa[i]) == -1) {
					listWord.add(sa[i]);
				}
			}
			
			n = listWord.size();
			for (int i = 0; i < n; i++) {
				System.out.print(listWord.get(i) + " ");
			}
			System.out.println();
		}
		
		in.close();
	}
}
