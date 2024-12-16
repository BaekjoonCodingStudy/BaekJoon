package 백준;

class Main {

    public static int[] moveX = {-1,1,0,0};
    public static int[] moveY = {0,0,-1,1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        String[] arr = new String[y][x];
        String[] result = new String[y][x];
        for(int i=0; i<y;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<x;j++){
                arr[i][j] = st.nextToken();
                result[i][j] = ".";
            }
        }

        for(int i=0; i<y;i++){
            for(int j=0; j<x;j++){
                int cnt = 0;
                if(".".equals(arr[i][j])) continue;
                for(int i=0;i<4;i++){
                    int ny = i+moveX[i];
                    int nx = i+moveY[i];
                    if(ny>=0 && ny<y && nx>=0 && nx <x){
                        if(".".equals(arr[ny][nx])){
                            cnt++;
                        }
                    }else{
                        cnt++;
                    }
                }
                if(cnt >= 3){
                    result[i][j] = ".";
                }
            }
        }

        for(int i=0; i<y;i++){
            for(int j=0; j<x;j++) {
                System.out.print( result[i][j]);
            }
            System.out.println();
        }


    }
}