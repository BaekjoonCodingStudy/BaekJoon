### DFS

N = int(input())
N = 7
# 1 6
# 6 3
# 3 5
# 4 1
# 2 4
# 4 7

tree = [[] for _ in range(N + 1)]
parent = [None for _ in range(N + 1)]

def DFS(tree, node, visited):
    for i in tree[node]:
        if not visited[i]:
            visited[i] = node
            DFS(tree, i, visited)
            
for _ in range(N - 1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)            

DFS(tree, 1, parent)
        
for i in range(2, N + 1):
<<<<<<< HEAD
    print(parent[i])
=======
    print(parent[i])
>>>>>>> c225520647d99c754b3b71222e94eb9fe2d6dc8b
