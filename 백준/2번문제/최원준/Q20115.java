// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    가장 용량이 적은걸 가장 용량이 많은 곳에 부우면 됩니다.
2. 시간복잡도 :
    O( nlogn )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q20115 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] drinks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(drinks);

        double ans = drinks[drinks.length-1];
        for (int i=0; i<n-1; i++) {
            ans += (double)drinks[i]/2;
        }
        System.out.println(ans);


    }
}

/*
import sys
#sys.setrecursionlimit(1000000)
# input = sys.stdin.readline
input = lambda: sys.stdin.readline().rstrip()

def solution(n, drinks):
    total = drinks[-1]
    for i in range(len(drinks)-1):
        total += drinks[i]/2
    return total



if __name__ == '__main__':
    n = int(input())
    drinks = sorted(list(map(int, input().split())))
    print(solution(n, drinks))
 */