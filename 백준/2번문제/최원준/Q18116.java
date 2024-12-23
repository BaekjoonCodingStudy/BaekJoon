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

class Q18116 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] par;
    static int[] size;


    public static int find(int a) {
        if (a!=par[a]) {
            par[a] = find(par[a]);
        }
        return par[a];
    }

    public static void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return;

        if (size[ra] > size[rb]) {
            par[rb] = ra;
            size[ra] += size[rb];
        } else {
            par[ra] = rb;
            size[rb] += size[ra];
        }
    }

    public static void main(String[] args) throws IOException {
        int N = 1000001;
        int Q = Integer.parseInt(br.readLine());
        par = new int[N];
        size = new int[N];
        for (int i=0; i<N; i++) {
            par[i] = i;
            size[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<Q; i++) {
            String[] inputs = br.readLine().split(" ");
            String op = inputs[0];

            if (op.equals("I")) { //union
                int a = Integer.parseInt(inputs[1]);
                int b = Integer.parseInt(inputs[2]);
                union(a,b);

            } else { // check
                int a = Integer.parseInt(inputs[1]);
                sb.append(size[find(a)]).append("\n");
            }
        }
        System.out.println(sb.toString());

    }
}
