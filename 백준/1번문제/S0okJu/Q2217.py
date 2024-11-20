"""

1. 아이디어 
w(물체의 중량) / k(로프의 개수) = 로프의 중량 
우리가 구하고자 하는 것은 최대 물체의 중량 
문제에서는 로프의 최대 중량이 주어짐 
- w(물체의 중량) max / k(로프의 개수) min = 로프의 중량 max
- max 물체의 중량 = 로프의 중량 min * 로프의 개수 max

2. 시간복잡도 :
O(n)

3. 자료구조 : x

"""
def solution(n, max_w):
    sorted_max_w = sorted(max_w)
    k = n 
    hw = 0
    for j in range(len(sorted_max_w)):
        w = sorted_max_w[j] * (k-j)   
        hw = max(hw,w)
    
    print(hw)
    

if __name__ == '__main__':
    n = int(input())
    max_w = list()
    for i in range(n):
        w = int(input())
        max_w.append(w)
    
    solution(n, max_w)