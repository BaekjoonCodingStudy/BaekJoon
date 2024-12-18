// https://www.acmicpc.net/problem/
package 백준;

/*

1. 아이디어 :
    자고 있는 학생을 체크하기 위한 배열(isSleeping)과 출석 코드를 받은 학생을 체크하기 위한 배열(isChecked)을 만들고 초기화합니다.
    출석 코드를 받은 학생들 N+3까지 돌면서 체크를 해줍니다.
    N+3까지 출석코드를 받은 학생들의 누적합(prefixSum)을 구합니다.
    출석코드를 받은 학생 구간 s-e는 prefixSum[e] - prefixSum[s-1]
2. 시간복잡도 :
    O( M * (N/Q*K + N) )
3. 자료구조 :
    배열

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q20438 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = inputs[0];
        int M = inputs[3];

        boolean[] isSleeping = new boolean[N+3];
        boolean[] isChecked = new boolean[N+3];

        int[] sleepStudents = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int student : sleepStudents) isSleeping[student] = true;

        int[] attendStudents = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int student : attendStudents) {
            if (isSleeping[student]) continue;
            for (int i = student; i<N+3; i+=student) {
                if (!isSleeping[i]) isChecked[i] = true;
            }
        }

//        System.out.println(Arrays.toString(isSleeping));
//        System.out.println(Arrays.toString(isChecked));

        int[] prefixSum = new int[N+3];
        for (int i=3; i<N+3; i++) prefixSum[i] = prefixSum[i-1] + (isChecked[i] ? 0 : 1);

        StringBuilder sb = new StringBuilder();
        for (int m=0; m<M; m++) {
            int[] interval = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int s = interval[0], e = interval[1];
            sb.append(prefixSum[e] - prefixSum[s-1]).append("\n");
        }
        System.out.println(sb.toString());

    }
}
