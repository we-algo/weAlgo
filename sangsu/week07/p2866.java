package Baekjoon.gold;

import java.io.*;
import java.util.*;

//행을 지울때 마다 그 때의 세로문자열들 중에 중복값이 있느냐
public class p2866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] a = new char[r][c];

        for (int i = 0; i < r; i++) {
            a[i] = br.readLine().toCharArray();
        }

        StringBuilder[] sb = new StringBuilder[c];

        for (int i = 0; i < c; i++) {
            sb[i] = new StringBuilder();
        }
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                sb[i].append(a[j][i]);
            }
        }

        if (r == 2) {
            System.out.println(0);
            return;
        }

        int left = 0;
        int right = r;
        int minValue = Integer.MAX_VALUE;
        boolean flag;
        //center는 행의 수
        while (left <= right) {
            flag = false;
            int center = (left + right) / 2;
            Set<String> set = new HashSet<>();
            for (int i = 0; i < c; i++) {
                String s = sb[i].substring(center, r);
                if (!set.add(s)) {
                    minValue = center;
                    flag = true;
                }
            }

            if (flag) {
                right = center - 1;
            } else {
                left = center + 1;

            }
        }
        if (minValue == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minValue - 1);
        }
    }
}
