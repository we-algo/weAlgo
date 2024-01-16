package Programmers.lv2;

import java.io.*;
import java.util.*;

public class p12914 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(4));
    }

    static public long solution(int n) {
        if (n == 1) {
            return 1;
        }
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}
