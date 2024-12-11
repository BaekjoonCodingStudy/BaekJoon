package com.example.algorithm.이분탐색;
import java.io.*;
import java.util.*;
public class bj11663 {
    public static int[] dot;
    public static int min, max, n;
    public static void Main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //점 갯수
        int m = Integer.parseInt(st.nextToken()); //선 갯수
        dot = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            dot[i] = Integer.parseInt(st.nextToken());
        }
        min = dot[0]; //시작
        max = dot[n-1]; //끝
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(count(start, end)).append("\n");
        }

    }
    public static int count(int start, int end){
        int stIdx = 0;
        int endIdx = n-1;

        //범위 체크
        if(start > max || end < min){
            return 0; //겹치는부분 없음.
        }

        //시작 부분 이분탐색
        if(start > min){
            stIdx = find(start, stIdx, endIdx);
        }

        //끝부분 이분탐색
        if(end < max){
            endIdx = find(end, stIdx, endIdx);
        }

        return endIdx - stIdx +1;

    }

    public static int find(int now, int start, int end){

        //todo 이분탐색 구현

        return 0;
    }
}
