"""

1. 아이디어 
- 최종 음료의 양이 최대가 되려면 양이 작은 음료를 포기해야 한다.

2. 시간복잡도 :
O(n)

3. 자료구조 : x

"""

def print_number(number):
    if number == int(number):
        print(int(number))
    else:
        print(number)
        
def solution(n, drinks):
    sorted_drinks = sorted(drinks, reverse=True)
    before = float(sorted_drinks[0])
    for i in range(1,n):
        if before > sorted_drinks[i]:
            before = float(before) + (sorted_drinks[i]/2)
        else:
            before = float(sorted_drinks[i]) + (before/2)
        
    print_number(before)
        
if __name__ == '__main__':
    drinks = list()
    
    n = int(input())
    
    drinks = list(map(int,input().split()))
    solution(n, drinks)