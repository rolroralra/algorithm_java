package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FloydWarshall_Algorithm {
    static final int UNVALID_INDEX = -1;
    static final int NONE_EDGE = 0;
    public static void main(String[] args) {

        int N = 10;
        int[][] adjMatrix = new int[N][N];


        int[][] distance = new int[N][N];
        int[][] prevIndexOfDest = new int[N][N];


        for (int i = 0; i < N; i++) {
            Arrays.fill(prevIndexOfDest, UNVALID_INDEX);
            Arrays.fill(distance, Integer.MAX_VALUE);

            for (int j = 0; j< N; j++) {
                if (adjMatrix[i][j] == NONE_EDGE) {
                    continue;
                }

                distance[i][j] = adjMatrix[i][j];
                prevIndexOfDest[i][j] = i;
            }

            distance[i][i] = 0;
        }


        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (adjMatrix[i][k] == Integer.MAX_VALUE) {
                    continue;
                }
                for (int j = 0; j < N; j++) {
                    if (adjMatrix[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }


                    // Relaxation Procedure
                    int newDistance = adjMatrix[i][k] + adjMatrix[k][j];
                    if (newDistance < adjMatrix[i][j]) {
                        adjMatrix[i][j] = newDistance;
                        prevIndexOfDest[i][j] = prevIndexOfDest[k][j];
                    }

                }
            }
        }


        int startIndex = 0;
        int endIndex = N - 1;


        // Shortest Path Length by using F-W Algorithm
        System.out.println(distance[startIndex][endIndex]);


        // Shortest Path by using F-W Algorithm
        Stack<Integer> stack = new Stack<>();
        stack.push(endIndex);
        while (prevIndexOfDest[startIndex][stack.peek()] != UNVALID_INDEX) {
            stack.push(prevIndexOfDest[startIndex][stack.peek()]);
        }

        List<Integer> shortestPathIndexList = new ArrayList<>();
        while (!stack.isEmpty()) {
            shortestPathIndexList.add(stack.pop());
        }


    }
}
