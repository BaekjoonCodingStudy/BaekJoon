package com.example.algorithm.이분탐색;
import java.io.*;
import java.util.*;

public class Main {
    public static int[] dot;
    public static int min, max, n;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //점 갯수
        int m = Integer.parseInt(st.nextToken()); //선 갯수
        dot = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            dot[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dot);
        min = dot[0]; //시작
        max = dot[n-1]; //끝
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(count(start, end)).append("\n");
        }
        System.out.println(sb);

    }
    public static int count(int start, int end){
        int stIdx = 0;
        int endIdx = n-1;

        //범위 체크
        if(start > max || end < min){
            return 0; //겹치는부분 없음.
        }
        /**
         * findStart(start)는 시작 지점 start 이상의 첫 번째 인덱스
         * findEnd(end)는 끝 지점 end 이하의 마지막 인덱스.*/

        //시작 부분 이분탐색
        if(start > min){
            stIdx = findStart(start);
        }

        //끝부분 이분탐색
        if(end < max){
            endIdx = findEnd(end);
        }

        return endIdx - stIdx +1;

    }



    public static int findStart(int value) {

        //findStart는 value 이상이 처음 등장하는 위치
        int start = 0, end = n;

        while (start < end) {
            int mid = (start + end) / 2;

            if (dot[mid] < value) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    public static int findEnd(int value) {

        //findEnd는 value 이하의 마지막 위치
        int start = 0, end = n;

        while (start < end) {
            int mid = (start + end) / 2;

            if (dot[mid] <= value) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start - 1;
    }
}
