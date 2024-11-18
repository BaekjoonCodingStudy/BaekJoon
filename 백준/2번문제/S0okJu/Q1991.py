"""
0. 문제 분석
    i) N(1 ≤ N ≤ 26)
    ii) A부터 순서대로 알파벳 대문자로 매겨진다. -> 26 : 알파벳 숫자
    iii) 루트, 왼쪽, 오른쪽 순서대로 입력받는다. -> 2진 트리 
    iv) A는 항상 루트 노드 
      
1. 아이디어 
- 전위 순회 : [중] - 왼 - 오
- 중위 : 왼 - [중] - 오 
- 후위 : 왼 - 오 - [중] 

2. 시간복잡도 :
O(n)

3. 자료구조 : Tree

"""

def preorder(node):
    if node == '.':  
        return
    
    print(node, end='') # 중심 
    if tree[node][0] != '.': 
        preorder(tree[node][0]) # 왼 
    if tree[node][1] != '.': 
        preorder(tree[node][1]) # 오
        
def inorder(node):
    if node == '.':
        return 
    
    if tree[node][0] != '.':
        inorder(tree[node][0])
    print(node, end='')
    if tree[node][1] != '.':
        inorder(tree[node][1])
    

def postorder(node):
    if node == '.':  
        return
    if tree[node][0] != '.': 
        postorder(tree[node][0]) # 왼 
    if tree[node][1] != '.': 
        postorder(tree[node][1]) # 오
    print(node, end='') # 중심 

if __name__ == '__main__':
    tree = {}
    n = int(input())
    
    for _ in range(n):
        a,b,c = input().split()
        # 2진 트리이기 때문에 (왼쪽, 오른쪽) 튜플로 사용했다. 
        # 메모리 사용량 측면에서 리스트보다 튜플이 더 효율적(변경 불가능한 값)
        tree[a] = (b,c) 
    
    # 항상 A가 루트 노드가 된다. 
    preorder('A')
    print()
    inorder('A')
    print()
    postorder('A')
    print()


    
    
        
