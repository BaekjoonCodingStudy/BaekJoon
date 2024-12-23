"""
1. 아이디어
- 
- 
- 
2. 시간복잡도
- 점 좌표 정렬 O(nlogn)
- 2개의 이분탐색을 m번 반복 O(mlogn)
3. 자료구조
- 
- 
"""

# import sys
# from bisect import bisect_left, bisect_right

# input = sys.stdin.readline

# N, M = map(int, input().split())
# dots = list(map(int, input().split()))
# lines = [list(map(int, input().split())) for _ in range(M)]
# dots.sort()

# for line in lines:
#     start, end = line
#     left = bisect_left(dots, start)
#     right = bisect_left(dots, end)
#     print(len(dots[left:right]))

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
dots = list(map(int, input().split()))
lines = [list(map(int, input().split())) for _ in range(M)]
dots.sort()

# 시작점, 끝점과 가까운 점을 찾기
# 선분 양 옆을 binary search로 찾는다.
def binary_start(dots, target):
    start = 0
    end = N - 1
    while start <= end:
        mid = (start + end) // 2 # 소수점 이하 버리고 정수부분 반환
        if dots[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    return start

def binary_end(dots, target):
    start = 0
    end = N - 1
    while start <= end:
        mid = (start + end) // 2
        if dots[mid] <= target: # 끝자리 index는 +1 해줘야 하니까?
            start = mid + 1
        else:
            end = mid - 1
    return start

# 각 선분에 대해 계산
for line in lines:
    start, end = line
    left = binary_start(dots, start)
    right = binary_end(dots, end)
    # 결과 출력
    print(right - left)