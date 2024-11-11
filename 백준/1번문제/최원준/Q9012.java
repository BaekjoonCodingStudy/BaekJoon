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

class Q9012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() && c == ')') return "NO";

            if (stack.isEmpty() || c == '(') {
                stack.push(c);
            } else {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.size()==0? "YES":"NO";
    }
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            System.out.println(check(br.readLine()));
        }

    }
}


/*

import sys
#sys.setrecursionlimit(1000000)
# input = sys.stdin.readline
input = lambda: sys.stdin.readline().rstrip()

def solution(s):
    stack = []
    for c in s:
        if not stack and c == ")": return "NO";

        if not stack or c == "(":
            stack.append(c)
        else: # )
            if stack[-1] == "(":
                stack.pop()
    return "YES" if len(stack)==0 else "NO"



if __name__ == '__main__':
    n = int(input())
    for i in range(n):
        s = input().strip()
        print(solution(s))

 */