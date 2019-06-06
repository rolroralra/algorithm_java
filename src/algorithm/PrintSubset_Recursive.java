package algorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class PrintSubset_Recursive {
	private static int[] arr;
	private static boolean[] subArr;
	private static int cnt = 0;
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] a = new int[]{1, 2, 3, 4};
		printAllSubSet(a);
		
	}
	public static void printAllSubSet(int[] a) {
		arr = a;
		subArr = new boolean[arr.length];
		setSubsetElement2(arr.length - 1);
		System.out.println(cnt);
	}
	
	public static void setSubsetElement(int index) {
		cnt++;
		if (index == -1) {
			print();
			return;
		}
		subArr[index] = true;
		setSubsetElement(index - 1);
		subArr[index] = false;
		setSubsetElement(index - 1);
	}
	public static void setSubsetElement2(int index) {
		cnt++;
		if (index == -1) {
			print();
			return;
		}
		
		for (int i = index; i >= 0; i--) {
			subArr[i] = true;
			setSubsetElement2(i - 1);
			subArr[i] = false;
		}
		
		print();
//		int n = arr.length;
//		System.out.print("** ");
//		for (int i = 0; i < n; i++) {
//			if (subArr[i]) {
//				System.out.print(arr[i] + ", ");
//			}
//		}
//		System.out.println();
	}
	public static void print() {
		int n = arr.length;
		StringJoiner sj = new StringJoiner(", ", "{", "}");
		sj.setEmptyValue("EMPTY SET");
		for(int i = 0; i < n; i++) {
			if (subArr[i]) {
				sj.add(String.valueOf(arr[i]));
			}
		}
		System.out.println(sj);
	}
}
