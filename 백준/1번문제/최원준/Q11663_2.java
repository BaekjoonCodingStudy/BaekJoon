// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    입력값을 정렬 후,
    각 선분마다 왼쪽 점을 포함하는 최소 인덱스와 오른쪽 점을 포함하는 최대 인덱스를 구합니다.
2. 시간복잡도 :
    O( nlogn + mlogn )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Q11663_2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] cords;

    public static int getLeftIdx(int target) {
        int left = 0, right = cords.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (cords[mid] >= target) right = mid; else left = mid+1;
        }
        return left;
    }

    public static int getRightIdx(int target) {
        int left = 0, right = cords.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (cords[mid] > target) right = mid; else left = mid + 1;

        }
        return left;
    }

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0], M = inputs[1];
        cords = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            int[] ranges = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(getRightIdx(ranges[1])-getLeftIdx(ranges[0]) + "\n");
        }
        System.out.println(sb.toString());
    }
}
