// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    1일때는 SK
    2일때는 CY
    3일떄는 SK
    ...
    n%2==0일떄는 CY
    n%2==1일떄는 SK
2. 시간복잡도 :
    O( 1 )
3. 자료구조 :
    -

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Q9655 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println(Integer.parseInt(br.readLine())%2 == 1? "SK" : "CY");
    }
}
