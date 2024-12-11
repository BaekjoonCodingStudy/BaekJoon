"""
이분 탐색은 크게 닫힌 구간과 반닫힌 구간으로 구분된다. (탐색 범위 기준)
- 닫힌 구간 [start, end] = 0 ~ len(points)-1
- 반닫힌(반열린) 구간 [start, end) = 0 ~ len(points)

참고 : https://milkclouds.work/why-we-should-use-half-opened-interval-on-binary-search/

"""
n, m = map(int,input().split())
points = list(map(int, input().split()))
points.sort()

# is_end는 조건 중에서 가장 큰 수를 구해야 하기 때문에 
# end를 구할때는 points[mid] == target를 조건을 만족해야 한다.
# 두 번째 케이스인 20 60에서 가장 큰 수인 30를 end_idx로 가리켜야 하지만
# 반복문에 의해 right = mid로 설정되면서 원하는 숫자가 나오지 않게 된다. 
def find_idx(target, is_end=False):
    left, right = 0, len(points)
    # left <= right 로 하면 무한루프가 발생한다.
    # 0 0 
    while left < right:
        # print(left, right) 
        mid = (left + right) // 2
        if points[mid] < target or (is_end and points[mid] == target):
            left = mid + 1
        else:
            right = mid
    return left  


def binary_search(start, end):
    start_idx = find_idx(start)
    end_idx = find_idx(end, is_end=True)  
    print(end_idx - start_idx)

for i in range(m):
    a, b = map(int,input().split())
    binary_search(a,b)
