package koitp.day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Prob2 {
	public static int N;
	public static int[][] arr;
	public static final int MAX_VALUE = 100000;
	public static final int COUNT = 10000000;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		in.readLine();
		Random r = new Random(System.currentTimeMillis());
		int cnt = 0;
		for (int i = 0; i < COUNT; i++) {
			double x = (double) r.nextInt(MAX_VALUE + 1) / MAX_VALUE;
			double y = (double) r.nextInt(MAX_VALUE + 1) / MAX_VALUE;
			
			if (x * x + y * y <= 1) {
				cnt++;
			}
		}
		
		double result = (double) cnt / COUNT * 4;
		System.out.printf("%.2f\n", result);
	}
}
