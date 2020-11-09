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

    static int dfs(int curr, int prev){
        visited[curr]= ++visitedCount;

        int returnValue = visited[curr];

        for(int i = 0 ; i< (int)graph[curr].size() ; i++){
            int next = graph[curr].get(i);

            if (next == prev) {
                continue;
            }

            if(visited[next] == 0){
                //low : 정점 A의 자식 노드가 갈 수 있는 노드중 가장 일찍 방문한 노드
                int low = dfs(next, curr);
                if(low > visited[curr]) {
                    cutEdgeList.add(new Edge(Math.min(curr, next), Math.max(curr, next), 0));
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
