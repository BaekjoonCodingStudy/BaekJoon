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

# 정렬한 후
# start + end 더한 것 abs 구한다
# 그 다음 start + end 더한 것과 계속 비교하는 식으로 진행하면 될 듯?

import sys
input = sys.stdin.readline

N = int(input())
liquids = list(map(int, input().split()))
liquids.sort() 
start = 0
end = len(liquids) - 1
mixx = 100000 # 일부러 큰 수

while start < end:
    mixture = liquids[start] + liquids[end] # 기준
    if abs(mixture) < mixx: # 10000보다 작으니까 mixx는 abs(mixture)
        mixx = abs(mixture)
        solution = [liquids[start], liquids[end]]
        if mixx == 0:
            break
    elif mixture < 0: # mixture이 0보다 작으면? 오른쪽(양의 방향)으로 가자
        start += 1
    else: # 0보다 크면 음의 방향으로 가자
        end -= 1
    
solution.sort()
print(solution[0], solution[1])