def transform(r, c, grid):
    
    new_grid = [['.'] * c for _ in range(r)]

    for i in range(r):
        for j in range(c):
            if grid[i][j] == 'X':
                sea_cnt = 0
                # 좌표를 모두 탐색해서 주변이 3개 이상이라면 땅을 침수시킨다. 
                for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                    ni, nj = i + dx, j + dy
                    # 범위에 벗어나는지 확인 & 주변이 바다인지 확인
                    if ni < 0 or nj < 0 or ni >= r or nj >= c or grid[ni][nj] == '.':
                        sea_cnt += 1
                if sea_cnt < 3:
                    new_grid[i][j] = 'X'

    # 결과 지도는 크기가 작아질 수 있으므로 땅을 기준으로 최대 최소 행렬의 길이를 구한다.
    min_row, max_row = r, -1
    min_col, max_col = c, -1

    for i in range(r):
        for j in range(c):
            if new_grid[i][j] == 'X':
                min_row = min(min_row, i)
                max_row = max(max_row, i)
                min_col = min(min_col, j)
                max_col = max(max_col, j)

    # print("New Grid After Sinking:")
    # for row in new_grid:
    #     print("".join(row))

    # 
    result = []
    for i in range(min_row, max_row + 1):
        # row  = list()
        # for j in range(min_col, max_col+1):
        #     row.append(new_grid[i][j])
        # result.append("".join(row))
        result.append("".join(new_grid[i][min_col:max_col + 1]))
    return result

r, c = map(int, input().split())
grid = [input().strip() for _ in range(r)]

result = transform(r, c, grid)
for line in result:
    print(line)
