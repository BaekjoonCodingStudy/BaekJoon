"""

1. 아이디어 : 
2. 시간복잡도 :
3. 자료구조 : math

"""
import sys

def is_prime_num(n):
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

def print_multiples(n, x):
    for i in range(x, n + 1, x):
        print(i)



# 소수 출력    
def is_prime_num(n):
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

# 2,8 이면 2,4,6 출력
def print_multiples(n, x):
    tmp = list()
    for i in range(x, n + 1, x):
        tmp.append(i)
    return tmp

                
if __name__ == '__main__':
    input = sys.stdin.readline
    
    N, K = map(int, input().split())
    
    # 주어진 수로 list 만듦
    my_list = [i for i in range(2,N+1)]

    # 그 중에서 소수만 담음
    _ = list()

    for i in my_list:
        if is_prime_num(i):
            _.append(i)
    
    # 소수에서 작은 수부터 배수 만들어서 my_list에서 지움
    i = 0
    while i < 1000:
        for num in _:
            i += 1
            tmp = print_multiples(N,num)
            for k in tmp:
                try: 
                    my_list.remove(k)
                except: 
                    pass
                if i == K: 
                    print(k)
                    break

