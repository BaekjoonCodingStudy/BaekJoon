"""
1. 아이디어
- 이중
- 4방향을 for문으로 탐색
- 
2. 시간복잡도
- O(NM):
3. 자료구조
- map
- 위치, 방향, 바다에 잠긴 곳
"""

import sys
input = sys.stdin.readline
# from copy import deepcopy

R, C = map(int, input().split())
map_list = [list(input().rstrip()) for _ in range(R)]
dx = [0,1,0,-1]
dy = [-1,0,1,0]

# new = deepcopy(map)

# for y in range(C):
#     for x in range(R):
#         if map[y][x] == 'X':
#             cnt = 0
#             for i in range(0,3+1):
#                 ny = y + dy[i]
#                 nx = x + dx[i]
#                 print('ny',ny)
#                 print('nx',nx)
#                 if 0<=ny<C and 0<=nx<R:
#                     if map[ny][nx] == '.':
#                         cnt += 1
#             if cnt >= 3:
#                 new[y][x] == '.'
                    
#             # 4방향 모두 있지 않은 경우
#             # if sw == False:

sea = []
for x in range(R):
    for y in range(C):
        if map_list[x][y] == 'X':
            cnt = 0
            for i in range(0,3+1):
                nx = x + dx[i]
                ny = y + dy[i]
                # print('nx',nx)
                # print('ny',ny)
                if 0<=nx<R and 0<=ny<C:
                    if map_list[nx][ny] == '.':
                        cnt += 1
                else: # 지도 초과 -> 바다
                    cnt += 1
                    continue
            if cnt >= 3:
                # new[x][y] == '.'
                sea.append((x,y))

if len(sea) >0:
    for x, y in sea:
        map_list[x][y] = '.'

# set(map_list)

loc = []
# 위치 찾기
for x in range(R):
    for y in range(C):
        if map_list[x][y] == 'X':
            loc.append((x,y))
            
min_x = min(loc[0] for loc in loc)
max_x = max(loc[0] for loc in loc)
min_y = min(loc[1] for loc in loc)
max_y = max(loc[1] for loc in loc)

# sol = '\n'.join(''.join(row[:max_y+1]) for row in map_list[min_x:])
# sol
# print(sol)

for i in range(min_x,max_x+1):
    for j in range(min_y,max_y+1):
        print(map_list[i][j], end='')
    print()