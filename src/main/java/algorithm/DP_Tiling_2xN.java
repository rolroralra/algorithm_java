package algorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DP_Tiling_2xN {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine().trim());
		int a = 1;
		int b = 3;
		
		if (N == 1) {
			System.out.println(1);
			return;
		}
		else if (N == 2) {
			System.out.println(3);
			return;
		}
		
		N -= 2;
		while (N > 0) {
			int temp = b;
			b = b + a * 2;
			a = temp;
			
			if (b >= 20100529) {
				b %= 20100529;
			}
			if (a >= 20100529) {
				a %= 20100529;
			}
			N--;
		}
		
		System.out.println(b % 20100529);
	}
}
