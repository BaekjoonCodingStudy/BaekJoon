// https://www.acmicpc.net/problem/
package 백준;

/*

1. 아이디어 :
    벨만 포드
    - distance를 초기화합니다
    - 각 edge마다 짧은 거리를 갱신. 이를 모든 노드 수 만큼 반복.
    - 각 edge를 한번 더 순회를 하면서 작은 값이 나올 수 있는지 확인
2. 시간복잡도 :
    O( n * m )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q11657 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static long[] distance;
    static List<int[]> edges = new ArrayList<>();
    static int N;
    static int M;

    public static void bellmanFord(int start) {
        distance[start] = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int curr = edges.get(j)[0], next = edges.get(j)[1], cost = edges.get(j)[2];
                if (distance[curr] != Long.MAX_VALUE && distance[next] > (long)distance[curr] + cost) {
                    distance[next] = (long)distance[curr] + cost;
                }

            }
        }

        for (int j = 0; j < M; j++) {
            int curr = edges.get(j)[0], next = edges.get(j)[1], cost = edges.get(j)[2];
            if (distance[curr] != Long.MAX_VALUE && distance[next] > (long) distance[curr] + cost) {
                System.out.println(-1);
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = inputs[0];
        M = inputs[1];
        distance = new long[N+1];
        Arrays.fill(distance, Long.MAX_VALUE);

        for (int i=0; i<M; i++) {
            edges.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        bellmanFord(1);
        StringBuilder sb =new StringBuilder();
        if (distance[1] < 0) {
            System.out.println(-1);
            System.exit(0);
        }
        for (int i = 2; i<N+1; i++) {
            if (distance[i] == Long.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
