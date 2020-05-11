package koitp.day1;
import java.io.*;
import java.util.*;
public class Prob6_OYH {
	static int h, n, count, height;
	static int[] down, up, bump;
	static int[] downCache, upCache;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken())/2;
		h = Integer.parseInt(st.nextToken());
		down = new int[h+1];
		up = new int[h+1];
		bump = new int[h];
		for(int i=0; i<2*n; i++) {
			height = Integer.parseInt(br.readLine().trim());
			if(i % 2 == 0) down[height]++;
			else up[height]++;
		}
		
		downCache = new int[h+1];
		upCache = new int[h+1];
		downCache[h] = down[h];
		upCache[h] = up[h];
		for(int i=h-1; i>-1; i--) {
			downCache[i] = down[i] + downCache[i+1];
			upCache[i] = up[i] + upCache[i+1];
		}
		
		for(int i=0; i<h; i++)
			bump[i] = downCache[i+1] + upCache[h-i];
		
		Arrays.sort(bump);
		for(int i=0; i<h; i++) {
			if(bump[i] != bump[0])
				break;
			count++;
		}
		
		System.out.printf("%d %d", bump[0], count);
		br.close();
	}
}