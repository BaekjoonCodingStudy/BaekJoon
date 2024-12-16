
import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline



def sumOfMatrix(N, M, mat):
    # Initialize sum = 0 to store sum 
    # of each element
    Sum = 0
 
    # Traverse in each row
    for i in range(N):
        # Traverse in column of that row
        for j in range(M):
 
            # Add element in variable sum
            Sum += mat[i][j]
 
    # Return sum of matrix
    return Sum

if __name__ == '__main__':
    N, M = map(int, input().split())
    
    arr = []
    for _ in range(N):
        arr.append([int(i) for i in input().split()])
    
    K = int(input())
    for __ in range(K):
        emp, ty, yi, yj = map(int, input().split())
        print(sumOfMatrix(yi, yj, arr))
        
        
# O(n*m*k)
# # 누적합 how??
