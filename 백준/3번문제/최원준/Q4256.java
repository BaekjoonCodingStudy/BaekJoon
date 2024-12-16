// https://www.acmicpc.net/problem/
package 백준;

/*

1. 아이디어 :
    재귀를 사용해서 풀 수 있습니다.
    전위의 맨 앞 숫자 x를 중위에서 찾습니다.
    중위에서 왼쪽 크기, 오른쪽 크기를 구합니다.
    전위에서 x의 인덱스+1 부터 왼쪽 크기, 중위에서 왼쪽 인덱스 + 왼쪽 크기를 재귀적으로 호출. 오른쪽도 동일.
    시작 인덱스와 끝 인덱스가 교차하게되면 리턴.
2. 시간복잡도 :
    O( T*n )
3. 자료구조 :
    -

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q4256 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static List<Integer> preOrder;
    static List<Integer> inOrder;
    static Map<Integer, Integer> numToIdx;
    static StringBuilder sb = new StringBuilder();

    public static List<Integer> toList (int[] fromList) {
        List<Integer> toList = new ArrayList<>();
        for (int num : fromList) toList.add(num);
        return toList;
    }

    public static void sbAddList(List<Integer> ans) {
        sb.append(ans.get(0));
        for (int i=1; i<ans.size(); i++) sb.append(" ").append(ans.get(i));
    }

    public static List<Integer> dfs(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return new ArrayList<>();

        int root = preOrder.get(preStart);
        int inOrderRootIdx = numToIdx.get(root);
        int leftSize = inOrderRootIdx- inStart; // 4
        int rightSize = inEnd - inOrderRootIdx; // 3

        var left = dfs(preStart+1, preStart+leftSize, inStart, inStart + inOrderRootIdx-1);
        var right = dfs(preStart+leftSize+1, preEnd, inOrderRootIdx+1, inEnd);
//        System.out.println(left + " " + right);
//        System.out.println(root + " " + inOrderRootIdx + " " + leftSize + " " + rightSize);

        List<Integer> ans = new ArrayList<>();
        ans.addAll(left);
        ans.addAll(right);
        ans.add(root);
        return ans;
    }
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine());
            preOrder = toList(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
            inOrder  = toList(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
            numToIdx = new HashMap<>();
            for (int i=0; i<n; i++) numToIdx.put(inOrder.get(i), i);
            sbAddList(dfs(0, n-1, 0, n-1));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
