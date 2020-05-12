# jungol
Reference to "http://jungol.co.kr/"

# 문제 Web Site
- 정올 - "http://jungol.co.kr/"
- 백준 - "https://www.acmicpc.net/"
- "삼성SDS SW검정 프로 교육" -- "https://koitp.org/"
- "삼성 SDS Professional 대비 문제풀이반" https://koitp.org/category/SDS_PRO_201609/
---
# Graph

### Graph
G = (V,E)\
(G: Graph, V: set of vertices, E: set of edges)

### Directed 
directed edge   (v1, v2) != (v2, v1)\
undirected edge  (v1, v2) = (v2, v1)

### Adjacent
v1, v2 are adjacent\
iff there exists an edge e such that e = (v1, v2)

### Incident
some edge e is incident on v1 and v2\
iff e = (v1, v2)

### Parallel
e1, e2 are called parallel\
iff e1 = (v1, v2), e2 = (v1, v2)

### Loop (Self Loop)
Loop is an edge incident on a single vertex.\
(loop = (v1, v1))

### Isolated vertex
v is isaolated vertex in Graph G(V,E)\
iff there are not exists any edges e such that are incident on v.

### Simple Graph
A graph with neither loop nor parallel edges is called simple.

### Weighted Graph
Weighted Graph is a graph with numbers(weight) on the edges.

### Complete Graph with n vertices (Kn)
The complete graph (V,E) in n vertices is the simple graph with n vertices\
satisfying that there exists some edge e in E\
(e = (v, w) for any v,w in V)

### Bipartite Graph (이분화 그래프)


### Complete Bipartite Graph (Kn,m)


### Path
A path from v0 to vn of length n\
(v0, e1, v1, e2, v2, ..., en-1, vn)\

Alternating sequence of V, E

### Connected Graph
A graph G = (V, E) is connected\
iff for any two vertex v, w, there exists some path from v to w.

### SubGraph
G = (V, E)\
G' = (V', E')\
V' is subset of V\
E' is subset of E\
For any edge e in E', e = (v, w), then v, w is in V'

### Simple Path
A simple path from v to w is a path with no repeated vertices.

### Cycle
A cycle is a path from v to v with no repeated edge. (possible repeated vertices)

### Simple Cycle
A simple cycle is a cycle from v to v with no repeated vertices except for v.

### Euler Cycle
An Euler cycle is a cycle in a graph that includes all vertices and edges of G.
 
### Degree

---

### BFS

---
### DFS

---
### Backtracking

---
### Greedy Algorithm

---
### Divide & Conquer

---
### Dynamic Programming (DP)

### LIS (Longest Increasing Sequence)
### LCS (Longest Common String)
### LCA (Longest Common Ancestor)

---

### Binary Index Tree
### Segment Tree
### Fenwick Tree

---

# 최단 경로 구하는 알고리즘 (the shortest path problem)
1. single source & single destination  (distance)
2. single source (distance[i] : c0 --> i) --> dijkstra algorithm, bellman ford
3. single destination (distance[i] : i --> c0)   
4. all pairs (distnace[i][j] : i--> j)  --> floyd-warshall

### Dijkstra
### Bellman-Ford
### Floyd-Warshall

### Union Find (Disjoin Set)
### Topology Sort

### MST 구현 (Minimal Spanning Tree)
1. Kruskal Algorithm
2. Prim's Algorithm

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
