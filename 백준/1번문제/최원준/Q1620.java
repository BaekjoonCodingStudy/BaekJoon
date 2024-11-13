// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    포켓몬 : 번호, 번호 : 포켓몬을 추적하는 두개의 해시맵을 사용합니다.
2. 시간복잡도 :
    O( n+m )
3. 자료구조 :
    해시맵

 */
import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Q1620 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String input;
    static String[] inputs;
    static int[] ninputs;

    public static void main(String[] args) throws IOException {
        HashMap<Integer, String> numToName = new HashMap<>();
        HashMap<String, Integer> nameToNum = new HashMap<>();
        inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]);
        for (int i = 0; i<n; i++) {
            input = br.readLine();
            numToName.put(i+1, input);
            nameToNum.put(input, i+1);
        }

        for (int i = 0; i<m; i++) {
            input = br.readLine();
            if (Character.isAlphabetic(input.charAt(0))) {
                System.out.println(nameToNum.get(input));
            } else {
                System.out.println(numToName.get(Integer.parseInt(input)));
            }
        }
    }
}


/*
import sys
#sys.setrecursionlimit(1000000)
# input = sys.stdin.readline
input = lambda: sys.stdin.readline().rstrip()

def solution(n, m):
    name_to_num = {}
    num_to_name = {}

    for i in range(n):
        pokemon = input()
        name_to_num[pokemon] = i+1
        num_to_name[i+1] = pokemon

    for i in range(m):
        query = input()
        if query[0].isnumeric():
            print(num_to_name[int(query)])
        else:
            print(name_to_num[query])

if __name__ == '__main__':
    n, m = map(int, input().split())
    solution(n, m)
 */