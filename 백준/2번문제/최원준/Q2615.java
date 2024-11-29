// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    각 격자마다 오른쪽, 아래, 오른쪽아래, 오른쪽위 방향으로 탐색
    방향대로 진행하다가 5번째 돌을 찾으면
    6번쨰에 돌이 있는지, 시작점 전에 돌이있는지(반대방향) 확인
2. 시간복잡도 :
    O( 19 * 19 * 4 * 5 )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2615 {
    static int[][] board = new int[19][19];
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 보드 입력
        for (int i = 0; i < 19; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 보드 탐색
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (board[x][y] != 0) {
                    int focus = board[x][y];

                    for (int i = 0; i < 4; i++) {
                        int cnt = 1;
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        while (nx >= 0 && ny >= 0 && nx < 19 && ny < 19 && board[nx][ny] == focus) {
                            cnt++;

                            if (cnt == 5) {
                                int prevX = x-dx[i];
                                int prevY = y-dy[i];
                                if (prevX >= 0 && prevY >= 0 && prevX < 19 && prevY < 19 && board[prevX][prevY] == focus) {
                                    break;
                                }

                                if (nx + dx[i] >= 0 && ny + dy[i] >= 0 && nx + dx[i] < 19 && ny + dy[i] < 19 && board[nx + dx[i]][ny + dy[i]] == focus) {
                                    break;
                                }

                                System.out.println(focus);
                                System.out.println((x + 1) + " " + (y + 1));
                                return;
                            }
                            nx += dx[i];
                            ny += dy[i];
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}
