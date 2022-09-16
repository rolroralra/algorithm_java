package koitp.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Prob8_Graph {
    public static int M;
    public static int N;
    public static int[][] arr;
    public static int groupSize;
    public static ArrayList<HashSet<Integer>> list;
    public static int[] Dx = new int[]{1, -1, 0 , 0};
    public static int[] Dy = new int[]{0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
         
        arr = new int[M][N];
        for (int i = 0 ; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                switch (input) {
                case 0:
                    input = -1;
                    break;
                case 1:
                    input = -2;
                    break;
                }
                arr[i][j] = input;
            }
        }
         
        groupSize = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == -1 || arr[i][j] == -2) {
                    int color = arr[i][j];
                    arr[i][j] = groupSize;
                    dfs(i, j, color, groupSize++);
                }
            }
        }
         
        list = new ArrayList<HashSet<Integer>>(groupSize);
        for (int i = 0; i < groupSize; i++) {
            list.add(new HashSet<Integer>());
        }
         
        boolean[] isChecked = new boolean[groupSize];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!isChecked[arr[i][j]]) {
                    isChecked[arr[i][j]] = true;
                    boolean[][] isVisited = new boolean[M][N];
                    dfs(i, j, arr[i][j], isVisited);
                }
            }
        }
         
        int result = Integer.MAX_VALUE;
        int[] depth = null;
        Queue<Integer> queue = null;
        for (int i = 0; i < groupSize; i++) {
            queue = new LinkedList<Integer>();
            depth = new int[groupSize];
            Arrays.fill(depth, -1);
            depth[i] = 0;
            queue.add(i);
            while (!queue.isEmpty()) {
                int currVertex = queue.poll();
                for (int nextVertex : list.get(currVertex)) {
                    if (depth[nextVertex] == -1) {
                        depth[nextVertex] = depth[currVertex] + 1;
                        queue.add(nextVertex);
                    }
                }
            }
             
            Arrays.sort(depth);
//          System.out.println(depth[groupSize - 1]);
            result = Math.min(result, depth[groupSize - 1]);
        }
        System.out.println(result);
    }
     
    public static void dfs(int row, int col, int groupIndex, boolean[][] isVisited) {
        if (arr[row][col] != groupIndex) {
            HashSet<Integer> set = list.get(groupIndex);
            if (!set.contains(arr[row][col])) {
                set.add(arr[row][col]);
            }
            return;
        }
         
        isVisited[row][col] = true;
         
        for (int i = 0; i < 4; i++) {
            int nextRow = row + Dx[i];
            int nextCol = col + Dy[i];
             
            if (isInside(nextRow, nextCol) && !isVisited[nextRow][nextCol]) {
                dfs(nextRow, nextCol, groupIndex, isVisited);
            }
        }
    }
     
    public static void dfs(int row, int col, int color, int groupIndex) {
        for (int i = 0; i < 4; i++) {
            int nextRow = row + Dx[i];
            int nextCol = col + Dy[i];
             
            if (isInside(nextRow, nextCol) && arr[nextRow][nextCol] == color) {
                arr[nextRow][nextCol] = groupIndex;
                dfs(nextRow, nextCol, color, groupIndex);
            }
        }
    }
     
    public static boolean isInside(int row, int col) {
        return row >= 0 && row < M && col >= 0 && col < N;
    }
     
    public static void printArr() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}