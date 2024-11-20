
# import sys

# # input = sys.stdin.readline

# N = int(input())


# if N == 1:
#     print(int(input()))
# elif N>=2:
#     w_list = []
#     for i in range(N):
#         w_list.append(int(input()))
#     w = min(w_list)*N
#     print(w)
        

import sys
from itertools import combinations
# import numpy as np

N = int(input())

if N == 1:
    print(int(input()))
elif N>=2:
    w_list = []
    w_comparison = [] # 크기 비교
    
    for _ in range(N):
        w_list.append(int(input()))
    w_list.sort()
    
    for num in range(1,N+1):            
        if num == 1: # when 1, last가 걍 최대 weight
            w_comparison.append(w_list[-1])
            
        if num >=2:
           tmp = list(combinations(w_list, num))
           last_combi = tmp[-1]
           min_value = min(last_combi)
           w = min_value * num
           w_comparison.append(w) 
    print(max(w_comparison))
    
# 시간 줄이려고 sort 썼는데... combinations을 써서 그런지 메모리 초과 발생.. 
# 아니면 너무 복잡하게 생각했나?
