"""
1.아이디어 :

2.시간복잡도 :

3.자료구조 :
재귀함수
"""

import sys

input = sys.stdin.readline

N, M = map(int, input().split())
rs = [] # 넣었다가 뺐다가. 막다른 길 다다르면 뒤로간다.
chk = [False] * (N+1) # N=4, M=4일때 False 5개이다. # 갔는지 안 갔는지 확인 용도

def recur(num):
    if num == M:
        print(' '.join(map(str, rs)))
        return
    for i in range(1, N+1):
        if chk[i] == False: # 아직 안 갔다면
            chk[i] = True
            rs.append(i)
            recur(num+1)
            chk[i] = False
            rs.pop()
recur(0)


N, S = map(int, input().split())
rs = list(map(int, input().split()))

# 재귀함수 이용
cnt = 0

def solve(start):
    global cnt
    if sum(rs) == S and len(rs) > 0:
        cnt += 1
        print('cnt:', cnt)
    for i in range(start, N):
        rs.append(rs[i])
        print('append:', rs)
        solve(i+1)
        rs.pop()

solve(0)
print(cnt)