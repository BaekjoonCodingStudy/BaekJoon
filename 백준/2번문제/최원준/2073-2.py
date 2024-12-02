# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    dp를 사용합니다.
    각 파이프를 한번만 사용할 수 있으니, 파이프마다 순회합니다.
    끝 distance부터 시작해서, 각 파이프를 연결했을때의 값을 구합니다.
2. 시간복잡도 :
    O( distance * p )
3. 자료구조 :
    배열
'''

import sys
# sys.setrecursionlimit(1000000)
# input = sys.stdin.readline
input = lambda: sys.stdin.readline().rstrip()
from collections import defaultdict


def solution(d, p, pipes):
    dp = [0] * (d + 1)
    dp[0] = float('inf')

    for length, capacity in pipes.items():
        for distance in range(d, length-1, -1):
            dp[distance] = max(dp[distance], min(dp[distance - length], capacity))

    return dp[d]


if __name__ == '__main__':
    d, p = map(int, input().split())
    pipes = defaultdict(int)
    for _ in range(p):
        l, c = list(map(int, input().split()))
        pipes[l] = max(pipes[l], c)
    print(solution(d, p, pipes))
