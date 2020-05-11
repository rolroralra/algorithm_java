package koitp.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prob6_Heap {
	public static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine().trim());
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});

		new PriorityQueue<>(((o1, o2) -> {return 0;}));
		
		// Max Heap (�߾Ӱ� ���� �۰ų� ����) n + 1��
		// Min Heap (�߾Ӱ� ���� ū)	n��
		
	}
}
