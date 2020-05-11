package jungol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main1339__ {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		File f = new File("Main1339_Result.txt");
		PrintWriter pw = null;
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		try {
			FileOutputStream fos = new FileOutputStream(f);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			pw = new PrintWriter(bw);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		int n;

		while ((n = in.nextInt()) > 100 || n <= 0 || n % 2 == 0) {
			System.out.println("INPUT ERROR");
		}

		for (int i = 1; i <= n; i++) {
			int startIndex = (0 + (int) Math.pow((n - 1) / 2, 2) + i - 1) % (int) ('Z' - 'A' + 1);
			System.out.print(getChar(startIndex) + " ");
			pw.print(getChar(startIndex) + " ");
			//pw.flush();
			int num = (n + 1) / 2 - Math.abs((n + 1) / 2 - i);
			for (int j = 1; j < num; j++) {
				System.out.print(getChar(((startIndex -= n + 1 - 2 * j) % (int) ('Z' - 'A' + 1))) + " ");
				pw.print(getChar(((startIndex) % (int) ('Z' - 'A' + 1))) + " ");
				//pw.flush();
			}
			System.out.println();
			pw.println();
			//pw.flush();
		}
		pw.close();
	}

	/*
	 * public static char getChar(int a) { return (a - 'A' >= 0 ? (char) ((a -
	 * 'A') % ('Z' - 'A' + 1) + 'A') : getChar(a + 'Z' - 'A' + 1)); }
	 */

	public static char getChar(int a) {
		return (a < 0) ? (char) (a + 'Z' - 'A' + 1 + 'A') : (char) (a + 'A');
	}

}
