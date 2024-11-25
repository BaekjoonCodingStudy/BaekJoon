# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    dp로 풀 수 있습니다.
    s1의 길이만큼 rows, s2의 길이만큼 cols를 초기화합니다.
    dp[row][0], dp[0][col]를 1개씩 증가시킵니다. (모두 바꾸는 경우)
    i, j을 1부터 시작합니다. (s1의 i번쨰와 s2의 j번째까지 왔을때의 비교)

    만약 s1[i-1] == s2[j-1]일 경우(나머지 조건은 일단 무시), 바꾸지 않아도 되기떄문에 [i-1][j-1]값을 가져옵니다.
    다를 경우, s2의 값을 삭제하는 연산 / s2의 값에 추가하는 연산 / s2의 값을 바꾸는 연산 중 작은 값에 1을 더합니다.
2. 시간복잡도 :
    O( n * m )
3. 자료구조 :
    배열
'''

import sys

# sys.setrecursionlimit(1000000)
# input = sys.stdin.readline
input = lambda: sys.stdin.readline().rstrip()


def solution(n, m, s1, s2):
    dp = [[0] * (m + 1) for _ in range(n + 1)]

    for i in range(n + 1): dp[i][0] = i
    for j in range(m + 1): dp[0][j] = j

    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if (s1[i - 1] == s2[j - 1]) or (s1[i - 1] == 'i' and s2[j - 1] in 'ijl') or (s1[i - 1] == 'v' and s2[j - 1] == 'w'):
                dp[i][j] = dp[i - 1][j - 1]
            else:
                dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1)  # 삭제, 삽입, 변환
    for a in dp: print(a)
    return dp[n][m]


if __name__ == '__main__':
    n, m = map(int, input().split())
    s1 = input().strip()
    s2 = input().strip()
    print(solution(n, m, s1, s2))
