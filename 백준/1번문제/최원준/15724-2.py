# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    누적합을 이용해 풀 수 있습니다.
2. 시간복잡도 :
    O( n*m )
3. 자료구조 :
    배열
'''

import sys

# sys.setrecursionlimit(1000000)
# input = sys.stdin.readline
input = lambda: sys.stdin.readline().rstrip()


def solution(rows, cols, mat, n):
    for row in range(2, rows + 1):
        mat[row][1] += mat[row - 1][1]
    for col in range(2, cols + 1):
        mat[1][col] += mat[1][col - 1]

    for a in mat: print(a)

    for row in range(2, rows + 1):
        for col in range(2, cols + 1):
            mat[row][col] += mat[row - 1][col] + mat[row][col - 1] - mat[row - 1][col - 1]

    for _ in range(n):
        x1, y1, x2, y2 = list(map(int, input().split()))
        topleft = mat[x1 - 1][y1 - 1]
        top = mat[x1 - 1][y2]
        left = mat[x2][y1 - 1]
        print(mat[x2][y2] - top - left + topleft)


if __name__ == '__main__':
    rows, cols = map(int, input().split())
    mat = []
    mat.append([0] * (cols + 1))
    for _ in range(rows):
        mat.append([0] + list(map(int, input().split())))
    n = int(input())
    solution(rows, cols, mat, n)
