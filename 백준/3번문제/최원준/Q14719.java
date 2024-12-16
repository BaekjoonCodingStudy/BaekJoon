// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :

2. 시간복잡도 :
    O( )
3. 자료구조 :


 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Q14719 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int H = inputs[0], W = inputs[1];

        int[] blocks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lMax = new int[W];
        int[] rMax = new int[W];

        lMax[0] = 0;
        rMax[W-1] = 0;
        for (int i=1; i<W; i++) {
            lMax[i] = Math.max(lMax[i-1], blocks[i]);
            rMax[W-i-1] = Math.max(rMax[W-i], blocks[W-i-1]);
        }

        System.out.println(Arrays.toString(lMax));
        System.out.println(Arrays.toString(rMax));
    }
}
