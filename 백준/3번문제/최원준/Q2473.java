// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    투포인터를 사용했습니다.
    가장 작은 용액(i)를 순회하면서, i+1번쨰 용액과 N-1번쨰 용액에 대해 투포인터를 사용
2. 시간복잡도 :
    O( n**2 )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q2473 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] nums;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        long minDiff = Long.MAX_VALUE;
        int[] ans = new int[]{-1, -1, -1};


        for (int i=0; i<N-2; i++) {
            int left = i+1, right = N-1;

            while (left<right) {
                long total = (long)nums[i] + nums[left] + nums[right];

                if (Math.abs(total) < minDiff) {
                    ans = new int[]{nums[i], nums[left], nums[right]};
                    minDiff = Math.abs(total);
                }

                if (total == 0) {
                    System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);
                    return;
                }
                if (total > 0) right--; else left++;
            }
        }

        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
