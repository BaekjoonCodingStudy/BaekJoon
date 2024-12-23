"""
아이디어 : 먼저 방문하는 것이 최단거리
시간 복잡도 : O(N)
- ahems s
알고리즘 : BFS
"""
from collections import deque
import sys

input = sys.stdin.readline
n, m, k, x = map(int, input().split())


# 그래프 초기화
# 1 [2, 3]
# 2 [3, 4]
# 3 [4]
# 4 []
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

# 최단 거리 초기화
distance = [-1] * (n + 1)
# 출발 거리 
distance[x] = 0  

# 
queue = deque([x])
while queue:
    current = queue.popleft()
    # print(current)
    # 이동할 수 있는 모든 도시 확인
    for next_city in graph[current]:
        # print(f"next_city : {next_city}")
        # 먼저 방문하는 것이 최단거리
        if distance[next_city] == -1:
            distance[next_city] = distance[current] + 1
            queue.append(next_city)
        # print(queue)
        


result = []
for i in range(1, n + 1):
    if distance[i] == k:
        result.append(i)

if not result:
    print(-1)
else:
    # result.sort()  
    # 오름차순으로 저장되므로 sort는 필요 없을 것 같다. 
    for city in result:
        print(city)