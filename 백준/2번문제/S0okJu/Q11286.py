import heapq
import sys

input = sys.stdin.readline
def timeout1():
    n = int(input())
    calc = {}

    for _ in range(n):
        c = int(input())    
        # 0이 아닌 경우 값 삽입
        if c != 0:
            abs_c = abs(c)
            if abs_c not in calc:
                calc[abs_c] = []  
            calc[abs_c].append(c)
        else:
            # 0인 경우: 절대값이 가장 작은 값을 출력하고 제거
            if calc:
                min_abs = min(calc.keys())
                min_num = sorted(calc[min_abs])[0] 

                print(min_num)  
                calc[min_abs].remove(min_num)  

                if not calc[min_abs]:
                    del calc[min_abs]
            else:
                print(0)
"""

1. 아이디어 
- 비교 대상이 2개 (절대값, 절대값 중에서도 값이 작은 것)
- 우선순위 큐에 넣을때 2개의 값을 튜플로 넣어 우선순위를 지정할 수 있도록한다.

2. 시간복잡도 :
O(n)
3. 자료구조 : 우선순위 

"""
def solution():
    heap = []
    ans = []
    
    n = int(input())
    
    for _ in range(n):
        c = int(input())
    
        if c != 0 :
            # [(1, -1), (1,1), (2,-2)]
            heapq.heappush(heap, (abs(c),c))
        else:
            if len(heap)==0:
                ans.append(0)
            else:
                _, v = heapq.heappop(heap)
                ans.append(v)
    
    for a in ans:
        print(a)

if __name__ == '__main__':
    solution()
                
            



            