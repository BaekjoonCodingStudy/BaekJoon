from itertools import permutations
import sys
input = sys.stdin.readline


n = int(input())
4
k = int(input())
2

arr = []
for _ in range(n):
    arr.append(int(input()))
1
2
12
1
list(permutations(arr, 2))

tmp_list = []
for tmp in list(permutations(arr, k)):
    tmp_list.append(''.join(map(str, tmp)))

print(len(set(tmp_list)))