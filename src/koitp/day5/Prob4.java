package koitp.day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Prob4 {
	public static char[] arr;
	public static int N;
	public static int[] cnt;
	public static LinkedList<Node> list;
	public static final int CHARACTER_MAX_COUNT = 'Z' - 'A' + 1;
	public static int result = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		arr = in.readLine().trim().toCharArray();
		N = arr.length;
		list = new LinkedList<Node>();
		cnt = new int[CHARACTER_MAX_COUNT];
		result = 0;
		
		for (int i = 0; i < N; i++) {
			cnt[arr[i] - 'A']++;
		}
		for (int i = 0; i < CHARACTER_MAX_COUNT; i++) {
			if (cnt[i] == 0) {
				continue;
			}
			list.add(new Node((char)('A' + i), cnt[i], null, null));
		}
		
		Collections.sort(list);
		
		while (list.size() > 1) {
			Node leftChild = list.removeFirst();
			Node rightChild = list.removeFirst();
			Node parent = new Node(leftChild, rightChild);
			
			int index = Collections.binarySearch(list, parent);
			if (index < 0) {
				index = -(index + 1);
			}
			list.add(index, parent);
		}
		
		Node root = list.get(0);
		dfs(root, 0);
		System.out.println(result);
	}
	
	public static void dfs(Node node, int length) {
		if (node.rightChild == null && node.leftChild == null) {
			result += length * node.cnt;
			return;
		}
		
		dfs(node.leftChild, length + 1);
		dfs(node.rightChild, length + 1);
	}
	
	static class Node implements Comparable<Node> {
		char c;
		int cnt;
		Node leftChild;
		Node rightChild;
		
		public Node(char c, int cnt, Node leftChild, Node rightChild) {
			super();
			this.c = c;
			this.cnt = cnt;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
		
		public Node(Node leftChild, Node rightChild) {
			super();
			this.c = 'a';
			this.cnt = leftChild.cnt + rightChild.cnt;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
		@Override
		public String toString() {
			return "Node [c=" + c + ", cnt=" + cnt + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
		}
		@Override
		public int compareTo(Node o) {
			return cnt - o.cnt;
		}
	}
}
