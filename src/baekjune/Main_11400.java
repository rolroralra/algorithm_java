package baekjune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class Main_11400 {

    static int V, E;
    static int[] visited;
    static int visitedCount;
    static List<Integer>[] graph;
    static List<Edge> cutEdgeList;

    public static void main(String[] args) throws IOException {
        System.setIn(Main_11400.class.getResourceAsStream("sample_input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        AtomicReference<StringTokenizer> st = new AtomicReference<>(new StringTokenizer(in.readLine()));
        V = Integer.parseInt(st.get().nextToken().trim());
        E = Integer.parseInt(st.get().nextToken().trim());
        cutEdgeList = new ArrayList<>();
        visited = new int[V];

        graph = new ArrayList[V];
        IntStream.range(0, V).forEach(i -> graph[i] = new ArrayList<Integer>());

        IntStream.range(0, E).forEach(i -> {
            try {
                st.set(new StringTokenizer(in.readLine()));
                int v1 = Integer.parseInt(st.get().nextToken().trim()) - 1;
                int v2 = Integer.parseInt(st.get().nextToken().trim()) - 1;

                graph[v1].add(v2);
                graph[v2].add(v1);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        dfs(0, -1);

        cutEdgeList.sort((edge1, edge2) -> {
            return edge1.from == edge2.from ? edge1.to - edge2.to : edge1.from - edge2.from;
        });

        System.out.println(cutEdgeList.size());
//        Arrays.stream(visited).forEach(i -> System.out.println(i));
        cutEdgeList.forEach(edge -> {
            System.out.println(edge);
        });
    }

    static int dfs(int node, int parent){
        visited[node]= ++visitedCount;

        int returnValue = visited[node];

        for(int i = 0 ; i < graph[node].size() ; i++){
            int next = graph[node].get(i);

            if (next == parent) {
                continue;
            }

            if(visited[next] == 0){
                //low : 정점 A의 자식 노드가 갈 수 있는 노드중 가장 일찍 방문한 노드
                int low = dfs(next, node);
                if(low > visited[node]) {
                    cutEdgeList.add(new Edge(Math.min(node, next), Math.max(node, next), 0));
                }

                returnValue = Math.min(returnValue, low);
            }
            else {
                returnValue = Math.min(returnValue, visited[next]);
            }
        }

        return returnValue;
    }

    static class Edge {
        int from;
        int to;
        int length;

        public Edge(int from, int to, int length) {
            this.from = from;
            this.to = to;
            this.length = length;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(from + 1).append(" ").append(to + 1);
            return sb.toString();
        }
    }
}
