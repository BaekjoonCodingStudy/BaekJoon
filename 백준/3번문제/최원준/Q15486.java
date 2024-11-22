// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    dp 배열을 초기화합니다.
    매일 순회하면서, 당일 값은 전날 최대값이거나 그전에 계산해놓은 최대값으로 갱신합니다.
    각 날(dur, price)를 가져와서 당일+dur이 N을 넘어가면 continue
    아니라면, 당일 값 + price를 수업이 끝나는 날에 최대값으로 저장합니다.
2. 시간복잡도 :
    O( n )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q15486 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int totalDays = Integer.parseInt(br.readLine());
        int[][] courses = new int[totalDays + 1][2];
        for (int i = 1; i <= totalDays; i++) courses[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[totalDays + 2];

        for (int day = 1; day <= totalDays; day++) {
            dp[day] = Math.max(dp[day], dp[day - 1]);

            int dur = courses[day][0], price = courses[day][1];
            int endDay = day + dur;

            if (endDay > totalDays + 1) continue;
            dp[endDay] = Math.max(dp[endDay], dp[day] + price);
        }

        int ans = Math.max(dp[totalDays], dp[totalDays + 1]);
        System.out.println(ans);
    }
}
