import sys

input = sys.stdin.readline

def timeout():
    n, m = map(int, input().split())
    poks = list()
    
    for i in range(n):
        pok = input()
        poks.append(pok)
    
    collections = set()
    for i in range(len(poks)):
        if poks[i] not in collections:
            collections.add((str(i+1),poks[i]))
            

    for j in range(m):
        quiz = input()
        for item in collections:
            if item[0] == quiz:
                print(item[1])
            elif item[1] == quiz:
                print(item[0])

"""

1. 아이디어 
- 키를 통해 값을 알아야 하고 값을 통해 키를 알아야 한다.
- 딕셔너리 하나로는 구현하기 어려울 것이라고 생각했다.

2. 시간복잡도 :
O( )
3. 자료구조 :

"""


def solution():
    n, m = map(int, input().split())
    pokemons = {}  
    
    for i in range(1, n + 1):
        pok = input().strip()
        pokemons[str(i)] = pok  
        pokemons[pok] = str(i)  

    for _ in range(m):
        quiz = input().strip()
        
        print(pokemons[quiz])
if __name__ == '__main__':
    solution()
