package koitp.day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob6 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int n = N / 2;
		int[] downCnt = new int[H + 1];
		int[] upCnt = new int[H + 1];
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(in.readLine().trim());
			switch (i % 2) {
			case 0:
				downCnt[input]++;
				break;
			case 1:
				upCnt[input]++;
				break;
			}
		}
		
		for (int h = H - 1; h > 0; h--) {
			downCnt[h] += downCnt[h + 1];
			upCnt[h] += upCnt[h + 1];
		}
		
		int[] cntArr = new int[H];
		
		for (int h = 0; h < H; h++) {
			cntArr[h] = downCnt[h + 1] + upCnt[H - h];
		}
		
		Arrays.sort(cntArr);
		int cnt = 1;
		int result = cntArr[0];
		for (int i = 1; i < H; i++) {
			if (cntArr[i] != result) {
				break;
			}
			cnt++;
		}
		System.out.println(result + " " + cnt);
	}
}
