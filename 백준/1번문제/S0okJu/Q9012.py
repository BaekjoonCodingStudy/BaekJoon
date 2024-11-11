"""

1. 아이디어 : 스택에는 ( 만 들어가야 하며 완성된 VPS에는 남아있는 (가 없어야 한다.

2. 시간복잡도 :
O(n^2)
3. 자료구조 : Stack

"""

def solution(ps):
    stack = []
    for j in range(len(ps)):
        if ps[j] == '(':
            stack.append('(')
        elif ps[j] == ')':
            if len(stack) != 0:
                stack.pop()
            else:
                return False
                
    
    if len(stack) > 0:
        return False
    else:
        return True
                
                
if __name__ == '__main__':
    t = int(input())
    for i in range(t):
        ps = input()
        if (solution(ps)==False):
            print("NO")
        else:
            print("YES")
    