

import sys
sys.setrecursionlimit(1000)
input = sys.stdin.readline

def solution(n):
    if n%2==1: #홀수면
        print("SK")
    elif n%2==0: #짝수면
        print("CY")


if __name__ == '__main__':
    n = int(input())
    solution(n)
