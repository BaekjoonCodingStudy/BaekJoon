import sys
input = sys.stdin.readline
    
n = int(input())  
8
answer_grid = [list(input()) for _ in range(n)] 
# '...**..*'
# '......*.'
# '....*...'
# '........'
# '........'
# '.....*..'
# '...**.*.'
# '.....*..'
player_grid = [list(input()) for _ in range(n)] 
# 'xxxx....'
# 'xxxx....'
# 'xxxx....'
# 'xxxxx...'
# 'xxxxx...'
# 'xxxxx...'
# 'xxx.....'
# 'xxxxx...'
output_grid = []
bomb = False # 한번이라도 밟으면 True

dx = [1,0,-1,0,1,-1,1,-1]
dy = [0,1,0,-1,-1,1,1,-1]

for i in range(n):
    tmp = [] 
    for j in range(n): 
        cnt = 0 #
        if player_grid[i][j] == 'x' and answer_grid[i][j] == '*':
            bomb = True 
        if player_grid[i][j] == 'x': 
            for k in range(8): 
                if n>(i+dx[k])>=0 and n>(j+dy[k])>=0 and answer_grid[i+dx[k]][j+dy[k]] == '*': 
                    cnt += 1
            tmp.append(str(cnt)) 
        else:
            tmp.append('.') 
    output_grid.append(tmp) 

if bomb: 
    for i in range(n):
        for j in range(n):
            if answer_grid[i][j] == '*': 
                output_grid[i][j] = '*' # 지뢰 하나라도 밟으면 모든 지뢰가 다 켜진다.

for data in output_grid:
    print(''.join(data))
