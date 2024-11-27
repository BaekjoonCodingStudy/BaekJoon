// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    슬라이딩 윈도우를 사용합니다.
    left와 left + X 구간의 합 중 최대값
    윈도우를 옮길때마다 left값을 빼고, left+X값을 더합니다.
2. 시간복잡도 :
    O( n )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

class Q21921 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = inputs[0], X = inputs[1];
        int[] visitors = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        HashMap<Integer, Integer> counter = new HashMap<>();
        int total = 0;
        for (int right = 0; right<X; right++) {
            total += visitors[right];
        }

        int cmax = total;
        counter.put(cmax, 1);
        for (int left=0; left<N-X; left++) {
            total += visitors[left+X] - visitors[left];
            cmax = Math.max(cmax, total);
            counter.put(total, counter.getOrDefault(total, 0)+1);
        }

        if (cmax == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(cmax);
            System.out.println(counter.get(cmax));
        }
    }
}
