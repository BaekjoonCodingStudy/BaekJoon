// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    소수인지 확인 + 펠린드롬 확인
2. 시간복잡도 :
    O( nlogn * n)
3. 자료구조 :


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Q1747 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static boolean palindrome(int n) {
        String num = String.valueOf(n);
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - 1 - i)) return false;
        }
        return true;
    }

    public static boolean prime(int n) {
        if (n < 2) return false;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = N; i <= Integer.MAX_VALUE; i++) {
            if (prime(i) && palindrome(i)) {
                System.out.println(i);
                break;
            }
        }
    }
}
