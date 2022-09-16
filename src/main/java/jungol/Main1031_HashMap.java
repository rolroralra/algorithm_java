package jungol;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1031_HashMap {
	static class MyBoolean  {
		public boolean value;
		MyBoolean() {
			value = false;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Map<Integer, MyBoolean> map = new HashMap<Integer, MyBoolean>();
		MyBoolean[][] bingo = new MyBoolean[5][5];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = new MyBoolean();
				map.put(in.nextInt(), bingo[i][j]);
			}
		}
		
		int count = 0;
		do {
			map.get(in.nextInt()).value = true;
			count++;
		} while(!isBingo(bingo));
		
		System.out.println(count);
		in.close();
	}
	
	public static boolean isBingo(MyBoolean[][] bingo) {
		int countBingo = 0;
		for (int i = 0; i < 5; i++) {
			int cntRow = 0;
			int cntCol = 0;
			int cntDia = 0;
			for (int j = 0; j < 5; j++) {
				if (bingo[i][j].value) {
					cntRow++;
				}
				if (bingo[j][i].value) {
					cntCol++;
				}
				if (i == 0) {
					if (bingo[j][j].value) {
						cntDia++;
					}
				}
				else if (i == 1) {
					if (bingo[j][4 - j].value) {
						cntDia++;
					}
				}
			}
			
			if (cntRow == 5) {
				countBingo++;
			}
			if (cntCol == 5) {
				countBingo++;
			}
			if (cntDia == 5) {
				countBingo++;
			}
			
			if (countBingo >= 3) {
				return true;
			}
		}
		return false;
	}
}
