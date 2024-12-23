// https://www.acmicpc.net/problem/
package 백준;

/*

1. 아이디어 :
    union-find를 사용합니다.

2. 시간복잡도 :
    O( n + m )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q1717 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] par;
    static int[] rank;

    public static int find(int x) {
        if (x!= par[x]) {
            par[x] = find(par[x]);
        }
        return par[x];
    }

    public static void union(int a, int b) {
        int ra = find(a), rb = find(b);

        if (ra == rb) return;

        if (rank[ra] > rank[rb]) {
            par[rb]=ra;
        } else if (rank[ra] < rank[rb]) {
            par[ra]=rb;
        } else {
            rank[ra]++;
            par[rb] =ra;
        }
    }

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0]+1, M = inputs[1];
        rank = new int[N];
        par = new int[N];
        for (int i=0; i<N; i++) par[i] = i;

        for (int i=0; i<M; i++) {
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int op = inputs[0], a = inputs[1], b = inputs[2];
            if (op == 0) { // union
                union(a, b);
            } else { // check
                System.out.println( find(a) == find(b) ? "YES" : "NO" );
            }
        }
    }
}
