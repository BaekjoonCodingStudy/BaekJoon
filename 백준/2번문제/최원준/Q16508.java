// https://www.acmicpc.net/problem/
package 백준;

/*


1. 아이디어 :
    백트래킹을 사용합니다.
    책들을 값 기준 오름차순 정렬을 합니다.
    책들을 포함하면서 맵을 갱신해주고 targetMap과 비교합니다.
2. 시간복잡도 :
    O( 2 ** N )
3. 자료구조 :
    해시맵

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Q16508 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Map<Character, Integer> targetMap;
    static int ans = Integer.MAX_VALUE;
    static String[][] books;
    public static boolean match(Map<Character, Integer> currMap) {
        for (var entry : targetMap.entrySet()) {
            if (!currMap.containsKey(entry.getKey()) || currMap.get(entry.getKey()) < entry.getValue()) return false;
        }
        return true;
    }

    public static Map<Character, Integer> fillMap(Map<Character, Integer> map, String s) {
        Map<Character, Integer> newMap = new HashMap<>(map);
        for (Character c : s.toCharArray()) {
            newMap.put(c, newMap.getOrDefault(c, 0)+1);
        }
        return newMap;
    }

    public static void backtrack(int idx, Map<Character, Integer> currMap, int totalCost) {
//        System.out.println(currMap);
        if (match(currMap)) {
            ans = Math.min(ans, totalCost);
            return;
        }

        for (int i=idx; i<N; i++) {
            String[] bookInfo = books[i];
            int cost = Integer.parseInt(bookInfo[0]);
            String bookName = bookInfo[1];

            backtrack(i+1, fillMap(currMap, bookName), totalCost+cost);

        }
    }

    public static void main(String[] args) throws IOException {
        String target = br.readLine();
        N = Integer.parseInt(br.readLine());

        books = new String[N][2];
        for (int i=0; i<N; i++) books[i] = br.readLine().split(" ");
        Arrays.sort(books, (a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));

        targetMap = fillMap(new HashMap<>(), target);

        backtrack(0, new HashMap<>(), 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
