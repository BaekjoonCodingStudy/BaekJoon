// https://www.acmicpc.net/problem/
package 백준;

/*
1. 아이디어 :
    재귀를 통해 풀 수 있습니다.
    왼쪽위, 오른쪽위, 왼쪽아래, 오른쪽 아래를 순회합니다.
    모든 격자를 방문하게되면 시간초과가 발생해서, 방문하지 않아도 되는 격자는 패스
2. 시간복잡도 :
    O( N )
3. 자료구조 :
    -

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q1074_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int R;
    static int C;
    static int[][] board;

    static int count = 0;

    public static void dfs(int row, int col, int size) {
        if (size==1) {
//            board[row1][col1] = count;
            if (R == row && C == col) {
                System.out.println(count);
                System.exit(0);
            }
            count++;
            return;
        }

        int half = size / 2;
        int areaSize = half * half;

        if (R < row + half && C < col + half) {
            dfs(row, col, half);
        } else if (R < row + half && C >= col + half) {
            count += areaSize;
            dfs(row, col + half, half);
        } else if (R >= row + half && C < col + half) {
            count += areaSize * 2;
            dfs(row + half, col, half);
        } else {
            count += areaSize * 3;
            dfs(row + half, col + half, half);
        }
    }

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        R = inputs[1];
        C = inputs[2];
//        board = new int[(int)Math.pow(2,N)][(int)Math.pow(2,N)];
        dfs(0, 0, (int) Math.pow(2, N));
//        System.out.println(board[R][C]);
//        for (var a: board) System.out.println(Arrays.toString(a));

    }
}
