// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    정답 그리드, 입력 그리드를 초기화
    그리드를 순회하면서 X를 만나면 4방향을 확인. 바다가 3개 이상이면 정답그리드에 X 입력
2. 시간복잡도 :
    O( n*m )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q5212 {
    static int N;
    static int M;
    static char[][] grid;
    static char[][] ansGrid;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        grid = new char[N][M];
        ansGrid = new char[N][M];

        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
            Arrays.fill(ansGrid[i], '.');
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (grid[x][y] == 'X') {
                    int seaCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= M || grid[nx][ny] == '.') {
                            seaCount++;
                        }
                    }
                    if (seaCount < 3) {
                        ansGrid[x][y] = 'X';
                    }
                }
            }
        }

        int top = N, bottom = 0, left = M, right = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (ansGrid[x][y] == 'X') {
                    top = Math.min(top, x);
                    bottom = Math.max(bottom, x);
                    left = Math.min(left, y);
                    right = Math.max(right, y);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x = top; x <= bottom; x++) {
            for (int y = left; y <= right; y++) {
                sb.append(ansGrid[x][y]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

