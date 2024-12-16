
import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline


if __name__ == '__main__':
    D, P = map(int, input().split())

    arr = []
    for i in range(P):
        arr.append(tuple(map(int, input().split())))


