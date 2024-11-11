bar_razor = list(input())
answer = 0
st = []

for i in range(len(bar_razor)):
    if bar_razor[i] == '(':
        st.append('(')

    else:
        if bar_razor[i-1] == '(': 
            st.pop()
            answer += len(st)

        else:
            st.pop() 
            answer += 1 

print(answer)

# 1. 아이디어 : stack 잘 몰라서.. 인터넷 찾아가면서 했습니다.
# 아이디어는, i번째 문자가 (이면 스택에 (을 쌓습니다.
# (가 나오면 (을 쌓는 걸 반복합니다.
# )가 나왔는데 이전 것이 (이라면 그것은 레이저입니다. 따라서 바로 이전 스택 문자를 pop으로 지우고, 현재까지 스택 문자 갯수를 answer에 더해줍니다.
# )가 나왔는데 이전 것이 )이라면 바로 이전 스택 문자를 pop으로 지우고 answer에 +1을 해줍니다. 막대 갯수를 더하는 것입니다.

# 2. 시간복잡도 :
# O( )
# 3. 자료구조 :
