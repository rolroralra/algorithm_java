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

    // parent -> node   edge
    // 자신 노드 주변 가장 빠른 방문 순서
    static int dfs(int currIndex, int prevIndex){
        visited[currIndex]= ++visitedCount;

        int returnValue = visited[currIndex];

        for(int i = 0 ; i< (int)graph[currIndex].size() ; i++){
            int nextIndex = graph[currIndex].get(i);

            if (nextIndex == prevIndex) {
                continue;
            }

            if(visited[nextIndex] == 0){
                //low : 정점 A의 자식 노드가 갈 수 있는 노드중 가장 일찍 방문한 노드
                int low = dfs(nextIndex, currIndex);
                if(low > visited[currIndex]) {
                    cutEdgeList.add(new Edge(Math.min(currIndex, nextIndex), Math.max(currIndex, nextIndex), 0));
                }

                returnValue = Math.min(returnValue, low);
            }
            else {
                returnValue = Math.min(returnValue, visited[nextIndex]);
            }
        }

        return returnValue;
    }

}
