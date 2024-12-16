"""
1. 아이디어 
- 상하좌우를 탐색한 결과값을 result에 모두 구한다.
- 0이 아닌 다른 값(-1)으로 초기화시켜 입력값이 0일 경우에는 결과값도 0으로 설정한다.

2. 시간복잡도 :
O(n^2)

3. 자료구조 : BFS

"""
from collections import deque

n, m = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(n)]

start = None
for i in range(n):
    for j in range(m):
        if grid[i][j] == 2:
            start = (i,j)
            break
    if start:
        break

result = [[-1] * m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if grid[i][j] == 0:
            result[i][j] = 0
            
def bfs(start):
    queue = deque([(start[0],start[1], 0)]) # (좌표 x, y, 거리) => 거리는 누적되므로 추가함
    result[start[0]][start[1]] = 0 
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)] # 상하좌우
   
    while queue: 
        x, y, dist = queue.popleft()
        
        # 상하좌우 모두 확인
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            
            # 범위 내에 있는지 확인 
            if 0 <= nx < n and 0 <= ny < m and grid[nx][ny] == 1 and result[nx][ny] == -1:
                result[nx][ny] = dist + 1 
                queue.append((nx, ny, dist + 1))

bfs(start)

for row in result:
    print(' '.join(map(str, row)))