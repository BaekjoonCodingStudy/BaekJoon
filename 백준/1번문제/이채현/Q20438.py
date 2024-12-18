"""
1.시간복잡도 : O(N)
2.아이디어
3.자료구조 : 

"""

import sys

input = sys.stdin.readline

# N 학생 수
# K 졸고 있는 학생 수
# Q 출석 코드 보낼 학생 수
# M 주어질 구간
# 2번쨰줄 K명의 졸고있는 학생 번호
# Q명의 출석코드 받을 학생 번호
# 다음번째 줄은 구간
# 특정 구간에서 출석되지 않은 학생 수

if __name__ == '__main__':
    N, K, Q, M = map(int, input().split())
    sleep = list(map(int, input().split()))
    check = list(map(int, input().split()))    
    switch = [0] + [0,0] +[1 for _ in range(N)]
    for value in sleep:
        if value in check:
            check.remove(value)
    i=0
    while i < len(check):
        # print('i : ', i)
        for _ in range(3, N+2+1):
            # print('_ : ',_)
            if _%check[i] == 0:
                switch[_] = 0
                # print('switch : ', switch)
        i += 1
    prefix = [0] + [0 for _ in range(N+2)]
    for i in range(len(switch)):
        prefix[i] = prefix[i-1] + switch[i]
    # students = 0
    for _ in range(M):
        left, right = map(int, input().split())
        # print('left : ', left)
        # print('right : ', right)
        student = prefix[right] - prefix[left-1]
    print(student)


if __name__ == '__main__':
    N, K, Q, M = map(int, input().split())
    # sleep = list(map(int, input().split()))
    sleep = list(map(int, input().split()))
    check = list(map(int, input().split()))    
    # switch = [1] + [1,1] +[1 for _ in range(N)]
    switch = [1] *(N+3)
    for num in sleep:
        if num <= N+2:
            for i in range(num, N+3, num):
                switch[i] = 0
    for num in check:
        if num <= N+2 and switch[num]:
            for i in range(num, N+3, num):
                if i not in sleep:
                    switch[i] = 0
    prefix = [0] * (N+3)
    for i in range(1, N+3):
        prefix[i] = prefix[i-1] + (switch[i] if i>=3 else 0)
    students = 0
    for _ in range(M):
        left, right = map(int, input().split())
        students += prefix[right] - prefix[left-1]
    print(students)