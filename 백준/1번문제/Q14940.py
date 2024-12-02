
import sys
input = sys.stdin.readline

from collections import deque
N, M = map(int, input().split())
logs = [list(map(int, input().split())) for _ in range(N)]
visited = [[-1] * M for _ in range(N)]
dx = [0,0,-1,1]
dy = [-1,1,0,0]

def bfs(i,j):
    q = deque()
    q.append((i,j))

    visited[i][j] = 0

    while q:
        x, y = q.popleft()
        
        for i in range(4):
            nx, ny = dx[i] + x, dy[i] + y
            
            if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == -1:
                if logs[nx][ny] == 0: 
                    visited[nx][ny] = 0
                elif logs[nx][ny] == 1:
                    visited[nx][ny] = visited[x][y] + 1
                    q.append((nx,ny))

for i in range(N):
    for j in range(M):
        if logs[i][j] == 2 and visited[i][j] == -1:
            bfs(i,j)

for i in range(N):
    for j in range(M):
        if logs[i][j] == 0:
            print(0, end=' ')
        else:
            print(visited[i][j], end=' ')
    print()

# 알고리즘: bfs 
# bfs 문제는 queue를 이용해서 푼다. 
# queue가 무엇인가?
# 한쪽 끝에서만 삽입이 이루어지고, 다른 한쪽 끝에서는 삭제 연산만 이루어지는 list이다.
# 선입선출, 먼저 들어온 것이 먼저 나간다.


# 시간 복잡도: O(N)
