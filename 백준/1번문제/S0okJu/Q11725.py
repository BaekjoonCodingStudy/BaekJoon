"""
0. 문제 분석
    i) 루트 없는 트리
    ii) 트리의 루트 = 1
    iii) 입력받을때 순서가 없다.
    iv) 순차적인 인덱스를 가진 노드의 부모 노드를 구해야 한다. 
        -> 리스트의 인덱스를 활용!
    
1. 아이디어 
- 방향성이 없는 트리를 만든 후 하나씩 탐색하여 부모 리스트를 제작한다. 

2. 시간복잡도 :
O(n)
-> 하나 노드 개수만큼 순회하다가 또 순회하고 순회하고를 반복한다. 

3. 자료구조 : Tree

"""

# tree의 1차원 인덱스를 자식 노드로 정하면 되는 것 아닌가?
# 입력 받을때 순서가 랜덤이다. 
# 예외 4 1 -> 표에서는 1이 4보다 Level이 높다. 
def invalid_solution():
    n = int(input())
    tree = [[] for _ in range(n+1)]
    for i in range(n-1):
        a,b = map(int,input().split())
        tree[b].append(a)
    
    for j in range(2,n+1):
        print(tree[j][0])
        
import sys
# 재귀의 최대 깊이
# 없으면 런타임에러(RecursionError)
sys.setrecursionlimit(10**6)

def search(node):
    # 트리의 자식 노드를 모두 탐색 
    for child in tree[node]:
        # 부모 노드 등록 
        if parent_list[child] == 0:
            parent_list[child] = node
            # 자식 노드의 부모 노드를 등록 
            search(child)
        
    
n = int(input())
tree = [[] for _ in range(n+1)]
# 자식 노드의 
parent_list = [0] * (n+1)

# 트리 만들기 
# 방향성이 없으므로 둘 다 정의하자
for i in range(n-1):
    a,b = map(int,input().split())
    tree[b].append(a)
    tree[a].append(b)


search(1)    

for p in range(2,len(parent_list)):
    print(parent_list[p])
    

        