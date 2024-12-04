// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    백트래킹을 사용합니다.
    k번쨰 수를 포함하거나, 포함하지 않는 경우
2. 시간복잡도 :
    O( nCk )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Q5568 {

    static int N;
    static int K;
    static String[] nums;
    static Set<String> candids;
    static Set<Integer> visited = new HashSet<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void backtrack(String s, int idx, int count) {
        if (count == K) {
            candids.add(s);
            return;
        }

        for (int i=0; i<N; i++) {
            String nextNum = nums[i];
            if (visited.contains(i)) continue;
            visited.add(i);

            backtrack(s + nextNum, i, count+1);

            visited.remove(i);
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        nums = new String[N];
        for (int i=0; i<N; i++) nums[i] = br.readLine();

        candids = new HashSet<>();
        backtrack("",0,0);

        System.out.println(candids.size());
    }
}
