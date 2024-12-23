import sys

input = sys.stdin.readline

matrix = [[0] * 129 for _ in range(129)]
blue = white = 0

def is_same(a, b, size):
    color = matrix[a][b]
    for i in range(a, a + size):
        for j in range(b, b + size):
            if color != matrix[i][j]:
                return False
    return True

def cut(a, b, n):
    global blue, white
    
    if not is_same(a, b, n):
        cut(a + n//2, b + n//2, n//2)
        cut(a, b + n//2, n//2)
        cut(a + n//2, b, n//2)
        cut(a, b, n//2)
    else:
        if matrix[a][b] == 0:
            white += 1
        else:
            blue += 1

def main():
    K = int(input())
    for i in range(K):
        row = list(map(int, input().split()))
        for j in range(K):
            matrix[i][j] = row[j]
            
    cut(0, 0, K)
    print(white)
    print(blue)

if __name__ == "__main__":
    main()