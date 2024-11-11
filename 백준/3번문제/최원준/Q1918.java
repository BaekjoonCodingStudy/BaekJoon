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
import java.util.*;

class Q1918 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        Map<Character, Integer> operators = new HashMap<>();
        operators.put('(', 0);
        operators.put(')', 0);
        operators.put('+', 1);
        operators.put('-', 1);
        operators.put('*', 2);
        operators.put('/', 2);

        for (var c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                ans.append(c);
            } else if (c == '(') {
                stack.add(c);
            } else if ( c== ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                stack.pop(); // '('
            } else { // + - / *
                while (!stack.isEmpty() && operators.get(stack.peek()) >= operators.get(c)) {
                    ans.append(stack.pop());
                }
                stack.add(c);
            }
        }

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        System.out.println(ans);
    }
}

/*

import sys

# sys.setrecursionlimit(1000000)
# input = sys.stdin.readline
input = lambda: sys.stdin.readline().rstrip()


def solution(s):
    ans = ""
    stack = []
    operators = {"(": 0, ")": 0, "+": 1, "-": 1, "*": 2, "/": 2}

    for c in s:
        if c.isalpha():
            ans += c
        elif c == "(":
            stack.append(c)
        elif c == ")":
            while stack and stack[-1] != "(":
                ans += stack.pop()
            stack.pop()
        else:
            while stack and operators[stack[-1]] >= operators[c]:
                ans += stack.pop()
            stack.append(c)

    while stack:
        ans += stack.pop()

    return ans


if __name__ == '__main__':
    s = input().strip()
    print(solution(s))

 */