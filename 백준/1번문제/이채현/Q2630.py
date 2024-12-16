import sys

input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

blue_count = 0
white_count = 0 

def split(arr, N):
    global blue_count #?
    global white_count
    check = 0 # 색종이 만들어지는지 먼저 check
    for i in range(N):
        check += sum(arr[i])
    if check == 0:
        white_count += 1
    elif check == N*N:
        blue_count += 1
    else:
        tmp = [row[:N//2] for row in arr[:N//2]]
        split(tmp, N//2)
        tmp = [row[N//2:] for row in arr[:N//2]]
        split(tmp, N//2)
        tmp = [row[:N//2] for row in arr[N//2:]]
        split(tmp, N//2)
        tmp = [row[N//2:] for row in arr[N//2:]]
        split(tmp, N//2)
            
split(arr, N)
print(white_count)
print(blue_count)
    