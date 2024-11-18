// https://www.acmicpc.net/problem/
package 백준;

/*

1. 아이디어 :
    소수 리스트를 구한다
    K개로 만들 수 있는 모든 조합을 구한다.
    1번 규칙을 골드바흐의 추측을 통해 확인.
    2번 규칙을 n**0.5 만큼 순회하면서 n과 n'이 소수리스트에 있는지 확인

    골드바흐의 추측 : 2보다 큰 모든 짝수는 두 소수의 합으로 표현될 수 있다. n이 7이상의 짝수이면 두 소수의 합으로 표현이 가능하다는 것을 보장.
2. 시간복잡도 :
    Permutation = 10! / (10-K)!
    PrimeList = 10**5 log 10**5
    rule1 = 1
    rule2 = log n
3. 자료구조 :
    해시셋

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Q22943 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] inputs;

    public static Set<Integer> primeList(int start) {
        int end = 100000;
        boolean[] primes = new boolean[end+1];
        Arrays.fill(primes, true);
        start = Math.max(start, 2);

        int m = (int)Math.sqrt(end);

        for (int num = start; num<=m; num++) {
            if (!primes[num]) continue;
            for (int multiples = num * num; multiples <= end; multiples+=num) {
                primes[multiples] = false;
            }
        }

        Set<Integer> primeList = new HashSet<>();
        for (int i=2; i<=end; i++) {
            if (primes[i]==true) primeList.add(i);
        }

        return primeList;
    }


    public static boolean rule1(Set<Integer> primeList, int n) {
        if ((n!=4 && primeList.contains(n-2)) || (n>=7 && n%2 == 0)) return true;
        return false;
    }

    public static boolean rule2(Set<Integer> primeList, int n, int M) {
        while (n%M == 0) {
            n /= M;
        }

        for (int i=2; i<(int)Math.sqrt(n) + 1; i++) {
            if (n%i == 0) {
                if (primeList.contains(i) && primeList.contains(n/i)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static ArrayList<Integer> permutations(int K) {
        ArrayList<Integer> permutationList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        dfs(0, K, 0, visited, permutationList);
        return permutationList;
    }

    public static void dfs(int depth, int K, int curr, Set<Integer> visited, ArrayList<Integer> permutationList) {
        if (depth == K) {
            permutationList.add(curr);
            return;
        }

        for (int i=0; i<10; i++) {
            if (visited.contains(i)) continue;
            if (depth == 0 && i == 0) continue;

            visited.add(i);
            dfs(depth+1, K, curr * 10 + i, visited, permutationList);
            visited.remove(i);
        }
    }

    public static void main(String[] args) throws IOException {
        inputs = br.readLine().split(" ");
        int K = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        Set<Integer> primeList = primeList(2);

        int ans = 0;
        for (int num : permutations(K)) {
            if (rule1(primeList, num) && rule2(primeList, num, M)) ans++;
        }
        System.out.println(ans);
    }
}

