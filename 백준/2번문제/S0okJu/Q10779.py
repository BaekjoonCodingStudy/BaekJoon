"""

1. 아이디어 


2. 시간복잡도 :
O( )
3. 자료구조 : Stack

"""

def solution(stick):
    
    # Rader의 조건
    # 이전 명령어가 ( 이면서 현재 명령어가 )인 경우 
    stack = list()
    before = ""
    result = 0 
    for i in range(len(stick)):
        s = stick[i]
        # 아무것도 없는 경우 
        if len(stack) == 0:
            stack.append(s)
            before = s
            continue
        
        # 스틱인 경우
        # 스틱인 경우에는 스택에 있는 ( 길이만큼 모두 더해준다.
        if before == "(" and s == ")":
            stack.pop()
            result += len(stack)
            print(result)
            before = s 
            continue
            
        if s == "(":
            stack.append("(")
        else:
            stack.pop()
        before = s
    print(result)
            
            

if __name__ == '__main__':
    stick = input()
    solution(stick)