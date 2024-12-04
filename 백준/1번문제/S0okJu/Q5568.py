"""

1. 아이디어 
- 순서가 중요한 순열을 계산해서 set으로 중복 제거 

2. 시간복잡도 :
O(n)

3. 자료구조 : x

"""
from itertools import permutations

n = int(input())
k = int(input())

cards = list()
for _ in range(n):
    card = int(input())
    cards.append(card)

result = set(int("".join(map(str, perm))) for perm in permutations(cards,k))

print(len(result))