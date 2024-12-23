// https://www.acmicpc.net/problem/
package 백준;

/*

1. 아이디어 :
    누적합(prefixSum)을 만듭니다.
    2번째(i=1) 부터 시작하여 i-1번째 악보보다 난이도가 크거나 같으면 그 전 prefixSum[i-1]값을, 아니면 +1을 추가로 더합니다.
    구간 s와 e에 대해서, e-s를 구합니다. (s-1을 하지 않는 이유는 s부터 e까지의 하락을 구하기 때문. [s+1, e])
2. 시간복잡도 :
    O( N * Q )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q21318 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] diffs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int Q = Integer.parseInt(br.readLine());

        int[] prefixSum = new int[N];
        for (int i=1; i<N; i++) prefixSum[i] = prefixSum[i-1] + (diffs[i-1] > diffs[i]? 1: 0);
        System.out.println(Arrays.toString(prefixSum));

        StringBuilder sb = new StringBuilder();
        for (int q=0; q<Q; q++) {
            int[] interval = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int s = interval[0]-1, e= interval[1]-1;
            sb.append(prefixSum[e] - prefixSum[s]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
