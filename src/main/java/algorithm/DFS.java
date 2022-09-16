package algorithm;

import java.util.Scanner;
import java.util.Stack;

public class DFS {
	public static int N;
	public static int[][] adjMatrix;
	public static Node[] nodes;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		nodes = new Node[N];
		adjMatrix = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			int inputValue = sc.nextInt();			// 입력 값!
			nodes[i] = new Node(inputValue);	
		}
		
		Stack<State> stack = new Stack<State>();
		boolean[] isVisited = new boolean[N];
		int startIndex = 0;
		int endIndex = N - 1;

		stack.push(new State(startIndex, nodes[startIndex].value));

		while (!stack.isEmpty()) {
			State currState = stack.pop();
			
			int currIndex = currState.currIndex;
			int currInfo = currState.currInfo;
			
			for (int nextIndex = 0; nextIndex < N; nextIndex++) {
				if (!isVisited[nextIndex]) {
					isVisited[nextIndex] = true;	
					stack.push(new State(nextIndex, currInfo + nodes[currIndex].value));
				}
			}
		}
		
		
	}
	
	static class State {
		int currIndex;	// Node의 index
		int currInfo;	// 그 Node에서의 currInfo
		// .....
		public State(int currIndex, int currInfo) {
			super();
			this.currIndex = currIndex;
			this.currInfo = currInfo;
		}
	}
	
	static class Node {
		int value;
		// ....
		public Node(int value) {
			super();
			this.value = value;
		}
	}
	
	
	
}
