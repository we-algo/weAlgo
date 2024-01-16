package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2961 {

    static int n;
    static int[][] a;
    static int diff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        a = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        cook(0, 0, 1, 0);
        System.out.println(diff);
    }

    static void cook(int i, int bit, int sour, int bitter) {
        if (i == n) {
            if (bit == 0) {
                return;
            }

            diff = Integer.min(diff, Math.abs(sour - bitter));
            return;
        }
        // 재료를 선택하지 않은 경우
        cook(i + 1, bit, sour, bitter);
        // 재료를 선택한 경우 재료를 비트로 구분 bit 1, 2, 4, 8 ....
        cook(i + 1, bit | (1 << i), sour * a[i][0], bitter + a[i][1]);

    }

}