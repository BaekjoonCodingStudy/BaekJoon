"""
1. 아이디어 : 음수 간선이 포함된 상황에서 최단 거리 구하기
무한히 어쩌구 -> 음수 간선의 순환 -> 다익스트라 불가능, 벨만 포드 써야 됨
음의 순환을 검출
2. 시간복잡도 : 
다익스트라보다는 오래 걸릴.. 듯
다 봐야돼서 힙도 못 쓰고.. 악
3. 자료구조 : 
벨만포드알고리즘
"""


import sys

input = sys.stdin.readline
INF = sys.maxsize


if __name__ == '__main__':
    N, M = map(int, input().split()) # N은 city M은 노선
    city = []
    time = [INF] * (N+1)
    time[1] = 0
    for _ in range(M):
        a, b, c = map(int, input().split())
        city.append((a,b,c))
    for i in range(1, N+1): # 매 city마다
        for j in range(M): # 매 노선마다; 걍 다 확인 like brute force..?
            start, end, cost = city[j][0], city[j][0], city[j][0] # 시작 도시, 도착 도시, 그때 걸리는 시간
            if time[start] != INF and time[end] > time[start] + cost:
                time[end] = time[start] + cost
                if i == N:
                    check = True
    check = False
    if check:
        print(-1)
    else:
        for i in range(2, N+1):
            if time[i] == INF:
                print(-1)
            else:
                print(time[i], end=" ")