import math
n = int(input())

def is_prime_num(n):
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

def isPalindrome(x):
    xs = str(x)
    xsr = xs[::-1]
    if xs == xsr:
        return True
    else:
        return False

start = n
while True:
    if isPalindrome(start) and is_prime_num(start):
        print(start)
        break
    else:
        start+=1
