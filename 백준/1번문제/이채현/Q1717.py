"""
시간 복잡도 : 연산의 수 m, 노드의 수 n.. 각 연산은 alpha(n) 시간에 처리된다
따라서 총 복잡도는 O((n+m)alpha(n))
"""

import sys
input = sys.stdin.readline



# if __name__ == '__main__':
#     answer = list()
#     n, m = map(int, input().split())
#     set_list = [[i] for i in range(n+1)]
#     for _ in range(m):
#         c, a, b = map(int, input().split())
#         if c == 0 and a==b:
#             next
#         elif c == 0 and a!=b:
#             set_list[a].append(b)
#             set_list[b].append(a)
#         elif c == 1 and a==b:
#             answer.append('yes')
#         elif c == 1 and a!=b:
#             if b in set_list[a]:  # a는 지 index니까 포함돼 있겠지
#                 answer.append("yes")
#             else:
#                 answer.append("no")
#     for _ in answer:
#         print(_)

# if __name__ == '__main__':
#     n, m = map(int, input().split())
#     set_list = [[i] for i in range(n+1)]
#     for _ in range(m):
#         c, a, b = map(int, input().split())
#         if c==1:
#             if a==b or (b in set_list[a]) or (a in set_list[b]):
#                 print('yes')
#             else:
#                 print('no')
#         else:
#             set_list[a].append(b)
#             # set_list[b].append(a)


# 강의에서 봤던 union-find 알고리즘으로 해결..

sys.setrecursionlimit(100_000) # 재귀함수 무한루프 빠질 수 있다.

def find(a):
    if a == p[a]:
        return a
    p[a] = find(p[a])
    return p[a]
def union(a,b):
    x,y = find(a), find(b)
    if x>y:
        p[x] = y
    elif x<y:
        p[x] =y


if __name__ == '__main__':      
    n, m = map(int, input().split())
    p = [i for i in range(n+1)]
    for _ in range(m):
        c, a, b = map(int, input().split())
        if c==1: # a b 같은지 check 같으면 yes 출력
            if find(a) == find(b):
                print('yes')
            else:
                print('no')
        else:
            union(a,b)
