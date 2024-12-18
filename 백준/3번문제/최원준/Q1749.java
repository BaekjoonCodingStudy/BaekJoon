// https://www.acmicpc.net/problem/
package 백준;

/*

1. 아이디어 :
    누적합을 구합니다.
    [x1,y1]부터 [x2,y2]까지의 합을 구하기 위해서는 누적합(grid)에서
    grid[x2][y2] - grid[x1-1][y2] - grid[x2][y1-1] + grid[x1-1][y1-1]을 계합니다.
    x1과 y1 (왼쪽 위 포인트)는 각각 1부터 N, 1부터 M까지 순회하고,
    x2와 y2 (오른쪽 아래 포인트)는 각각 x1부터 x2, y1터 y2까지 순회합니다.
2. 시간복잡도 :
    O( N*N*M*M )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q1749 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0], M = inputs[1];

        int[][] grid = new int[N+1][M+1];

        for (int i=1; i<=N; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j=1; j<=M; j++) {
                grid[i][j] = row[j-1];
            }
        }

        for (int i = 1; i <= N; i++) for (int j = 1; j <= M; j++) {
            grid[i][j] += grid[i - 1][j] + grid[i][j - 1] - grid[i - 1][j - 1];
        }

//        for (var a : grid) System.out.println(Arrays.toString(a));

        int ans = Integer.MIN_VALUE;

        for (int x1 = 1; x1 <= N; x1++) {
            for (int y1 = 1; y1 <= M; y1++) {
                for (int x2 = x1; x2 <= N; x2++) {
                    for (int y2 = y1; y2 <= M; y2++) {
                        int sum = grid[x2][y2]- grid[x1 - 1][y2]- grid[x2][y1 - 1]+ grid[x1 - 1][y1 - 1];
                        ans = Math.max(ans, sum);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
