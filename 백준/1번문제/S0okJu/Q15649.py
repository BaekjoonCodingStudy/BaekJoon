"""

1. 아이디어 

2. 시간복잡도 :
O(N^2) : 최대 depth 만큼 계산
3. 자료구조 : 

"""

import sys
input = sys.stdin.readline

N, M = map(int, input().split())

def backtrack(depth):
    if depth == M:
        print(' '.join(map(str, result)))
        return
    
    for i in range(1, N + 1):
        if not used[i]:
            used[i] = True  
            result.append(i)   
            backtrack(depth + 1)  
            result.pop()  
            used[i] = False  

result = []
used = [False] * (N + 1)


backtrack(0)