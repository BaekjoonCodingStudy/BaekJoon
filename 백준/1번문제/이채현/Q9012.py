T = int(input())

for _ in range(T):
    x = input()
    while '()' in x:
        x = x.replace('()','')
    if x == '':
        print("YES")
    else:
        print("NO")

# 1. 아이디어 : ()를 없애다보면 만약 (이나 )이 남으면 NO일테고, 남은게 없으면 YES를 출력하도록 하였습니다.

# 2. 시간복잡도 :
# O( )
# 3. 자료구조 :
