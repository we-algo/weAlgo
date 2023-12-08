package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p13397{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int right = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
            right = Integer.max(right, a[i]);
        }

        int left = 0;
        int maxResult = Integer.MAX_VALUE;
        while(left <= right){
            int center = (left + right) / 2;

            int count = 1;
            int min = a[0];
            int max = a[0];

            for(int i = 0; i < n; i++){
                min = Integer.min(min, a[i]);
                max = Integer.max(max, a[i]);

                if(max - min > center){
                    count++;
                    min = a[i];
                    max = a[i];
                }
            }

            if(count <= m){
                maxResult = Integer.min(center, maxResult);
                right = center - 1;
            }else{
                left = center + 1;
            }
        }
        System.out.println(maxResult);
    }
}
