// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    bfs를 통해 i부터 시작했을때 나머지 노드들에 대한 거리를 구합니다.
    두 노드를 선택하는 combination(백트래킹) 을 통해서 a, b 임의의 a,b노드를 선택합니다.
    임의의 시작 노드부터 a와 b거리를 비교했을때 가까운 값을 더해줍니다.
    각 시작노드들을 연산했을때 최소 거리를 리턴합니다.
2. 시간복잡도 :
    O( N**3 )
3. 자료구조 :
    배열, 큐

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q21278 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static Map<Integer, List<Integer>> graph;

    public static int[] bfs(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.pollFirst();
            for (int neighbor : graph.get(curr)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[curr]+1;
                    queue.add(neighbor);
                }
            }
        }
        return dist;
    }

    public static List<List<Integer>> getCombinations(int total, int r) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        combine(ans, tempList, total, r, 1);
        return ans;
    }

    // 백트래킹을 사용하여 조합 생성
    private static void combine(List<List<Integer>> ans, List<Integer> tempList, int total, int r, int start) {
        // 조합이 완성되었을 경우
        if (tempList.size() == r) {
            ans.add(new ArrayList<>(tempList));
            return;
        }

        // 다음 요소 선택
        for (int i = start; i <= total; i++) {
            tempList.add(i);
            combine(ans, tempList, total, r, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = nm[0];
        M = nm[1];

        graph = new HashMap<>();
        for (int i=0; i<M; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int u = inputs[0], v = inputs[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        List<int[]> allDistances = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            allDistances.add(bfs(i));
        }

        int ans = Integer.MAX_VALUE;
        int[] best = new int[]{0,0};
        int[] candids = new int[N];
        for (int i=0; i<N; i++) candids[i] = i+1;

        for (List<Integer> combination : getCombinations(N, 2)) {
            int total = 0;
            for (int i=1; i<=N; i++) {
                total += Math.min(allDistances.get(i-1)[combination.get(0)], allDistances.get(i-1)[combination.get(1)]);
            }
            if (total < ans) {
                ans = total;
                best = new int[]{combination.get(0), combination.get(1)};
            }
        }

        System.out.println(best[0] + " " + best[1] + " " + (ans * 2));
    }
}
