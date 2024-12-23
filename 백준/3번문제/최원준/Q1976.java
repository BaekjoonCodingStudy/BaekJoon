// https://www.acmicpc.net/problem/
package 백준;

/*

1. 아이디어 :
    union-find를 사용합니다.

2. 시간복잡도 :
    O( n*n + m )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q1976 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] par;
    static int[] rank;

    public static int find(int a) {
        if (a!=par[a]) {
            par[a] = find(par[a]);
        }
        return par[a];
    }

    public static void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra==rb) return;

        if (rank[ra] > rank[rb]) {
            par[rb] = ra;
        } else if(rank[ra] < rank[rb]) {
            par[ra] = rb;
        } else {
            rank[ra]++;
            par[rb] = ra;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        par = new int[N];
        rank = new int[N];
        for (int i=0; i<N; i++) par[i]=i;

        for (int row = 0; row<N; row++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int col=0; col<N; col++) {
                if (inputs[col] == 1) {
                    union(row, col);
                }
            }
        }

        int[] path = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int root = find(path[0]-1);

        for (int i=1; i<M; i++) {
            if (find(path[i]-1)!= root) {
                System.out.println("NO");
                System.exit(0);
            }
        }

        System.out.println("YES");
    }
}
