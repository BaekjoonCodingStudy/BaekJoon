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
#             if T_decompose[i] in list(alphabet[j]): # list 대신 set을 사용
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
    total_chars = {} # 각 문자가 책들의 제목에서 몇 번 나타나는지 # defaultdict
    for i in books: # 책 리스트 books를 순회
        for j in i[1]:
            if j in total_chars: # 문자 출현 횟수를 total_chars에 기록
                total_chars[j] += 1
            else:
                total_chars[j] = 1
    
    for j in letter: # 주어진 문자열 T의 각 문자를 확인
        if j not in total_chars or total_chars[j] == 0: # 만약 j가 total_chars가 없거나 해당 문자의 카운트가 0이면
            return False # 해당 조합으로는 T를 만들 수 없으므로 False를 반환
        total_chars[j] -= 1 # 그리고 문자 j의 출현 가능 횟수를 줄임.
    return True # 모든 문자에 대해 충분한 출현 횟수 있으면 True 반환. 이 조합으로 T 생성 가능
# logic 중복 -> 줄이기        
book = ['computer architecture']        
T = ['ant']        

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
                if cost < min_cost: # min cost를
                    min_cost = cost
    
    if min_cost == float('inf'): # 적절한 조합을 찾지 못했기 때문에..
        print(-1)
    else:
        print(min_cost)
        

# 주어진 N개의 책에서 1부터 N까지 모든 조합 고려
# 2^N -1
# 따라서 시간 복잡도는 O(2^N)
# 만들어진 각 조합에 대해 문자열 T를 구성할 수 있는지 확인
# T의 길이를 M이라고 하면 문자에 대해 책의 모든 문자를 확인해야 하므로,
# O(MN)이다
# 최악의 경우 시간 복잡도는 O(2^N x MN)이 된다.
