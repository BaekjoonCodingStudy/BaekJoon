// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    bfs를 사용해서 풀 수 있습니다.
2. 시간복잡도 :
    O( n*m )
3. 자료구조 :
    배열

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q14940 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int[][] grid;

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};


    public static void bfs(int row, int col) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{row, col, 1});
        grid[row][col] = 0;
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0], cy = curr[1], cv = curr[2];

            for (int i=0; i<4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i], nv = cv +1;
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || grid[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                grid[nx][ny] = cv;
                queue.offer(new int[]{nx, ny, nv});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt((Integer::parseInt)).toArray();
        N = inputs[0];
        M = inputs[1];
        grid = new int[N][M];
        int startX = -1, startY = -1;
        for (int i = 0; i < N; i++) {
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt((Integer::parseInt)).toArray();
            for (int j =0; j<M; j++) {
                grid[i][j] = -inputs[j];
                if (inputs[j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        StringBuilder sb;
        for (int row = 0; row < N; row++) {
            sb = new StringBuilder();
            sb.append(grid[row][0]);
            for (int col = 1; col < M; col++) {
                sb.append(" ");
                sb.append( grid[row][col] >= 0 ? grid[row][col] : -1);
            }
            System.out.println(sb.toString());
        }
    }
}
