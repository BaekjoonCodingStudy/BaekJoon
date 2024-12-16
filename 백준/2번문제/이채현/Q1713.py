"""
1. 아이디어

- 
2. 시간복잡도

3. 자료구조
- pop
- 선입선출
- stack
- if를 여러개 써야 할 듯

"""

import sys
input = sys.stdin.readline
# from copy import deepcopy

R, C = map(int, input().split())
map_list = [list(input().rstrip()) for _ in range(R)]
dx = [0,1,0,-1]
dy = [-1,0,1,0]

N = int(input())
M = int(input())

students = list(map(int, input().split()))
picture = [] # 사진틀
recommend = [] # 추천수

# for i in range(M):
#     if students[i] in picture: # 사진틀에 있으면
#         for j in range(len(picture)):