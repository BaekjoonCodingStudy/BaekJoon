// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    밧줄을 기준으로 내림차순.
    각 밧줄마다 그 전 밧줄까지 포함하여 평균을 계산
2. 시간복잡도 :
    O( nlogn )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Q2217 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> ropes = new ArrayList<>();
        for (int i=0; i<n; i++) {
            ropes.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(ropes, (a,b) -> {
            return b-a;
        });

        int ans = 0;
        for (int i=0; i<n; i++) {
            ans = Math.max(ans, ropes.get(i) * (i+1));
        }
        System.out.println(ans);
    }
}

/*
import sys
input = lambda: sys.stdin.readline().rstrip()

def solution(n, ropes):
    return max([ropes[i] * (i+1) for i in range(len(ropes))])

if __name__ == '__main__':
    n = int(input())
    ropes = sorted([int(input()) for _ in range(n)], key=lambda x: -x)
    print(solution(n, ropes))
 */
