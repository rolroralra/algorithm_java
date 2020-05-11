package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1761_ClassOfArrayList {
	static class QDao {
		private ArrayList<Query> qList = new ArrayList<Query>();
		private int qNum;
		public void add(Query query) {
			qList.add(query);
			qNum++;
			
		}
		public Query get(int index) {
			return qList.get(index);
		}
		public int size() {
			return qNum;
		}
	}
	
	static class Query {
		private int[] query;
		private int strike;
		private int ball;
		
		public Query(String query, int strike, int ball) {
			String[] sa = query.split("");
			this.query = new int[]{Integer.parseInt(sa[0]), Integer.parseInt(sa[1]), Integer.parseInt(sa[2])};
			this.strike = strike;
			this.ball = ball;
		}
		public boolean checkStrike(int[] answer) {
			int strikeCount = 0;
			for (int i = 0; i < 3; i++) {
				if (query[i] == answer[i]) {
					strikeCount++;
				}
			}
			if (strikeCount == strike) { return true; }
			else { return false; }
		}
		public boolean checkBall(int[] answer) {
			int ballCount = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (answer[i] == query[j] && i != j) {
						ballCount++;
					}
				}
			}
			if (ballCount == ball) { return true; }
			else { return false; }
		}
		/*public int[] getQuery() {
			return query;
		}
		public void setQuery(int[] query) {
			this.query = query;
		}
		public int getStrike() {
			return strike;
		}
		public void setStrike(int strike) {
			this.strike = strike;
		}
		public int getBall() {
			return ball;
		}
		public void setBall(int ball) {
			this.ball = ball;
		}*/
		/*@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ball;
			result = prime * result + strike;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Query other = (Query) obj;
			if (ball != other.ball)
				return false;
			if (strike != other.strike)
				return false;
			int n = query.length;
			if (n != other.query.length) {
				return false;
			}
			for (int i = 0; i < n; i++) {
				if (query[i] != other.query[i]) {
					return false;
				}
			}
			return true;
		}*/
		/*@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < 3; i++) {
				builder.append(getQuery()[i]);
				//builder.append(query[i]);
			}
			builder.append(" ");
			builder.append(strike);
			builder.append(" ");
			builder.append(ball);
			return builder.toString();
		}*/
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(in.readLine().trim());
		ArrayList<Query> list = new ArrayList<Query>();
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			list.add(new Query(st.nextToken()
					, Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())));
		}
		int[] answer = new int[3];
		int countAnswer = 0;
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j == i) {
					continue;
				}
				for (int k = 1; k <= 9; k++) {
					if (k == j || k == i) {
						continue;
					}
					answer[0] = i; answer[1] = j; answer[2] = k;
					boolean isRightAnswer = true;
					for (Query q : list) {
						if (!q.checkStrike(answer) || !q.checkBall(answer)) {
							isRightAnswer = false;
							break;
						}
					}
					if (isRightAnswer) {
						countAnswer++;
					}
				}
			}
		}
		System.out.println(countAnswer);
	}
}