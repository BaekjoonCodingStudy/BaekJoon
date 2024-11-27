// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    첫번째 학생을 0부터 N-2까지 순회합니다.
    순회하면서 두번째 학생을 첫번쨰 학생+1, 세번째 학생을 가장 오른쪽(N-1)로 둡니다
    두번째, 세번째 학생을 순회하면서 모든 학생의 총합이 0인지 확인
    0보다 크면 세번째 학생을 -1, 작으면 두번쨰 학생을 +1
    같으면 두번쨰, 세번쨰 학생의 값을 비교.
        비교했을때 같으면 nC2를 합니다 n*(n-1) / 2
        그렇지 않으면 중복된 숫자를 카운트하기 위해 두번째 학생과 세번째 학생의 포인터를 옮기면서 중복 숫자들을 구하고 곱한값을 더해줍니다.
2. 시간복잡도 :
    O( n**2 )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Q3151 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(scores);

        long ans = 0;

        for (int i = 0; i < N - 2; i++) {
            int iVal = scores[i];
            if (iVal > 0) break;

            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int lVal = scores[left];
                int rVal = scores[right];
                int total = iVal + lVal + rVal;

                if (total == 0) {
                    if (lVal == rVal) {
                        int count = right - left + 1;
                        ans += (long)count * (count - 1) / 2;
                        break;
                    }

                    long lCount = 1, rCount = 1;
                    while (left + 1 < right && scores[left] == scores[left + 1]) {
                        left++;
                        lCount++;
                    }
                    while (right - 1 > left && scores[right] == scores[right - 1]) {
                        right--;
                        rCount++;
                    }

                    ans += lCount * rCount;
                    left++;
                    right--;
                } else if (total > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(ans);
    }
}

