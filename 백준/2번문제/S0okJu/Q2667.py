"""
1. 아이디어 
- 입력값이 1인 경우에만 deque에 넣어둔다.
    -> 만약에 주변이 0이라면 deque는 빈 값이 된다. 
- 1이 있는 경우를 모두 찾아줘야 한다.

2. 시간복잡도 :
O(n)

3. 자료구조 : BFS
"""

from collections import deque

n = int(input())

grid = []

for _ in range(n):
    row = list(map(int, input())) 
    grid.append(row)

visited = [[False] * n for _ in range(n)]
# result는 디버깅용
# result = [[0] * n for _ in range(n)]

def bfs(start, end):
    queue = deque([(start, end)])
    visited[start][end] = True
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)] # 상하좌우
    cnt = 1
    
    while queue:
        x, y = queue.popleft()
        
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            
            if 0 <= nx < n and 0 <= ny < n and grid[nx][ny] == 1 and visited[nx][ny] == False:
                cnt +=1
                visited[nx][ny] = True            
                queue.append((nx, ny))
                # result[nx][ny] = cnt
                
    return cnt

check = list()
for i in range(n):
    for j in range(n):
        if visited[i][j] == False and grid[i][j] == 1:                    
            res = bfs(i,j)
            check.append(res)            

#for row in result:
#    print(' '.join(map(str, row)))

# sorted(check) 
check.sort()
print(len(check))
for c in check:
    print(c)