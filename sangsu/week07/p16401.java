package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p16401_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        int maxCookieLength = 0;
        int left = 1;
        int right = a[n-1];
        while(left <= right){
            int count = 0;
            int center = (left + right) / 2;
            //m을 기준으로 몇개가 나오는지 카운트
            for(int i = 0; i <n; i++){
                count += a[i]/center;
            }

            if(count >= m){
                maxCookieLength = center;
                left = center+1;
            }else{
                right = center-1;
            }
        }

        System.out.println(maxCookieLength);

    }
}
