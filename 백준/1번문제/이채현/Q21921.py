
import sys

sys.setrecursionlimit(250000)
input = sys.stdin.readline

if __name__ == '__main__':

    N, X = map(int, input().split())

    logs = list(map(int, input().strip().split())) # 블로그 시작 1일차부터 N일차까지의 하루 방문자 수

    arr_sum = []
    for i in range(len(logs)):
        arr_sum.append(sum(logs[i:i+X]))
        if i+X > len(logs): break
    
    # if max(arr_sum) == 0: 
    #     print("SAD")
    # else: 
    #     print(max(arr_sum))
    #     print(len([i for i, j in enumerate(arr_sum) if j == max(arr_sum)]))
    if max(arr_sum) == 0: 
        print("SAD")
    else:
        j = 0
        print(max(arr_sum))
        for i in arr_sum:
            if i == max(arr_sum): j+=1
        print(j)
        
# 악 시간초과 악
