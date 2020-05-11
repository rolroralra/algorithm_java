package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Main2460 {
	public static class Candidate implements Comparable<Candidate>{
		public int name;
		public int[] num;
		public int score;
		
		public Candidate(int name) {
			this.name = name;
			num = new int[3];
			score = 0;
		}
		
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Candidate [name=");
			builder.append(name);
			builder.append(", num=");
			builder.append(Arrays.toString(num));
			builder.append(", score=");
			builder.append(score);
			builder.append("]");
			return builder.toString();
		}
		
		@Override
		public int compareTo(Candidate o) {
			return o.score - score;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Candidate[] candidates = new Candidate[3];
		for (int i = 0; i < 3; i++) {
			candidates[i] = new Candidate(i + 1);
		}
		
		int numStudent = in.nextInt();
		if (numStudent > 1000 || numStudent < 3) {
			System.exit(1);
		}
		
		for (int i = 0; i < numStudent; i++) {
			for (int j = 0; j < 3; j++) {
				int inputScore = in.nextInt();
				candidates[j].score += inputScore;
				candidates[j].num[inputScore - 1]++;
			}
		}
		Arrays.sort(candidates);
				
		int electedIndex = 0;
		int electedName = candidates[electedIndex].name;
		int electedScore = candidates[electedIndex].score;
		boolean flagEqual = false;
		for (int i = 1; i <= 2; i++) {
			if (electedScore == candidates[i].score) {
				flagEqual = true;
				for (int j = 2; j >= 0; j--) {
					if (candidates[electedIndex].num[j] < candidates[i].num[j]) {
						electedIndex = i;
						electedName = candidates[electedIndex].name;
						electedScore = candidates[electedIndex].score;
						flagEqual = false;
						break;
					} 
					else if (candidates[electedIndex].num[j] > candidates[i].num[j]) {
						flagEqual = false;
						break;
					}
				}
			}
		}
		if (flagEqual) {
			System.out.println("0 " + electedScore);
		}
		else {
			System.out.println(electedName + " " + electedScore);
		}
	}
}