# 풀이 방법 : 딕셔너리로 접근
# dict = {1:피카츄,
#         2:야도라,
#         3:파이리}
# 뭐 이런식으로 dictionary로 만든 후,
# M개, question을 넣었을 때 들어오는 값이 숫자이면 dict[key값] 한 다음에 item인 포켓몬 이름 뱉게 코딩
# 반대로, 들어오는 값이 문자이면 dict[item값] 한 다음에 key값인 숫자를 뱉게 코딩
# 처음에는 위와 같이 했는데 비효율적인지, 시간 문제인지 계~속 오답.. 
# 그래서 찾아보니까 이렇게 하지 말고 아예 딕셔너리를 만들 때,
# dict = {1:피카츄,
#         2:야도라,
#         3:파이리,
#         피카츄:1,
#         야도라:2}
#         파이리:3}
# 이런식으로 다 만들어 버리고 숫자면 item을 피카츄를 뽑고, key값이 문자면 item을 숫자를 뽑는 식으로 코딩함
# 이렇게 하니까 해결됨!


import sys

input = sys.stdin.readline

N, M = map(int, input().split())

my_dict = {}

for i in range(1, N+1):
    a = input().rstrip()
    my_dict[i] = a
    my_dict[a] = i

for i in range(M):
    question = input().rstrip()
    if question.isdigit():
        print(my_dict[int(question)])
    else:
        print(my_dict[question])
