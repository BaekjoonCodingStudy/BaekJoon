def solution():
    n, m = map(int, input().split())
    lands = [[0 for _ in range(m+1)] for _ in range(n+1)]
    
    for idx in range(1, n+1):
        row = list(map(int, input().split()))
        for j in range(1, m+1):
            lands[idx][j] = row[j-1]

    
    # Create metrix
    calculated = [[0 for _ in range(m+1)] for _ in range(n+1)]
    for x in range(1,n+1):
        for y in range(1,m+1):
            # (x,y) - (x-1,y) - (x,y-1) + (x-1,y-1)
            calculated[x][y] = lands[x][y]+calculated[x-1][y] + calculated[x][y-1] - calculated[x-1][y-1]
                
    k = int(input())
    for _ in range(k):
        # (a,b) (x,y)
        inputs = list(map(int,input().split()))
        print(f"calculated[inputs[2]][inputs[3]]: {calculated[inputs[2]][inputs[3]]}")
        print(f"- calculated[inputs[0]][inputs[3]]: {-calculated[inputs[0]][inputs[3]]}")
        print(f"- calculated[inputs[2]][inputs[1]]: {-calculated[inputs[2]][inputs[1]]}")
        print(f"+ calculated[inputs[0]][inputs[1]]: {calculated[inputs[0]][inputs[1]]}")
        if inputs[0] == 1 and inputs[1] == 1:
            res = calculated[inputs[2]][inputs[3]]
        # (x,y) - (a,y) - (x,b) + (a,b)
        else:
            res = calculated[inputs[2]][inputs[3]] - calculated[inputs[0]][inputs[3]] - calculated[inputs[2]][inputs[1]] + calculated[inputs[0]][inputs[1]]
        print(res)

if __name__ == '__main__':
    solution()