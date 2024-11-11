T = int(input())

for _ in range(T):
    x = input()
    while '()' in x:
        x = x.replace('()','')
    if x == '':
        print("YES")
    else:
        print("NO")
