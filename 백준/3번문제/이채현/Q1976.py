import sys
from collections import deque # 양방향 큐
# 우리 문제는 양방향이다. so, deque 사용!
# graph theory.. bfs 사용!

input = sys.stdin.readline



if __name__ == '__main__':
    N = int(input())
    M = int(input())
    cities = [list(map(int, input().split())) for _ in range(N)]
    plan = list(map(int, input().split()))
    chk = [False] * (N+1) #방문여부 check
    result = "YES"
    q = deque()
    q.append(plan[0] - 1) # 첫번째 도시 넣
    chk[plan[0] - 1] = True # 첫번째 도시부터 시작
    while q:
        print("q : ",q)
        now = q.pop()
        print("now : ",now)
        for i in range(N):
            print("i : ",i)
            print("now :", now)
            print("cities : ", cities)
            print("cities[now][i] : ",cities[now][i])
            print("chk[i] : ",chk[i])
            if cities[now][i] and not chk[i]:
                chk[i] = True
                q.append(i)
                print("q last : ", q)
    

