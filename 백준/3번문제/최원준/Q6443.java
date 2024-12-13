// https://www.acmicpc.net/problem/
package 백준;

/*

1. 아이디어 :
    입력값을 정렬합니다.
    백트래킹을 통해 입력값을 추가하는데,
    추가될 입력값의 전 인덱스 값과 같고, 전 인덱스가 사용되지 않았으면 continue;
2. 시간복잡도 :
    O( N * L! )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q6443 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int L;
    static char[] charS;
    static StringBuilder sb = new StringBuilder();

    public static void backtrack(String s, int length, boolean[] visited) {
        if (length == L) {
            sb.append(s).append("\n");
            return;
        }

        for (int i=0; i<L; i++) {
            if (visited[i]) continue;
            if (i>=1 && charS[i] == charS[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            backtrack(s+charS[i],length+1, visited);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            charS = br.readLine().toCharArray();
            Arrays.sort(charS);
            L = charS.length;
            backtrack("", 0, new boolean[L]);
        }
        System.out.println(sb.toString());
    }
}
