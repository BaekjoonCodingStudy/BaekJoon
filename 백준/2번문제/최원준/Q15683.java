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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Q15683 {
    static Map<Integer, List<int[]>> dirs;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void initDirs() {
        List<int[]> dirTemp;

        dirTemp= new ArrayList<>();
        dirTemp.add(new int[]{0,1});
        dirs.put(1, dirTemp);

        dirTemp = new ArrayList<>();
        dirTemp.add(new int[]{0,1});
        dirTemp.add(new int[]{0,-1});
        dirs.put(2, dirTemp);

        dirTemp = new ArrayList<>();
        dirTemp.add(new int[]{0,1});
        dirTemp.add(new int[]{-1,0});
        dirs.put(3, dirTemp);

        dirTemp = new ArrayList<>();
        dirTemp.add(new int[]{0,1});
        dirTemp.add(new int[]{-1,0});
        dirTemp.add(new int[]{0,-1});
        dirs.put(4, dirTemp);

        dirTemp = new ArrayList<>();
        dirTemp.add(new int[]{0,1});
        dirTemp.add(new int[]{-1,0});
        dirTemp.add(new int[]{0,-1});
        dirTemp.add(new int[]{1,0});
        dirs.put(5, dirTemp);
    }
    public static void main(String[] args) throws IOException {
        initDirs();

        

    }
}
