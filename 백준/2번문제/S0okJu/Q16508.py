"""

1. 아이디어 
- 문자 : 개수 형태의 문자 딕셔너리를 만든다. 
- 조합을 사용하여 구매할 책의 문자 딕셔너리를 구한다.
- 가능한 조합 중 최소가격을 구한다. 

2. 시간복잡도 :
- ?? 

3. 자료구조 : 브루트포스

"""
from itertools import combinations

target = input()
n = int(input())

# init books and prices
books = list()
prices = list()
for _ in range(n):
    price, book = input().split()
    prices.append(int(price))    
    books.append({char: book.count(char) for char in set(book)})

# print(books)
def min_cost(books, prices, target):
    n = len(books)
    target_charlist = {ch: target.count(ch) for ch in set(target)}  # 목표 단어의 문자 빈도
    min_cost = float('inf')
    
    
    # 조합 탐색
    # 책은 최소 한개
    for r in range(1, n+1):
        # comb (0,), (1,), (0, 1)
        for comb in combinations(range(n),r): 
            combined = {}
            # print(comb)
            cost = 0
            
            # 선택한 책의 문자 집합과 비용 계산
            for idx in comb:
                cost += prices[idx]
                for ch in books[idx]:
                    # 에러를 위해 책에 데이터가 없다면 0으로 처리 
                    combined[ch] = combined.get(ch, 0) + books[idx][ch]
                    
            
            # 문자열 조합이 가능한지 확인 
            # is_ok = True
            # for ch in target_charlist:
            #     if combined.get(ch,0) < target_charlist[ch]:
            #         is_ok = False
            #         break
                    
            is_ok = all(combined.get(ch, 0) >= target_charlist[ch] for ch in target_charlist)
        
            if is_ok:
                # print(min_cost)
                min_cost = min(min_cost, cost)
            
    return min_cost if min_cost != float('inf') else -1

print(min_cost(books,prices, target))