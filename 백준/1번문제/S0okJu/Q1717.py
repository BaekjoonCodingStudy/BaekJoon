"""
아이디어
- Union - Find : 두 그룹을 합치거나, 특정 그룹을 찾는 등의 연산을 수행할 때 사용된다.

시간 복잡도 
- O(n)
"""
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

# 그룹의 루트 노드를 찾는다. 
def find(a):
    if a == parent[a]:
        return a
    parent[a] = find(parent[a])
    return parent[a]
# 그룹을 합친다.
# y의 루트 노드를 x 로 합치는 작업을 수행한다.
def union(a,b):
    x, y = find(a), find(b)
    if x < y:
        parent[y] = x
    else:
        parent[x] = y


n, m = map(int,input().split())
parent = [i for i in range(n+1)]

for i in range(m):
    op, a, b = map(int,input().split())
    if op == 1:
        if find(a) == find(b):
            print('YES')
        else:
            print('NO')
    else:
        union(a,b)