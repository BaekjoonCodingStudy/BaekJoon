// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    지뢰과 클릭한걸 순회하면서 클릭했고, 지뢰를 만나면 *, 클릭은 하지 않고 지뢰를 만나면 주위 지뢰를 카운트합니다.
2. 시간복잡도 :
    O( 10 * 10 * 9 )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

class Q4396 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static boolean[][] mines;
    static boolean[][] clicks;
    static String[][] board;

    static int N;

    public static String getMines(int x, int y) {
        int count = 0;
        for (int row = x-1; row <= x+1; row++) {
            for (int col = y-1; col <= y+1; col++ ) {
                if (row<0 || row >= N || col <0 || col >= N || (row == x && col == y)) continue;
                if (mines[row][col]) count++;
            }
        }
        return Integer.toString(count);
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        mines = new boolean[N][N];
        for (int i = 0 ; i<N; i++) {
            String input = br.readLine();
            for (int j =0; j<N; j++) {
                mines[i][j] = input.charAt(j) == '*';
            }
        }

        clicks = new boolean[N][N];
        for (int i=0; i<N; i++) {
            String input = br.readLine();
            for (int j=0; j<N; j++) {
                clicks[i][j] = input.charAt(j) == 'x';
            }

        }

        boolean lost = false;

        board = new String[N][N];
        for (int row =0; row<N; row++) {
            for (int col=0; col<N; col++) {
                if (clicks[row][col]) {
                    if (mines[row][col]) {
                        lost = true;
                    } else {
                        board[row][col] = getMines(row, col);
                    }
                }
                if (board[row][col] == null) {
                    board[row][col] = ".";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int row=0; row<N; row++) {
            for (int col = 0; col<N; col++) {
                if (lost && mines[row][col]) {
                    sb.append("*");
                } else {
                    sb.append(board[row][col]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
