package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        boolean[] check = new boolean[100001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        //1, 12, 123, 1234, 12345 | 2345, 234, 23, 2 | 3, 34, 345 | 45, 4 | 5
        while (left < n) {
            while (right < n) {
                if(check[a[right]]){
                    break;
                }
                check[a[right]] = true;
                right++;
            }

            sum += right - left;

            check[a[left]] = false;
            left++;
        }

        System.out.println(sum);
    }
}
