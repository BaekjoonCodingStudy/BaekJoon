"""

1. 아이디어 :
- 큰 수를 가져갈 수 있다면 먼저 가져갈 수 있도록 구현한다.
2. 시간복잡도 :
O(n)
3. 자료구조 : 동적 계획법

"""


def solution(idx,people):
    # print(f"{idx}, {people}")
    if idx == 0:
        return people
    
    if idx >=3:
        return solution(idx-3,people+1)
    else:
        return solution(idx-1,people+1)
    
    
if __name__ == '__main__':
    n = int(input())
    people = 0
    
    winner = solution(n,people)
    if winner % 2 ==0:
        print("CY")
    else:
        print("SK")
        
    