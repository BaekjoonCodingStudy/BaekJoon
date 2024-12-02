// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    구현
2. 시간복잡도 :
    O( N * N )
3. 자료구조 :


 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Q2960 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] inputs;

    public static void main(String[] args) throws IOException {
        inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        Set<Integer> erased = new HashSet<>();
        for (int num=2; num<=N; num++) {
            if (erased.contains(num)) continue;
            for (int multiples = num; multiples <= N; multiples += num) {
                if (erased.contains(multiples)) continue;
                erased.add(multiples);
                K--;
                if (K == 0) {
                    System.out.println(multiples);
                    break;
                }
            }
        }
    }
}
