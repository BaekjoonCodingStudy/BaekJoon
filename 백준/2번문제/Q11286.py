# 맨 처음 생각은 모든 값에 절대값 취하고 그 값을 ordering 하는 걸 생각함
# 그런데 어찌됐든 원래 값을 뱉어내야 하고, -1과 1이 있으면 더 작은 -1?을 뱉어야 하므로, 튜플이나 딕셔너리를 생각함.
# 그래서 얘도 딕셔너리처럼 생각함.
# 예를 들어, dict = {'-1':1, 1:1, 2:2, 3:3} 뭐 이런식으로 접근하려 함.
# 그런데 자꾸 에러 남..!!
# 그래서 찾아보니까 딕셔너리가 아니라 heapq이라는 구조가 있고, 이걸 이용하면 해결 가능
# heapq은 (절대값, 원래값) 이렇게 넣으면 절대값 기준으로 정렬 가능
# 

import sys
import heapq

n = int(input())
q = []

for i in range(n):
    a = int(sys.stdin.readline().rstrip())
    if a != 0:
        heapq.heappush(q, (abs(a), a))
    else:
        if not q:
            print(0)
        else:
            print(heapq.heappop(q)[1])
