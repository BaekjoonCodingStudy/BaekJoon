# 양을 최대호 하기 위해서는 버리는 음료의 양이 최소가 되어야 한다!
# 따라서 적은 음료부터 차례대로 정렬하여 가장 큰 음료에 합치면 된다.

N = int(input())
drink_list = list(map(int, input().split())) # 둘째줄에 들어오는 음료들을 나눠 받아야 한다.
drink_list.sort() # 얘도 마찬가지로 sort 이용 -> 이게 핵심 같음.

combined = drink_list[-1] # drink_list 중에서 가장 용량?이 큰 음료에 합쳐야 한다.

for i in range(N-1):
    combined += drink_list[i]/2 # 가장 용량 큰 음료에다가 작은 것들을 half씩 담는다.

print(combined)
