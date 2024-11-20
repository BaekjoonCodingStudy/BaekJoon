# 틀림.
def is_prime(x):
    if x < 2:
        return False
    for i in range(2, int(x**0.5) + 1):
        if x % i == 0:
            return False
    return True

# def is_pal2(n):
#     str_n = str(n)
#     length = len(str_n)
#     half = length // 2 # 몫으로 나눔

#     for i in range(half):
#         if str_n[i] != str_n[length - 1 - i]:
#             return False
#     return True

def is_pal(n):
    strn = str(n)
    return strn == strn[::-1]

n = int(input())
i = n 
while (1):
    if is_prime(i) and is_pal(i):
        print(i)
        break
    i += 1

         