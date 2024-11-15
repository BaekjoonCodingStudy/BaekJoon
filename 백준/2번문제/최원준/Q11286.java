// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    우선순위큐(힙)을 사용. [절대값, 기존 값] 형태로 힙에 저장하고 꺼냅니다.
2. 시간복잡도 :
O( )
3. 자료구조 :
    우선순위큐(힙)

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Q11286 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String input;
    static String[] inputs;
    static int[] ninputs;

    public static void main(String[] args) throws IOException {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[0] == b[0]) return a[1]-b[1];
            return a[0]-b[0];
        }); // abs, ori

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll()[1]);
                }
            } else {
                pq.offer(new int[]{Math.abs(num), num});
            }
        }

    }
}

/*
import sys
import heapq
#sys.setrecursionlimit(1000000)
# input = sys.stdin.readline
input = lambda: sys.stdin.readline().rstrip()

def solution(n):
    min_heap = []
    for i in range(n):
        num = int(input())
        if num == 0:
            if min_heap:
                print(heapq.heappop(min_heap)[1])
            else:
                print(0)
        else:
            heapq.heappush(min_heap, [abs(num), num])

if __name__ == '__main__':
    solution(int(input().rstrip()))

 */