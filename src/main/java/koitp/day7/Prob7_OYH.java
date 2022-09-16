package koitp.day7;
import java.io.*;
import java.util.*;
public class Prob7_OYH {
	static int n, mid, min;
	static int[][] point;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine().trim());
		point = new int[n][2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		System.out.println(findMin(point));
		in.close();
	}
	
	static int findMin(int[][] arr) {
		if(arr.length == 2) {
			min = min(min, dist(arr[0][0], arr[0][1], arr[1][0], arr[1][1]));
		} else if(arr.length == 3) {
			min = min(min, dist(arr[0][0], arr[0][1], arr[1][0], arr[1][1]));
			min = min(min, dist(arr[1][0], arr[1][1], arr[2][0], arr[2][1]));
			min = min(min, dist(arr[2][0], arr[2][1], arr[0][0], arr[0][1]));
		} else {
			Arrays.sort(arr, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			int left_size = (arr.length+1)/2;
			int right_size = arr.length/2;
			int[][] left = new int[left_size][2];
			int[][] right = new int[right_size][2];
			
			for(int i=0; i<left_size; i++)
				for(int j=0; j<2; j++)
					left[i][j] = arr[i][j];
			
			for(int i=0; i<right_size; i++)
				for(int j=0; j<2; j++)
					right[i][j] = arr[i+left_size][j];
			
			Arrays.sort(right, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}
			});
			
			int[] yRight = new int[right_size];
			for(int i=0; i<right_size; i++)
				yRight[i] = right[i][1];
			
			min = min(min, min(findMin(left), findMin(right)));
			mid = left[left_size-1][0];
			
			for(int i=0; i<left_size; i++) {
				if(left[i][0] < mid - min) continue;
				int yLeft = left[i][1];
				int idx = Arrays.binarySearch(yRight, yLeft - min);
				if(idx < 0) idx = -idx-1;
				for(int j=idx; j<idx+6; j++) {
					if(j > right_size - 1) break;
					min = min(min, dist(left[i][0], left[i][1], right[j][0], right[j][1]));
				}
			}
		}
		return min;
	}
	
	static int dist(int x1, int y1, int x2, int y2) {
		return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
	}
	
	static int min(int x, int y) {
		return x < y ? x : y;
	}
}
