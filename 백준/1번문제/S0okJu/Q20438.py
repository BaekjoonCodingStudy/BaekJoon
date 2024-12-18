
# n, k, q, m = map(int,input().split())
# sleeping_students = list(map(int,input().split()))
# received_studnets = list(map(int,input().split()))
# a, b = map(int,input().split())

# is_absent = [(False,False) for _ in range(n + 3)] 

# # 출석 불가능 total
# # 출석이 가능할 경우 1씩 뺀다. 
# absent_total = (b-a) + 1

# # 잠자고 있는 학생
# for s in sleeping_students:
#     is_absent[s] = (False,True)


# # 출석 
# for r in received_studnets:
#     for j in range(r,b+1,r):
#         if is_absent[j][0] == False and is_absent[j][1] == False:
#             is_absent[j] = (True, False)
#             absent_total -= 1

# print(absent_total)
            
            
# 입력
N, K, Q, M = map(int, input().split())
sleeping_students = list(map(int, input().split()))
received_students = list(map(int, input().split()))
ranges = [tuple(map(int, input().split())) for _ in range(M)]

# 초기화
max_student = N + 2
attendance = [0] * (max_student + 1)

# 졸고 있는 학생 처리
for student in sleeping_students:
    attendance[student] = -1  # 잠자는 학생은 출석 불가

# 출석 처리
for student in received_students:
    for i in range(student, max_student + 1, student):
        if attendance[i] != -1:  # 잠자는 학생은 제외
            attendance[i] = 1  # 출석 처리

# 누적 합 계산
prefix_sum = [0] * (max_student + 1)
for i in range(3, max_student + 1):
    prefix_sum[i] = prefix_sum[i - 1] + (1 if attendance[i] == 1 else 0)

# print(prefix_sum)

# 구간 처리 및 출력
results = []
for S, E in ranges:
    total_students = E - S + 1
    present_students = prefix_sum[E] - prefix_sum[S]
    # print(f"{S} {E} {prefix_sum[E]}, {prefix_sum[S]}, {total_students - present_students}")
    results.append(total_students - present_students)

print("\n".join(map(str, results)))
