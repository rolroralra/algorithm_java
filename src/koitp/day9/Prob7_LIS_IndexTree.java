package koitp.day9;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Prob7_LIS_IndexTree {

	public static int N;
	public static int[][] arr;
	public static int[] tree;
	public static int n;
	public static int size;
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		
		arr = new int[N][2];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = i;
		}
		
		for (size = 1; size < N; size <<= 1);
		n = size;
		size = (size << 1) - 1;
		tree = new int[size];
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
			}
		});
		
		for (int i = 0; i < N; i++) {
			int index = arr[i][1];
			update(index, max(0, index - 1) + 1);
		}
		
		System.out.println(max(0, N - 1));
	}
	
	public static void update(int index, int value) {
		index += n;
		tree[index] = value;
		index = (index - 1) >> 1;
		while (index != 0) {
			int leftChild = (index << 1) + 1;
			int rightChild = leftChild + 1;
			int maxIndex = index;
			if (tree[maxIndex] < tree[leftChild]) {
				maxIndex = leftChild;
			}
			if (tree[maxIndex] < tree[rightChild]) {
				maxIndex = rightChild;
			}
			
			if (maxIndex == index) {
				break;
			}
			else {
				tree[index] = tree[maxIndex];
				index = (index - 1) >> 1;
			}
		}
	}
	
	public static int max(int left, int right) {
		left += n;
		right += n;
		
		int max = 0;
		while (left < right) {
			if (left % 2 == 0) {
				max = Math.max(max, tree[left]);
				left++;
			}
			
			if (right % 2 == 1) {
				max = Math.max(max, tree[right]);
				right--;
			}
			
			left = (left - 1) >> 1;
			right = (right - 1) >> 1;
		}
		
		if (left == right) {
			max = Math.max(max, tree[left]);
		}
		return max;
	}
}
