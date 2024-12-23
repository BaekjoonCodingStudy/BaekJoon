// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    투포인터를 사용했습니다.
2. 시간복잡도 :
    O( nlogn )
3. 자료구조 :


 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q2470_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] nums;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        System.out.println(Arrays.toString(nums));
        int minDiff = Integer.MAX_VALUE;
        int[] ans = new int[]{-1, -1};

        int left = 0, right = N-1;

        while (left<right) {
            int total = nums[left] + nums[right];
            if (total == 0) {
                System.out.println(nums[left] + " " + nums[right]);
                return;
            }
            if (Math.abs(total) < minDiff) {
                ans = new int[]{nums[left], nums[right]};
                minDiff = Math.abs(total);
            }
            if (total > 0) right--; else left++;
        }
        System.out.println(ans[0] + " " + ans[1]);
    }
}
