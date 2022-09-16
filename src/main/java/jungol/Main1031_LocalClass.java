package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1031_LocalClass {

	public static void main(String[] args) throws IOException {
		// checkBoard : 나만의 5 x 5 빙고판 (해당 위치 숫자를 지운다 -> 해당 위치의 boolean value
		// true!)

		class MyBoolean {
			public boolean value;
			public MyBoolean(boolean value) {
				this.value = value;
			}
		}
		class Board {
			private MyBoolean[][] values;
			public Board(int size) {
				values = new MyBoolean[size][size];
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						values[i][j] = new MyBoolean(false);
					}
				}
			}
			public MyBoolean get(int x, int y) {
				return values[x][y];
			}
			public boolean isBingo() {
				int countBingo = 0;

				for (int i = 0; i < 5; i++) {
					int rowCount = 0;
					int colCount = 0;
					int diagonalCount = 0;
					for (int j = 0; j < 5; j++) {
						if (i == 0) {
							if (values[j][j].value) {
								diagonalCount++;
							}
						} else if (i == 1) {
							if (values[j][4 - j].value) {
								diagonalCount++;
							}
						}
						if (values[i][j].value) {
							rowCount++;
						}
						if (values[j][i].value) {
							colCount++;
						}
						if (diagonalCount == 5) {
							countBingo++;
						}
					}
					if (rowCount == 5) {
						countBingo++;
					}
					if (colCount == 5) {
						countBingo++;
					}
					if (countBingo >= 3) {
						return true;
					}
				}
				return false;
			}
		}
		Board checkBoard = new Board(5);

		// 빙고판에 내가 생각한 숫자를 적는 과정! Map을 통해 숫자와 나의 빙고판 해당위치객체(MyBoolean)를 Mapping
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, MyBoolean> map = new HashMap<Integer, MyBoolean>();
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				int inputNumber = Integer.parseInt(st.nextToken());
				map.put(inputNumber, checkBoard.get(i, j));
			}
		}

		// 사회자가 부르는 번호들 배열에 저장
		int[] outputNubmer = new int[25];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 5; j++) {
				outputNubmer[i * 5 + j] = Integer.parseInt(st.nextToken());
			}
		}

		// 사회자가 불러준 번호들을 가지고 내가 작성한 빙고판에 번호 삭제 & 빙고인지 아닌지 체크!
		// Mapping을 이용해서 사회자가 불러준 번호에 해당하는 빙고판 해당 위치 객체의 value멤버 true로 변경
		// isBingo method를 이용해 빙고인지 아닌지 체크!
		int result = 0;
		for (int i = 0; i < 25; i++) {
			map.get(outputNubmer[i]).value = true;
			if (checkBoard.isBingo()) {
				result = i + 1;
				break;
			}
		}
		System.out.println(result);
	}
}
