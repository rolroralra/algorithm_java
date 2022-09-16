package jungol;

import java.util.Scanner;

public class Main1311 {
	static class Card {
		public int num;
		public char color;
		Card() {
		}
		Card(char color, int num) {
			this.num = num;
			this.color = color;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Card[] cards = new Card[5];
		int[] numColor = new int[4];
		int[] numNumber = new int[9];
		
		for(int i = 0; i < 5; i++) {
			char c = in.next().charAt(0);
			int n = in.nextInt();
			cards[i] = new Card(c, n);
			switch(c) {
			case 'R':
				numColor[0]++;
				break;
			case 'B':
				numColor[1]++;
				break;
			case 'Y':
				numColor[2]++;
				break;
			case 'G':
				numColor[3]++;
				break;
			}
			numNumber[n - 1]++;
		}
		in.close();
		
		int flush = checkFlush(numColor, numNumber);
		int straight = checkStraight(numNumber);
		int fourcard = checkFourCard(numNumber);
		int triple = checkTriple(numNumber, 1);
		int pair = checkPair(numNumber, 1);
		
		if (flush != -1 && straight != -1) {
			System.out.println(900 + straight);
			return;
		}
		if (fourcard != -1) {
			System.out.println(800 + fourcard);
			return;
		}
		if (triple != -1 && pair != -1) {
			System.out.println(700 + triple * 10 + pair);
			return;
		}
		if (flush != -1 && straight == -1) {
			System.out.println(600 + flush);
			return;
		}
		if (flush == -1 && straight != -1) {
			System.out.println(500 + straight);
			return;
		}
		if (triple != -1 && pair == -1) {
			System.out.println(400 + triple);
			return;
		}
		if (triple == -1 && pair != -1) {
			int twoPair = checkPair(numNumber, pair + 1);
			if (twoPair != -1) {
				System.out.println(300 + twoPair * 10 + pair);
			}
			else {
				System.out.println(200 + pair);
			}
			return;
		}
		for (int i = 8; i >= 0; i--) {
			if (numNumber[i] != 0) {
				System.out.println(100 + i + 1);
				return;
			}
 		}
		//System.out.println(checkFourCard(numNumber));
		//System.out.println(checkFlush(numColor, numNumber));
		/*System.out.println(Arrays.toString(numNumber));
		System.out.println(checkPair(numNumber, 1) + " Pair");
		System.out.println(checkTriple(numNumber, 1) + " Triple");
		System.out.println(checkFullHouse(numNumber) + " Full House");*/
		/*System.out.println("R :" + numColor[0]);
		System.out.println("B :" + numColor[1]);
		System.out.println("Y :" + numColor[2]);
		System.out.println("G :" + numColor[3]);
		System.out.println(Arrays.toString(numNumber));*/
		
	}
	
	public static int checkFullHouse(int[] numNumber) {
		try {
			int result_1 = checkPair(numNumber, checkTriple(numNumber, 1));
			if (result_1 == -1) {
				return checkTriple(numNumber, checkPair(numNumber, 1));
			}
			else {
				return result_1;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return -1;
		}
	}
	
	public static int checkFourCard(int[] numNumber) {
		for (int i = 0 ; i < 9; i++) {
			if (numNumber[i] == 4) {
				return i + 1;
			}
		}
		return -1;
	}
	
	public static int checkTriple(int[] numNumber, int startNum) {
		for (int i = startNum - 1; i < 9; i++) {
			if (numNumber[i] == 3) {
				return i + 1;
			}
		}
		return -1;
	}
	
	public static int checkPair(int[] numNumber, int startNum) {
		for (int i = startNum - 1; i < 9; i++) {
			if (numNumber[i] == 2) {
				return i + 1;
			}
		}
		return -1;
	}
	
	public static int checkStraight(int[] numNumber) {
		int count = 0;
		for (int i = 0; i < 9; i++) {
			if (numNumber[i] != 0) {
				count++;
			}
			else {
				count = 0;
			}
			if (count == 5) {
				return i + 1;
			}
		}
		return -1;
	}
	
	public static int checkFlush(int[] numColor, int[] numNumber) {
		for (int i = 0; i < 4; i++) {
			if (numColor[i] == 5) {
				for (int j = 8; j >=0; j--) {
					if (numNumber[j] != 0) {
						return j + 1;
					}
				}
			}
		}
		return -1;
	}
}
