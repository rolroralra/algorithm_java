package algorithm.bellmanford;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord_Algorithm {
    public static void main(String[] args) {
        List<Edge> edgeList = new ArrayList<>();

        int N = 10;         // Number of Vertices
        int startIndex = 0;

        int[] distance = new int[N];
        Arrays.fill(distance, Edge.MAX_LENGTH_OF_EDGE);
        distance[startIndex] = 0;


        // N - 1 steps
        for (int step = 1; step < N; step++) {
            for (Edge edge : edgeList) {
                int src = edge.src;
                int dest = edge.dest;
                int length = edge.length;

                if (distance[src] == Edge.MAX_LENGTH_OF_EDGE) {
                    continue;
                }

                int newPathLength = distance[src] + edge.length;
                if (distance[dest] > newPathLength) {
                    distance[dest] = newPathLength;
                }
            }
        }

        // One more step for checking existence of negative cycle
        for (Edge edge : edgeList) {
            int src = edge.src;
            int dest = edge.dest;
            int length = edge.length;

            if (distance[src] == Edge.MAX_LENGTH_OF_EDGE) {
                continue;
            }

            int newPathLength = distance[src] + edge.length;
            if (distance[dest] > newPathLength) {
                //
                // There exists cycle having negative length.
                //
            }
        }


    }


    static class Edge {
        int src;
        int dest;
        int length;

        static final int MAX_LENGTH_OF_EDGE = Integer.MAX_VALUE;

        public Edge(int src, int dest, int length) {
            this.src = src;
            this.dest = dest;
            this.length = length;
        }
    }
}
