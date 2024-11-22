

import sys
sys.setrecursionlimit(1000)
input = sys.stdin.readline
import math


def solution(n):
    case_of_num = 0
    # 홀수
    if n%2==1:
        maximum_pink_block = int((n-1)/2) # maximum_yel_block = n
        for i in range(0,maximum_pink_block):
            yel_block = 2*i+1
            pink_block = maximum_pink_block - i
            case_of_num += math.factorial(pink_block+yel_block)/(math.factorial(pink_block)*math.factorial(yel_block))

    # 짝수
    if n%2==0:
        maximum_pink_block = int(n/2) # maximum_yel_block = n
        for i in range(0,maximum_pink_block):
            yel_block = 2*i
            pink_block = maximum_pink_block - i
            case_of_num += math.factorial(pink_block+yel_block)/(math.factorial(pink_block)*math.factorial(yel_block))
    print(int(case_of_num%10007)+1)
    
    
    


if __name__ == '__main__':
    n = int(input())
    solution(n)
