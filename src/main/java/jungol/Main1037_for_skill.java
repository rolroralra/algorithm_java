package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main1037_for_skill {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(in.readLine());
			int[][] a = new int[n][n];
			int[] rowSum = new int[n];
			int[] colSum = new int[n];
			HashSet<Integer> rowSet = new HashSet<Integer>();
			HashSet<Integer> colSet = new HashSet<Integer>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < n; j++) {
					a[i][j] = Integer.parseInt(st.nextToken());
					rowSum[i] += a[i][j];
					colSum[i] += a[j][i];
				}
				if (rowSum[i] % 2 != 0) {
					rowSet.add(i);
				}
				if (colSum[i] % 2 != 0) {
					colSet.add(i);
				}
			}
			
			int rSize = rowSet.size();
			int cSize = colSet.size();
			if (rSize + cSize == 0) {
				System.out.println("OK");
			}
			else if (rSize == 1 && cSize == 1) {
				System.out.print("Change bit (");
				for (int i : rowSet) {
					System.out.print(i + 1 + ",");
				}
				for (int i : colSet) {
					System.out.println(i + 1 + ")");
				}
			}
			else {
				System.out.println("Corrupt");
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}