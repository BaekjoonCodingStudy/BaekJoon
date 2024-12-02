// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    BFS를 사용해서 풀었습니다.
    GRAM이 있을때와 없을떄를 나눠서 방문을 기록합니다.
2. 시간복잡도 :
    O( n*m )
3. 자료구조 :
    배열

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Q17836 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0], M = inputs[1], T = inputs[2];

        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};


        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0}); //row, col, distance, GRAM

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0], cy = curr[1], cd = curr[2], GRAM = curr[3];

            if (cx == N-1 && cy == M-1) {
                System.out.println(cd);
                return;
            }

            for (int i=0; i<4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i], nd = cd + 1;
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;


                if (GRAM == 0 && grid[nx][ny] != 1 && !visited[nx][ny][0] && cd <= T) {
                    visited[nx][ny][0] = true;
                    queue.offer(new int[]{nx, ny, nd, grid[nx][ny] == 2 ? 1 : 0});
                }
                if (GRAM == 1 && !visited[nx][ny][1] && cd <= T) {
                    visited[nx][ny][1] = true;
                    queue.offer(new int[]{nx, ny, nd, GRAM});
                }
            }
        }
        System.out.println("Fail");
    }
}
