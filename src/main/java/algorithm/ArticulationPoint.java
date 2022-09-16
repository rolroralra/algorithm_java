package algorithm;

import java.util.List;

public class ArticulationPoint {

    static int[] visited;
    static int visitedCount;
    static boolean[] isCutVertex;

    static List<Integer>[] graph;
    public static void main(String[] args) {
        dfs(0, true);
    }

    static int dfs(int currNode, boolean isRoot){
        visited[currNode]= ++visitedCount;

        int returnValue = visited[currNode];

        int spanningTreeChildCount=0;
        //정점 A가 루트 노드 일 경우를 대비해서 DFS스패닝 트리에서의 자식 수 세어준다.
        for(int i = 0 ; i< (int)graph[currNode].size() ; i++){
            int next = graph[currNode].get(i);

            if(visited[next] == 0){
                spanningTreeChildCount++;

                //low : 정점 A의 자식 노드가 갈 수 있는 노드중 가장 일찍 방문한 노드
                int low = dfs(next, false);
                if(!isRoot && low >= visited[currNode]) {
                    isCutVertex[currNode] = true;
                }

                returnValue = Math.min(returnValue, low);
            }
            else {
                returnValue = Math.min(returnValue, visited[next]);
            }
        }

        if(isRoot) {
            isCutVertex[currNode] = (spanningTreeChildCount >= 2);
        }

        return returnValue;
    }

}
