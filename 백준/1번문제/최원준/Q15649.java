// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    백트래킹 사용
2. 시간복잡도 :
    O( nPm )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q15649 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static List<List<Integer>> ansList = new ArrayList<>();
    static boolean[] visited;
    static int[] ans;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void backtrack(int depth) {
        if (depth == M) {
            for (int i=0; i<M; i++) sb.append(ans[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i=1; i<=N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            ans[depth] = i;
            backtrack(depth+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        M = inputs[1];
        visited = new boolean[N+1];
        ans = new int[M];
        backtrack(0);
        System.out.println(sb.toString());
    }
}
