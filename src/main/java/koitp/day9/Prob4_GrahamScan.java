package koitp.day9;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Prob4_GrahamScan {

	public static int N;
	public static int[][] arr;
	public static void main(String[] args) throws Exception {
		
		StringTokenizer st = null;
//		System.setIn(new FileInputStream("src/sample_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine().trim());
		arr = new int[N][2];
		
		int pivot = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
			if (arr[pivot][0] > arr[i][0]) {
				pivot = i;
			}
			else if (arr[pivot][0] == arr[i][0] && arr[pivot][1] > arr[i][1]) {
				pivot = i;
			}
		}
		swap(pivot, 0);
		for (int i = 1; i < N; i++) {
			arr[i][0] -= arr[0][0];
			arr[i][1] -= arr[0][1];
		}
		arr[0][0] = 0;
		arr[0][1] = 0;
		
//		Arrays.sort(arr, 1, N, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return (int) ((long) o1[0] * o2[1] - (long) o1[1] * o2[0]);
//			}
//		});
		quickSort(1, N - 1);
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		int prevVertex = 1;
		int currVertex = 3;
		while (currVertex < N) {
			if (outerProduct(stack.peek(), prevVertex, currVertex) > 0) {
				prevVertex = stack.peek();
				stack.push(currVertex);
				currVertex++;
			}
			else {
				stack.pop();
				int temp = stack.pop();
				prevVertex = stack.peek();
				stack.push(temp);
			}
		}
		System.out.println(stack.size());
	}
	
	public static long outerProduct(int i, int j, int k) {
		int x1 = arr[j][0] - arr[i][0];
		int y1 = arr[j][1] - arr[i][1];
		int x2 = arr[k][0] - arr[j][0];
		int y2 = arr[k][1] - arr[j][1];
		
		return (long) x1 * y2 - (long) x2 * y1;
	}
	
	public static void quickSort(int s, int e) {
		if (s >= e) {
			return;
		}
		
		int pivot = s;
		int index = s;
		for (int i = s + 1; i <= e; i++) {
			if (outerProduct(pivot, i) < 0) {
				swap(++index, i);
			}
		}
		
		swap(index, pivot);
		quickSort(s, index - 1);
		quickSort(index + 1, e);
	}
	
	public static int outerProduct(int i, int j) {
		int ret =  (int) ((long) arr[i][0] * arr[j][1] - (long) arr[i][1] * arr[j][0]);
		return ret == 0 ? (length(i) > length(j) ? 1 : -1) : ret;
	}
	
	public static long length(int i) {
		return (long) arr[i][0] * arr[i][0] + (long) arr[i][1] * arr[i][1];
	}
	
	public static void swap(int i, int j) {
		if (i == j) {
			return;
		}
		
		int[] temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
