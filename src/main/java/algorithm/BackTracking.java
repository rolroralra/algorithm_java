package algorithm;

public class BackTracking {

	public static int N = 1000;
	public static void main(String[] args) {
		boolean[] isVisited = new boolean[N];
		int[] arr = new int[N];
		
		int start = 0;
		
		isVisited[start] = true;
		backTracking(start, isVisited, 1);
	}

	public static void backTracking(int currIndex, boolean[] isVisited, int cnt) {
		/////
		//	....
		// currIndex 방문해서 currIndex에서 처리할 것들 로직 넣기!!!!!!
		//	....
		//	....
		/////
		
		// 이제 다음 단계로 넘어가기 위해.... nextIndex 반복문돌려서 탐색!
		for (int nextIndex = 0; nextIndex < N; nextIndex++) {
			
			// 1. 방문한 적 없고  2. currIndex로부터 nextIndex로 넘어갈 수 있는 조건이면! nextIndex로 다음단계 고고!
			if (!isVisited[nextIndex] && isConnected(currIndex, nextIndex)) {
				isVisited[nextIndex] = true;		// ****** 다음단계 넘어가는 backTracking(nextIndex, isVisited) 호출하기 전에 반드시!!!
				backTracking(nextIndex, isVisited, cnt + 1);
				isVisited[nextIndex] = false;		// 모두 수행하고 나서... 다시 isVisited 원복!
			}
		}
		
		
		
	}
	
	
	public static boolean isConnected(int currIndex, int nextIndex) {
		// currIndex에서 nextIndex로 단계를 넘어가도 되는지 여부 return!
		return false;
	}

}
