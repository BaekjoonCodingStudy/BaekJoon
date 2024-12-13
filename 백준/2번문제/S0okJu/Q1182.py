"""

1. 아이디어 

2. 시간복잡도 :
O(N) : 최대 depth 만큼 계산
3. 자료구조 : 

"""
import sys
input = sys.stdin.readline

N, S = map(int, input().split())
numbers = list(map(int, input().split()))
count = 0

def backtrack(depth, total):
    global count
    #print(f"depth : {depth}, total : {total}")
    if depth == N: 
        if total == S:  
            count += 1
        return
    
    # 현재 숫자를 포함하는 경우
    backtrack(depth + 1, total + numbers[depth])
    # 현재 숫자를 포함하지 않는 경우
    backtrack(depth + 1, total)

backtrack(0, 0)
if S == 0:
    count -= 1
print(count)
