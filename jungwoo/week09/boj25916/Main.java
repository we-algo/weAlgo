package algorithmstudy.twopointer.boj25916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        twoPointers();
    }

    private static void twoPointers() {
        int L = 0, R = 0, sum = 0, answer = 0;
        while (R < N) {
            sum += A[R++];
            while (sum > M) {
                sum -= A[L++];
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }

    private static void twoPointers2() {
        int R = 0, sum = 0, answer = 0;
        for (int L = 0; L < N; L++) {
            while (R < N && sum + A[R] <= M) {
                sum += A[R++];
            }

            answer = Math.max(answer, sum);
            sum -= A[L];
        }
        System.out.println(answer);
    }
}