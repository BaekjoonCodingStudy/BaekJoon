import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def find(a):
    if a == parts[a]:
        return a
    parts[a] = find(parts[a])
    return parts[a]

def union(a,b):
    x, y = find(a), find(b)
    if x < y:
        parts[y] = x
    else:
        parts[x] = y

def find_counts(a):
    count = 0
    for part in parts:
        if part == a:
            count += 1
    
    return count


n = int(input())
parts = [i for i in range(n+1)]

for _ in range(n):  
    line = input().split() 
    
    query_type = line[0] 
    
    if query_type == 'I':
        a = int(line[1])
        b = int(line[2])
        union(a,b)
        
    else:
        a = int(line[1])
        count = find_counts(a)
        print(count)
    
