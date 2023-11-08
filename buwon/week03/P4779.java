package org.coding.backJoon.silver.p4779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P4779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            solution(n);
        }
    }
    private static void solution(int n) {
        String str = "";

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                str = "-";
            } else {
                str = repeat(str);
            }
        }
        System.out.println(str);
    }

    private static String repeat(String str) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            sb.append(" ");
        }
        str = str + sb + str;

        return str;
    }
}
