package algorithm;

import java.util.*;

public class Dijkstra_Algorithm {

    public static void main(String[] args) {


        int N = 10;         // number of vertices
        int[][] adjMatrix = new int[N][N];

        int startIndex = 0;
        int endIndex = N - 1;

        int[] distance = new int[N];
        int[] prevIndex = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(prevIndex, -1);

        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        distance[startIndex] = 0;
        queue.add(new Vertex(startIndex, 0));
        while (!queue.isEmpty()) {
            Vertex currVertex = queue.poll();
            int currIndex = currVertex.index;
            int currDistance = currVertex.distance;

            if (currIndex == endIndex) {
                break;
            }

            for (int nextIndex = 0; nextIndex < N; nextIndex++) {
                if (adjMatrix[currIndex][nextIndex] <= 0) {
                    continue;
                }

                // relaxation procedure
                int newDistance = distance[currIndex] + adjMatrix[currIndex][nextIndex];
                if (newDistance < distance[nextIndex]) {
                    distance[nextIndex] = newDistance;
                    queue.add(new Vertex(nextIndex, distance[nextIndex]));

                    prevIndex[nextIndex] = currIndex;
                }
            }

            Stack<Integer> stack = new Stack<>();
            int index = endIndex;
            while (index != -1) {
                stack.push(index);
                index = prevIndex[index];
            }

            List<Integer> pathIndexList = new ArrayList<>();
            while (!stack.isEmpty()) {
                pathIndexList.add(stack.pop());
            }

        }
    }

    static class Vertex {
        int index;
        int distance;

        public Vertex(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
