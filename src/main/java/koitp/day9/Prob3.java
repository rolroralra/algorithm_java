package koitp.day9;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob3 {
	public static int[][] rect;
	public static int[][] p;
	public static int[][] vertex;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());
		
		p = new int[2][2];
		rect = new int[2][2];
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			rect[0][0] = Integer.parseInt(st.nextToken());
			rect[0][1] = Integer.parseInt(st.nextToken());
			rect[1][0] = Integer.parseInt(st.nextToken());
			rect[1][1] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			p[0][0] = Integer.parseInt(st.nextToken());
			p[0][1] = Integer.parseInt(st.nextToken());
			p[1][0] = Integer.parseInt(st.nextToken());
			p[1][1] = Integer.parseInt(st.nextToken());
			
			if (p[0][0] > p[1][0]) {
				p[0][0] ^= p[1][0];
				p[1][0] ^= p[0][0];
				p[0][0] ^= p[1][0];
			}
			
			if (p[0][1] > p[1][1]) {
				p[0][1] ^= p[1][1];
				p[1][1] ^= p[0][1];
				p[0][1] ^= p[1][1];
			}
			
			vertex = new int[4][2];
			vertex[0][0] = rect[0][0];
			vertex[0][1] = rect[0][1];
			vertex[1][0] = rect[1][0];
			vertex[1][1] = rect[0][1];
			vertex[2][0] = rect[1][0];
			vertex[2][1] = rect[1][1];
			vertex[3][0] = rect[0][0];
			vertex[3][1] = rect[1][1];
			
			if (p[0][1] == p[1][1]) {
				if (p[0][1] < rect[0][1] || rect[1][1] < p[0][1]) {
					System.out.println("0");
					continue;
				}
				else if (p[0][1] == rect[0][1] || p[0][1] == rect[1][1]) {

				}
				
				if (p[1][0] < rect[0][0] || rect[1][0] < p[0][0]) {
					System.out.println("0");
				}
				else if (p[1][0] == rect[0][0] || p[0][0] == rect[1][0]) {
					System.out.println("1");
				}
				else {
					System.out.println("4");
				}
			}
			
			int prevVertex = 3;
			int cnt = 0;
			
			for (int currVertex = 0; currVertex < 4; currVertex++) {
				switch (currVertex % 2) {
				case 0:	// x��ǥ ����
					if (vertex[currVertex][0] < p[0][0] || vertex[currVertex][0] > p[1][0]) {
						break;
					}
					
					double y = (double) (p[0][1] - p[1][1]) / (p[0][0] - p[1][0]) * (vertex[currVertex][0] - p[0][0]) + p[0][1];
					if ((vertex[currVertex][1] < y && y <= vertex[prevVertex][1]) 
							|| (vertex[prevVertex][1] < y && y <= vertex[currVertex][1])) {
						cnt++;
					}
					break;
				case 1:	// y��ǥ ����
					if (vertex[currVertex][1] < p[0][1] || vertex[currVertex][1] > p[1][1]) {
						break;
					}
					
					double x = (double) (p[0][0] - p[1][0]) / (p[0][1] - p[1][1]) * (vertex[currVertex][1] - p[0][1]) + p[0][0];
					if ((vertex[currVertex][0] < x && x <= vertex[prevVertex][0]) 
							|| (vertex[prevVertex][0] < x && x <= vertex[currVertex][0])) {
						cnt++;
					}
					break;
				}
				prevVertex = currVertex;
			}
			
			System.out.println(cnt);
		}
	}
}
