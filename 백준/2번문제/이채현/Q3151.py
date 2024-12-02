

############
import sys

sys.setrecursionlimit(10000)
input = sys.stdin.readline

if __name__ == '__main__':

    N = int(input())

    logs = list(map(int, input().strip().split())) # 블로그 시작 1일차부터 N일차까지의 하루 방문자 수

    # if N<=2:
    #     print()
    zero_sum = 0
    for i in range(len(logs)-2):
        for j in range(i+1, len(logs)-1):
            for k in range(j+1, len(logs)):
                # print(f'({logs[i]},{logs[j]},{logs[k]})')
                if sum([logs[i],logs[j],logs[k]]) == 0: zero_sum += 1
    print(zero_sum)
        
# 궁금한 점, 제한은 어떻게 이용하는걸지?
# sys.setrecursionlimit(250000) <- 얘처럼 하면 되는건지?
# 악 이거 diff 이용하면 할 수 있을 거 같은데
# 악 시간초과 각
