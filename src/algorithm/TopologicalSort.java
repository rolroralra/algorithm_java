package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TopologicalSort {
    static int N, M;
    static List<List<Integer>> adjList;
    static boolean[] isVisited;
    static boolean[] isFinished;
    static int[] inDegree;
    static Stack<Integer> stack;
    static boolean isCycled;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<List<Integer>>(N);
        isVisited = new boolean[N];
        isFinished = new boolean[N];
        inDegree = new int[N];
        stack = new Stack<Integer>();

        IntStream.range(0, N).forEach(i -> {
            adjList.add(new ArrayList<Integer>());
        });

        IntStream.range(0, M).forEach(i -> {
            try {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st2.nextToken()) - 1;
                int end = Integer.parseInt(st2.nextToken()) - 1;

                adjList.get(start).add(end);

                inDegree[end]++;
            } catch (IOException e) {
            }
        });

        /*****************
         * Solution Code *
         *****************/
        SolutionType solutioneType = SolutionType.QUEUE;

        switch(solutioneType) {
            case DFS:
                IntStream.range(0, N).forEach(i -> {
                    if (!isVisited[i]) {
                        topologicalSortByDFS(i, isVisited, isFinished, adjList, stack);
                    }
                });

                while (!stack.isEmpty()) {
                    sb.append(stack.pop() + 1).append(" ");
                }
                break;
            case QUEUE:
                topologicalSortByQueue(adjList, inDegree).forEach(i -> {
                    sb.append(i + 1).append(" ");
                });

                break;
        }

        System.out.println(sb.toString().trim());
    }

    public static void topologicalSortByDFS(int currIndex, boolean[] isVisited, boolean[] isFinished,
                                            List<List<Integer>> adjList, Stack<Integer> stack) {
        isVisited[currIndex] = true;

        adjList.get(currIndex).stream().forEach(nextIndex -> {
            if (!isVisited[nextIndex]) {
                topologicalSortByDFS(nextIndex, isVisited, isFinished, adjList, stack);
            }
            else if (isFinished[nextIndex]) {
                isCycled = true;
                return;
            }
        });

        // Core Logic for Topological Sort by DFS Spanning Tree
        stack.push(currIndex);

        isFinished[currIndex] = true;
    }

    public static List<Integer> topologicalSortByQueue(List<List<Integer>> adjList, int[] inDegree) {
        List<Integer> sortedList = new ArrayList<>();

        // Initial Setting by start node having 0 inDegree
        Queue<Integer> queue = new LinkedList<Integer>();
        IntStream.range(0, N).forEach(i -> {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        });

        // BFS by Queue
        IntStream.range(0, N).forEach(i -> {
            if (queue.isEmpty()) {
                isCycled = true;
                return;
            }

            int currIndex = queue.poll();
            sortedList.add(currIndex);

            adjList.get(currIndex).forEach(nextIndex -> {
                if (--inDegree[nextIndex] == 0) {
                    queue.add(nextIndex);
                }
            });
        });

        return sortedList;
    }

    static enum SolutionType {
        DFS, QUEUE
    }
}

