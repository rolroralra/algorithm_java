package algorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class PrintSubset_Recursive_X_ {
	private static int[] arr;
	private static boolean[] subArr;
	private static int cnt;
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		cnt = 0;
		int[] a = new int[]{1, 2, 3, 4};
		printAllSubSet(a);
		System.out.println(cnt);
	}
	public static void printAllSubSet(int[] a) {
		arr = a;
		subArr = new boolean[arr.length];
		setSubsetElement(arr.length - 1);
	}
	
	public static void setSubsetElement(int index) {
		if (index == -1) {
			print();
			cnt++;
			return;
		}
		subArr[index] = false;
		setSubsetElement(index - 1);
		subArr[index] = true;
		setSubsetElement(index - 1);
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
