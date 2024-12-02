// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    bfs를 사용해서 풀 수 있습니다.
    x, y를 순회하면서 1을 만나면 bfs를 통해 모두 0으로 바꿉니다.
2. 시간복잡도 :
    O( n*m )
3. 자료구조 :
    배열

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Q2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] grid;
    static int groups = 0;
    static ArrayList<Integer> sizes = new ArrayList<>();

    static int[][] dirs = new int[][]{ {1,0}, {-1,0}, {0,1}, {0,-1}};

    public static void bfs(int row, int col) {
        groups++;
        int count = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        grid[row][col] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0], cy = curr[1];

            for (int[] dir : dirs) {
                int nx = cx + dir[0], ny = cy + dir[1];
                if (nx <0 || nx >= N || ny<0 || ny >= N || grid[nx][ny] == 0)  continue;
                grid[nx][ny] = 0;
                count++;
                queue.offer(new int[]{nx, ny});
            }
        }
        sizes.add(count);
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            for (int j=0; j<N; j++) {
                grid[i][j] = Integer.parseInt(input.charAt(j)+"");
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (grid[i][j] == 1) {
                    bfs(i,j);
                }
            }
        }
        Collections.sort(sizes);
        System.out.println(groups);
        for (int size : sizes) System.out.println(size);
    }
}
