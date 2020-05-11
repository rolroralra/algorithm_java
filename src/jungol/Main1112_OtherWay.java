package jungol;

import java.util.Scanner;

public class Main1112_OtherWay {

	public static void main(String[] args) {
		Scanner s =  new Scanner(System.in);
		double ruler = s.nextInt(); // 줄자 길이 받음
		if(ruler < 10 || ruler > 1000) System.exit(1);
		double red1 = s.nextInt();
		double red2 = s.nextInt();
		double blue1 = s.nextInt();
		double blue2 = s.nextInt();
		double yellow1 = s.nextInt();
		double yellow2 = s.nextInt();
		s.close(); // 각 위치 받은 후 종료
		double average = 0;
		
		average = (double)(red1+red2)/2.0; // 평균 계산
		if(red1 == red2){average = 0;} // 만약 서로 두 수가 같으면 평균 0으로 설정
		ruler = Math.max(average, ruler-average);
		blue1 = Math.abs(blue1-average); // 각각 점의 위치를 새로운 기준점(평균점)을 기준으로 재설정
		blue2 = Math.abs(blue2-average);
		yellow1 = Math.abs(yellow1-average);
		yellow2 = Math.abs(yellow2-average);
		// 1번 반복
		average = (double)(blue1+blue2)/2.0;
		if(blue1 == blue2){average = 0;}
		ruler = Math.max(average, ruler-average);
		yellow1 = Math.abs(yellow1-average);
		yellow2 = Math.abs(yellow2-average);
		// 2번 반복
		average = (double)(yellow1+yellow2)/2.0;
		if(yellow1 == yellow2){average = 0;}
		ruler = Math.max(average, ruler-average);
		System.out.printf("%.1f", ruler); // 
	}
}
