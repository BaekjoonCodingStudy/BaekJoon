# 틀림.
def is_prime(x):
    if x < 2:
        return False
    for i in range(2, int(x**0.5) + 1):
        if x % i == 0:
            return False
    return True

def is_pal(n):
    str_n = str(n)
    length = len(str_n)
    half = length // 2 # 몫으로 나눔

    for i in range(half):
        if str_n[i] != str_n[length - 1 - i]:
            return False
    return True

def solution(n):
    for i in range(n, 1000001):
        if is_prime(i) and is_pal(i):
                return i 

if __name__ == '__main__':
    n = int(input())
    res = solution(n)
    print(res)
                      