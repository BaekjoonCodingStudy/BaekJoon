"""
O(N^2)
"""
from collections import deque
import sys

input = sys.stdin.readline
n, m, k, x = map(int, input().split())


# 그래프 초기화
# 1 [2, 3]
# 2 [3, 4]
# 3 []
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
    
    # 이동할 수 있는 모든 도시 확인
    for next_city in graph[current]:
    
        if distance[next_city] == -1:
            distance[next_city] = distance[current] + 1
            queue.append(next_city)


result = []
for i in range(1, n + 1):
    if distance[i] == k:
        result.append(i)

if not result:
    print(-1)
else:
    result.sort()  
    for city in result:
        print(city)