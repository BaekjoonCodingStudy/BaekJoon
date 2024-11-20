// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    각 도시가 하나의 후보.
    각 도시를 돌면서 나머지 도시들의 거리차이 * 인원을 하면됩니다.
    이럴 경우 n**2 시간복잡도가 발생해서 누적합을 사요합니다.
2. 시간복잡도 :
    O( nlogn )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Q2141 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long totalPop = 0;

        ArrayList<int[]> cities = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            totalPop += inputs[1];
            cities.add(inputs);
        }
        Collections.sort(cities, (a,b) -> Integer.compare(a[0],b[0]));

        long currPop = 0;
        long target = (totalPop+1)/2;
        for (int i=0; i<n; i++) {
            currPop += cities.get(i)[1];
            if (currPop >= target) {
                System.out.println(cities.get(i)[0]);
                break;
            }
        }
    }
}

/*
import math
import sys
#sys.setrecursionlimit(1000000)
# input = sys.stdin.readline
input = lambda: sys.stdin.readline().rstrip()

def solution(n, cities):
    total = sum(b for a, b in cities)
    curr = 0
    target = math.ceil(total/2)

    for city, pop in cities:
        curr += pop
        if curr >= target: return city


if __name__ == '__main__':
    n = int(input())
    cities = sorted([list(map(int, input().split())) for _ in range(n)]);
    print(solution(n, cities))
 */