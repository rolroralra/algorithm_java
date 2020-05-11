package koitp.day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prob6_BinarySearch {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int n = N / 2;
		int[] down = new int[n];
		int[] up = new int[n];
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(in.readLine().trim());
			int index = i / 2;
			switch (i % 2) {
			case 0:
				down[index] = input;
				break;
			case 1:
				up[index] = input;
				break;
			}
		}
		
		Arrays.sort(down);
		Arrays.sort(up);
		
		int[] cnt = new int[H];
		
		for (int i = 0; i < H; i++) {
			int temp1 = n - lowerBound(down, n, i + 1);
			int temp2 = n - lowerBound(up, n, H - i);
			cnt[i] = temp1 + temp2;
		}
		
		Arrays.sort(cnt);
		
		int count = 1;
		int result = cnt[0];
		for (int i = 1; i < H; i++) {
			if (cnt[i] != result) {
				break;
			}
			count++;
		}
		
		System.out.println(result + " " + count);
	}
	
	public static int lowerBound(int[] arr, int N, int key) {
		int s = 0;
		int e = N - 1;
		int lb = N;
		while (s <= e) {
			int mid = (s + e) >> 1;
			if (arr[mid] < key) {
				s = mid + 1;
			}
			else {
				e = mid - 1;
				lb = mid;
			}
		}
		return lb;
	}
}
