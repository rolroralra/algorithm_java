package algorithm;

import java.util.List;

public class ArticulationEdge {

    static int[] visited;
    static int visitedCount;
    static List<Integer>[] graph;
    static boolean[] isCutVertex;
    static List<Edge> cutEdgeList;

    static class Edge {
        int from;
        int to;
        int length;

        public Edge(int from, int to, int length) {
            this.from = from;
            this.to = to;
            this.length = length;
        }
    }

    public static void main(String[] args) {
        dfs(1, 0);

    }

    static int dfs(int node, int parent){
        visited[node]= ++visitedCount;

        int returnValue = visited[node];

        for(int i = 0 ; i< (int)graph[node].size() ; i++){
            int next = graph[node].get(i);

            if (next == parent) {
                continue;
            }

            if(visited[next] == 0){
                //low : 정점 A의 자식 노드가 갈 수 있는 노드중 가장 일찍 방문한 노드
                int low = dfs(next, node);
                if(low >= visited[node]) {
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

}
