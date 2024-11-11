// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :

2. 시간복잡도 :
O( )
3. 자료구조 :


 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Bracket {
    int idx;
    char val;

    public Bracket(int idx, char val) {
        this.idx = idx;
        this.val = val;
    }
}

class Q10799 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        Stack<Bracket> stack = new Stack<>();
        int total = 0;
        int size = 0;


        for (int i=0; i<s.length(); i++) {
            char val = s.charAt(i);
            if (stack.isEmpty() || val == '(') {
                stack.push(new Bracket(i, val));
                size ++;
            } else {
                size-=1;
                total += i - stack.peek().idx == 1? size : 1;
                stack.pop();
            }
        }
        System.out.println(total);
    }
}

/*

import sys
#sys.setrecursionlimit(1000000)
# input = sys.stdin.readline
input = lambda: sys.stdin.readline().rstrip()

def solution(s):
    stack = []
    total, size = 0, 0

    for i, val in enumerate(s):
        if not stack or val == "(":
            stack.append([i, val]) # idx, value
            size+=1
        else:
            size-=1
            total += size if i - stack[-1][0] == 1 else 1
            stack.pop()

    return total



if __name__ == '__main__':
    s = input().strip()
    print(solution(s))

 */