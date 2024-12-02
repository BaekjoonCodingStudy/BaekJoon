// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    그래프를 초기화합니다.
    루트(1) 노드부터 가장 멀리 있는 노드를 구합니다.
    가장 멀리 있는 노드에서 가장 멀리 있는 노드의 거리를 구합니다
2. 시간복잡도 :
    O( n )
3. 자료구조 :
    해시맵, 해시셋

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q1967 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] inputs;

    static Map<Integer, ArrayList<int[]>> distances;

    public static int[] bfs(int n, int startNode) {
        Set<Integer> visited = new HashSet<>();
        visited.add(startNode);
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{startNode, 0});

        int[] ans = new int[]{-1,-1};

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int currNode = curr[0], totalDistance = curr[1];
            if (totalDistance > ans[1]) {
                ans[0] = currNode;
                ans[1] = totalDistance;
            }
            for (int[] nextNodeInfo : distances.getOrDefault(currNode, new ArrayList<>())) {
                int nextNode = nextNodeInfo[0], distance = nextNodeInfo[1];

                if (distance == 0 || visited.contains(nextNode)) continue;
                visited.add(nextNode);
                deque.addLast(new int[]{nextNode, totalDistance + distance});
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        distances = new HashMap<>();

        for (int i=0; i<n-1; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]), b= Integer.parseInt(inputs[1]);
            int dist = Integer.parseInt(inputs[2]);
            distances.putIfAbsent(a, new ArrayList<>());
            distances.putIfAbsent(b, new ArrayList<>());
            distances.get(a).add(new int[]{b,dist});
            distances.get(b).add(new int[]{a,dist});
        }

        int[] farthest1 = bfs(n, 1);
        int[] fartbest2 = bfs(n, farthest1[0]);
        System.out.println(fartbest2[1]);
    }
}

/*

import sys
from collections import defaultdict, deque
#sys.setrecursionlimit(1000000)
# input = sys.stdin.readline
input = lambda: sys.stdin.readline().rstrip()

def solution(n, arr):

    def bfs(start_node):
        visited = set()
        visited.add(start_node)
        queue = deque()
        queue.append([start_node, 0])

        ans = [-1, -1]
        while queue:
            currNode, totalDistance = queue.popleft()
            if totalDistance > ans[1]:
                ans = [currNode, totalDistance]

            for next_node, distance in distances[currNode]:
                if next_node in visited: continue
                visited.add(next_node)
                queue.append([next_node, totalDistance + distance])
        return ans

    distances = defaultdict(set)

    for a, b, d in arr:
        distances[a].add((b,d))
        distances[b].add((a,d))

    farthest_node, _ = bfs(1)
    _, farthest_distance = bfs(farthest_node)

    return farthest_distance



if __name__ == '__main__':
    n = int(input())
    arr = []
    for i in range(n-1):
        arr.append(list(map(int, input().split())))
    print(solution(n, arr))
 */