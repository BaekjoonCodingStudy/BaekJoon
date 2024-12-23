// https://www.acmicpc.net/problem/
package 백준;

/*

1. 아이디어 :
    재귀를 사용해서 풀 수 있습니다.
    재귀를 통해, 왼쪽위, 오른쪽위, 왼쪽아래, 오른쪽아래를 순회합니다.
2. 시간복잡도 :
    O( N*N*logN )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q2630 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] ans = new int[2];
    static int[][] board;
    static int N;

    public static boolean check(int row1, int col1, int row2, int col2) {
        int base = board[row1][col1];
        for (int row = row1; row<row2; row++) for (int col=col1; col<col2; col++) {
            if (board[row][col] != base) return false;
        }
        return true;
    }

    public static void dfs(int row1, int col1, int row2, int col2) {
        if (check(row1, col1, row2, col2)) {
            ans[board[row1][col1]]++;
            return;
        }
        int half = (row2-row1)/2;

        dfs(row1, col1, row1+half, col1+half);
        dfs(row1+half, col1, row2, col1+half);
        dfs(row1, col1+half, row1+half, col2);
        dfs(row1+half, col1+half, row2, col2);
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i=0; i<N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dfs(0,0,N,N);
        System.out.println(ans[0]);
        System.out.println(ans[1]);

    }
}
