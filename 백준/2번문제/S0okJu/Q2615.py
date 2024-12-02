
def solution():
    
    board = []
    is_stone = [[False for _ in range(19)] for _ in range(19)]
    
    for i in range(19):
        row = list(map(int, input().split()))
        board.append(row)
        
        # 돌이 있는 경우에  True 반환
        for r in row:
            if r != 0:
                is_stone[i][r] = True
                
    
    # 바둑찾기
    for c in range(19):
        for r in range(19):
            if r != 18 and is_stone[c][r] == True: # 바둑이 있다면
                color = board[c][r] # black 1 white 2
                is_stone[c][r] = False
                cnt = 0
                for k in range(r+1,19):
                    if is_stone[c][k] == False:
                        break
                    else:
                        if color != board[c][k]:
                            break
                        else:
                            cnt += 1
                        
                if cnt == 5:
                    print(board[c][k])
    
    
