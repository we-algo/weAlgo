package algorithmstudy.twopointer.boj9024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T, N, K, answer;
    static int[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            S = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(S);
            twoPointers();
        }
    }

    private static void twoPointers() {
        answer = 0;
        int left = 0, right = N - 1;
        int minDifference = Integer.MAX_VALUE;

        while (left < right) {
            int sum = S[left] + S[right];
            int difference = Math.abs(K - sum);

            if (difference < minDifference) {
                minDifference = difference;
                answer = 1;
            } else if (difference == minDifference) {
                answer++;
            }

            if (sum < K) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(answer);
    }
}