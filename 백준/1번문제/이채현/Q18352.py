"""
1. 아이디어 : 그래프로 어떻게 표현할지
min이 K가 아니면 버려야 됨 (예를 들어 3) 어떻게 버릴지
heap을 쓰는건 어떨지
heap은 시간복잡도 O(logN)이다.
2. 시간복잡도 : 
vertex, path 입력 받는 거 O(M)
distance 계산 하는 거 O(N)
heap은 O(logN) (걍 외우기)
모든 도로(M)에 대해 heap 수행하면 O((N+M) logN)
거리 K인거 찾는 거 O(N) 더해지는데 무시 될 듯
3. 자료구조 : heap, 다익스트라 알고리즘

"""


import sys
import heapq

input = sys.stdin.readline
INF = sys.maxsize


if __name__ == '__main__':
    N, M, K, X = map(int, input().split())
    city = [[] for _ in range(N+1)] # N개 만큼 빈 리스트 생성
    for _ in range(M): # path 연결
        v1, v2 = map(int, input().split())
        city[v1].append(v2) # v1번 노드에 v2 연결; 1번 index에 2,3 연결; 2번 index에 3,4 연결
    distance = [INF] * (N+1) # 비교 위해 일단 큰값 넣
    distance[X] = 0 # 1과 1사이 거리는 0으로
    # 다익스트라 알고리즘 (heap)
    hq = []
    heapq.heappush(hq, [0,X])
    while hq:
        now_dis, now_v = heapq.heappop(hq) # heap에서 가장 작은 원소를 pop & return
        for next_v in city[now_v]:
            if distance[next_v] > now_dis + 1:
                distance[next_v] = now_dis + 1
                heapq.heappush(hq, [distance[next_v], next_v])
    is_exist = False
    for i in range(1, N+1):
        if distance[i] == K:
            print(i, end=" ")
            is_exist = True
    if is_exist == False:
        print(-1)
        
heapq.heappush(hq, [1,2])
heapq.heappush(hq, [1,3])
