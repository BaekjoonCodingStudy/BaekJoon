// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    길이가 n 일경우, n-1에서 세로 작대기를 하나 추가하거나, n-2에서 가로 작대기를 두개 추가하는 경우의 수를 더합니다.
2. 시간복잡도 :
    O( n )
3. 자료구조 :
    -

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Q11726 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int MOD = 10007;
        int a = 1, b = 2;
        if (n<=2) {
            System.out.println(n);
            return;
        }

        for (int i=0; i<n-2; i++) {
            int temp = a;
            a = b;
            b = (temp + b) % MOD;
        }
        System.out.println(b);
    }
}
