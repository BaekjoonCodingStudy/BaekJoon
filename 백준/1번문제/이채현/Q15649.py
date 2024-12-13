"""
1.아이디어 :
백트래킹은 brute force(완전 탐색)과도 비슷할 듯.
그래서 N이 1번 문제처럼 저렇게 적어야지 백트래킹 쓸 수 있다.

당장 N=4, M=4만 해도 엄청 길어진다..
for문 여러 개 쓰면 해결되지만, 코드 더러워
then 어떻게? 재귀함수!
dfs 같기도...
2.시간복잡도 :
O(N!?) : 순열이니까
3.자료구조 :

"""

import sys

input = sys.stdin.readline

N, M = map(int, input().split())
rs = [] # 넣었다가 뺐다가. 막다른 길 다다르면 뒤로간다.
chk = [False] * (N+1) # N=4, M=4일때 False 5개이다. # 갔는지 안 갔는지 확인 용도

def recur(num):
    print("num : ",num)
    if num == M:
        print(' '.join(map(str, rs)))
        return
    for i in range(1, N+1):
        if chk[i] == False: # 아직 안 갔다면
            chk[i] = True
            rs.append(i)
            print("append : ", rs)
            recur(num+1)
            chk[i] = False
            rs.pop()
            print("pop : ", rs)

recur(0)


recur(0)