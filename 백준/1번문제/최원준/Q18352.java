// https://www.acmicpc.net/problem/
package 백준;

/*

1. 아이디어 :
    bfs
2. 시간복잡도 :
    O( N + M )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q18352 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0], M = inputs[1], K = inputs[2], start = inputs[3]-1;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=0; i<M; i++) {
            int[] path = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int s = path[0]-1, e = path[1]-1;
            graph.putIfAbsent(s, new ArrayList<>());
            graph.get(s).add(e);
        }

        int[] distance = new int[N];
        Arrays.fill(distance,-1);
        distance[start] = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(start);
        while (!deque.isEmpty()) {
            int curr = deque.pollFirst();
            int dist = distance[curr];

            if (dist == K) continue;
            if (!graph.containsKey(curr)) continue;
            for (int neighbor : graph.get(curr)) {
                if (distance[neighbor]!=-1) continue;
                distance[neighbor] = dist+1;
                deque.addLast(neighbor);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int city = 0; city<N; city++) {
            if (distance[city]==K) {
                sb.append(city+1).append("\n");
            }
        }
        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb.toString());
        }
    }
}
