"""

1. 아이디어 
- 리스트를 직접 수정하는 것이 아니라 별도의 리스트를 둬 소수임을 확인

2. 시간복잡도 :
O(n)

3. 자료구조 : x

"""

def solution(n, k):
    is_prime = [True] * (n + 1)
    is_prime[0] = False
    is_prime[1] = False
    cnt = 0

    for num in range(2, n + 1):
        # 소수를 발견한 경우
        if is_prime[num]:
            cnt += 1  
            if cnt == k:
                return num

            # 배수 제거
            for j in range(num * num, n + 1, num):
                if is_prime[j]: 
                    is_prime[j] = False
                    cnt += 1  # 배수 제거
                    if cnt == k:
                        return j

            
                    
if __name__ == '__main__':
    n,k = map(int,input().split())      
    res = solution(n,k)
    print(res)