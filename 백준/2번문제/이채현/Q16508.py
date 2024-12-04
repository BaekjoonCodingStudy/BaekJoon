# # 35000 COMPUTERARCHITECTURE
# # 47000 ALGORITHM
# # 43000 NETWORK
# # 40000 OPERATINGSYSTEM

      
        

# if __name__ == '__main__':
#     T = input().strip()
#     # ANT
#     N = int(input())
#     # 4
#     T_decompose = list(T)
#     # \n 때메 에러 날 수도..

#     # price = [0 for i in range(N)]
#     price = []
#     alphabet = []
#     for _ in range(N):
#         line = input().strip().split()
#         C, W = line[0], line[1]
#         price.append(int(C))
#         alphabet.append(str(W))
    
#     my_dict = {key: [] for key in range(len(T_decompose))}
#     for i in range(len(T_decompose)):
#         for j in range(N):
#             if T_decompose[i] in list(alphabet[j]):
#                 my_dict[i].append(price[j])
#     if any(len(values) == 0 for values in my_dict.values()):
#         print(-1)
#     else:
#         arr = []
#         for combination in itertools.product(*my_dict.values()):
#             arr.append(sum(combination))     
#         print(min(arr))
        

import itertools
import sys
input = sys.stdin.readline



# 35000 COMPUTERARCHITECTURE
# 47000 ALGORITHM
# 43000 NETWORK
# 40000 OPERATINGSYSTEM

      
def check_character(letter, books):
    # 모든 책의 문자들을 사용하여 문자열을 형성할 수 있는지 확인
    total_chars = {}
    for i in books:
        for j in i[1]:
            if j in total_chars:
                total_chars[j] += 1
            else:
                total_chars[j] = 1
    
    for j in letter:
        if j not in total_chars or total_chars[j] == 0:
            return False
        total_chars[j] -= 1
    return True
        
        
        

if __name__ == '__main__':
    T = input().strip() 
    N = int(input())  
    books = []
    
    for _ in range(N):
        line = input().strip().split()
        C, W = int(line[0]), line[1]
        books.append((C, W))
    
    min_cost = float('inf')

    for r in range(1, N+1):
        for subset in itertools.combinations(books, r):
            if check_character(T, subset):
                cost = sum(book[0] for book in subset)
                if cost < min_cost:
                    min_cost = cost
    
    if min_cost == float('inf'):
        print(-1)
    else:
        print(min_cost)
        

