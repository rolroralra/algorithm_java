package koitp.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Prob4_NotGood {
	public static int N;
	public static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine().trim());
		arr = new int[N];
		HashMap<Integer, Integer> cntMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine().trim());
			
			int temp = 0;
			if (!cntMap.containsKey(arr[i])) {
				temp = 1;
			}
			else {
				temp = cntMap.get(arr[i]) + 1;
			}
			cntMap.put(arr[i], temp);
		}
		
		ArrayList<int[]> list = new ArrayList<>();
		for (int key : cntMap.keySet()) {
			list.add(new int[]{key, cntMap.get(key)});
		}
		
		list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] == o1[1] ? o1[0] - o2[0] : o2[1] - o1[1];
			}
		});
		
		System.out.println(list.get(0)[0]);
	}
}
