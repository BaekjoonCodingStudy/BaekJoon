// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    백트래킹을 통해 값을 추가하거나, 건너뛰거나
2. 시간복잡도 :
    O( 2**N )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q1182 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int S;

    static int ans;
    static int[] nums;

    public static void backtrack(int idx, int total, int count) {
        if (idx == N) {
            if (total == S && count!=0) ans++;
            return;
        }

        backtrack(idx+1, total + nums[idx], count+1);
        backtrack(idx+1, total, count);
    }

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        S = inputs[1];
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] prefixSum = new int[N];
        int sum = 0;
        for (int i=N-1; i>-1; i--) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        backtrack(0, 0, 0);
        System.out.println(ans);
    }
}
