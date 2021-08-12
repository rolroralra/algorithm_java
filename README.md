# jungol
Reference to "http://jungol.co.kr/"
---
## TODO
- [ ] Topology Sort
- [ ] Articulation Point & Edge

---
# 문제 Web Site
- 정올 - "http://jungol.co.kr/"
- 백준 - "https://www.acmicpc.net/"
- "삼성SDS SW검정 프로 교육" -- "https://koitp.org/"
- "삼성 SDS Professional 대비 문제풀이반" https://koitp.org/category/SDS_PRO_201609/
---
## Sample Code for Java
```java
package problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        long START_TIMESTAMP = System.currentTimeMillis();

        System.setIn(Solution.class.getResourceAsStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine().trim());
        for (int test_case = 1; test_case <= T; test_case++) {
            int result = 0;

            /*****************
             * Solution Code *
             *****************/



            System.out.println("#" + test_case + " " + result);
//            sb.append("#" + test_case + " " + result + '\n');
        }


        long END_TIMESTAMP = System.currentTimeMillis();
        MemoryMXBean mxBean = ManagementFactory.getMemoryMXBean();
        System.out.println("Spend Time: " + (END_TIMESTAMP - START_TIMESTAMP) + " ms");
        System.out.println("Usage Heap Memory: " + mxBean.getHeapMemoryUsage().getUsed() / 1024  + " KB");

//        System.out.println(sb.toString());
    }
}

```

---
# Graph

## Graph
> G = (V,E)\
> (G: Graph, V: set of vertices, E: set of edges)

## Graph Implementation
1. Adjacency Matrix
2. Adjacency List
3. Edge List

## Directed 
> directed edge   (v1, v2) != (v2, v1)\
> undirected edge  (v1, v2) = (v2, v1)

## Adjacent
> v1, v2 are adjacent\
> iff there exists an edge e such that e = (v1, v2)

## Incident
> some edge e is incident on v1 and v2\
> iff e = (v1, v2)

## Parallel
> e1, e2 are called parallel\
> iff e1 = (v1, v2), e2 = (v1, v2)

## Loop (Self Loop)
> Loop is an edge incident on a single vertex.\
> (loop = (v1, v1))

## Isolated vertex
> v is isaolated vertex in Graph G(V,E)\
> iff there are not exists any edges e such that are incident on v.

## Simple Graph
> A graph with neither loop nor parallel edges is called simple.

## Weighted Graph
> Weighted Graph is a graph with numbers(weight) on the edges.

## Complete Graph with n vertices (Kn)
> The complete graph (V,E) in n vertices is the simple graph with n vertices\
> satisfying that there exists some edge e in E\
> (e = (v, w) for any v,w in V)

## Bipartite Graph (이분화 그래프)


## Complete Bipartite Graph (Kn,m)


## Path
> A path from v0 to vn of length n\
> (v0, e1, v1, e2, v2, ..., en-1, vn)

> Alternating sequence of V, E

## Connected Graph
> A graph G = (V, E) is connected\
> iff for any two vertex v, w, there exists some path from v to w.

## SubGraph
> G = (V, E)\
> G' = (V', E')\
> V' is subset of V\
> E' is subset of E\
> For any edge e in E', e = (v, w), then v, w is in V'

## Simple Path
> A simple path from v to w is a path with no repeated vertices.

## Cycle
> A cycle is a path from v to v with no repeated edge. (possible repeated vertices)

## Simple Cycle
> A simple cycle is a cycle from v to v with no repeated vertices except for v.

## Euler Cycle
> An Euler cycle is a cycle in a graph that includes all vertices and edges of G.
 
## Degree

---

## BFS

---
## DFS

---
## Backtracking

---
## Greedy Algorithm

---
## Divide & Conquer

---
## Dynamic Programming (DP)

## LIS (Longest Increasing Sequence)
https://dyngina.tistory.com/16

## LCS (Longest Common String)

## LCA (Longest Common Ancestor)

---

## Binary Index Tree
- https://dyngina.tistory.com/14
- [Sample Code](./src/algorithm/BinaryIndexTree.java)

## Segment Tree
- https://www.acmicpc.net/blog/view/9
- [Sample Code](./src/algorithm/SegmentTree.java)

## Fenwick Tree
- https://www.acmicpc.net/blog/view/21
- [Sample Code](./src/algorithm/FenwickTree.java)

---

# 최단 경로 구하는 알고리즘 (the shortest path problem)
1. single source & single destination  (distance)
2. single source (distance[i] : c0 --> i) --> dijkstra algorithm, bellman ford
3. single destination (distance[i] : i --> c0)   
4. all pairs (distnace[i][j] : i--> j)  --> floyd-warshall

## Dijkstra
- [https://ko.wikipedia.org/wiki/%EB%8D%B0%EC%9D%B4%ED%81%AC%EC%8A%A4%ED%8A%B8%EB%9D%BC_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98](https://ko.wikipedia.org/wiki/%EB%8D%B0%EC%9D%B4%ED%81%AC%EC%8A%A4%ED%8A%B8%EB%9D%BC_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)
- [Sample Code](./src/algorithm/Dijkstra_Algorithm.java)

## Bellman-Ford
- [https://ko.wikipedia.org/wiki/%EB%B2%A8%EB%A8%BC-%ED%8F%AC%EB%93%9C_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98](https://ko.wikipedia.org/wiki/%EB%B2%A8%EB%A8%BC-%ED%8F%AC%EB%93%9C_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)
- [Sample Code](./src/algorithm/BellmanFord_Algorithm.java)

## Floyd-Warshall
- [https://ko.wikipedia.org/wiki/%ED%94%8C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%9B%8C%EC%85%9C_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98](https://ko.wikipedia.org/wiki/%ED%94%8C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%9B%8C%EC%85%9C_%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)
- [Sample Code](./src/algorithm/FloydWarshall_Algorithm.java)

## Union Find (Disjoin Set)
https://ko.wikipedia.org/wiki/%EC%84%9C%EB%A1%9C%EC%86%8C_%EC%A7%91%ED%95%A9_%EC%9E%90%EB%A3%8C_%EA%B5%AC%EC%A1%B0

## Topology Sort
1. DFS로 구현 (DFS Spanning Tree)
2. Queue with indgree 로 구현
- https://m.blog.naver.com/PostView.nhn?blogId=xowns4817&logNo=221080426768&proxyReferer=https:%2F%2Fwww.google.com%2F
- https://jason9319.tistory.com/93

## MST 구현 (Minimal Spanning Tree)
1. Kruskal Algorithm
2. Prim's Algorithm

## 단절점, 단절선 (Articulation Point, Articulation Edge)
https://bowbowbow.tistory.com/3

## Line Sweeping, Plane Sweeping
[https://www.acmicpc.net/problem/2170](https://www.acmicpc.net/problem/2170)

---



# Day-01
- 기출P-0063 Pac Man
- 기출P-0042 배제쌍
- 기출P-0034 팀짜기
- 기출P-0067 가장 큰 최단 경로

# Day-02
- 교육P-0035 이진 탐색2     -- DP
- 기출P-0023 운동하자       -- DP
- 기출P-0054 자동차 여행    -- DP
- 기출P-0017 직사각형 개수세기 -- DP

# Day-03
- 기출P-0036 워드프로세서 고장     -- DP
- 기출P-0048 도둑잡기             -- 위상정렬 (Topology Sort)
- 기출P-0050 모든 쌍의 최단경로    -- Graph, 사이클 찾기
- 사전A-0032 타일 붙이기          -- 경우의 수, DP     (과제!!)

# Day-04
- 기출P-0038 키컸으면    -- 구간트리 (Segment Tree)
- 기출P-0056 수열지우기  -- LIS (Longest Increasing Subsequence)
- 연습P-0025 등산        -- Parametric Search (Binary Search)
- 기출P-0007 팀 구성     -- DP

# Day-05
- 기출P-0058 탱크         -- 구간트리
- 기출P-0065 Shields Up!  -- Dijkstra, 위상정렬
- 기출P-0039 개미 굴 파기  -- MST 최소신장트리
      (1. Prim's 2. Kruskal), LCA(Lowest Common Ancesotr), 단절점 단절선
- 기출P-0018 종이컵 전화기 -- DP

---

# Git Proxy Setting
```bash
$ vi ~/.gitconfig
[user]
  name = rolroralra
  email = shyoung.kim@samsung.com
[http]
  proxy = http://70.10.15.10:8080
  sslVerify = false
[https]
  proxy = http://70.10.15.10:8080
[credential]
  helper = wincred
[filter "lfs"]
  clean = git-lfs clean -- %f
  smudge = git-lfs smudge -- %f
  process = git-lfs filter-process
  required = true
[core]
  autocrlf = true
```
