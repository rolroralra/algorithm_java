package koitp.day2;
import java.io.*;
import java.util.*;
public class Prob4_OYH {
	static int n, count, max, answer;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		numbers = new int[n];
		for(int i=0; i<n; i++) 
			numbers[i] = Integer.parseInt(br.readLine().trim());
		
		Arrays.sort(numbers);
		
		count = 1;
		for(int i=1; i<n; i++) {
			if(numbers[i] == numbers[i-1]) {
				count++;
			} else {
				if(count > max) {
					max = count;
					answer = numbers[i-1];
				}
				count = 1;
			}
		}
		if(count > max) answer = numbers[n-1];
		System.out.println(answer);
		br.close();
	}
}