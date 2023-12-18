package algorithmstudy.twopointer.boj13144;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] A;
    private static int[] count;

    // 투 포인터란? : 화살표 두개에 의미를 부여해서 탐색 범위를 압축하는 방법
    // 1. 1차원 배열 위에 2개의 포인터를 만드는 경우
    //   1 - 1. 2개의 포인터가 모두 왼쪽에서 시작해서 같은 방향으로 이동
    //   1 - 2. 2개의 포인터가 양 끝에서 서로를 향해 이동하면서 푸는 방법

    // 2. 관찰을 통해서 문제에 등장하는 변수 2개의 값을 모두 포인터로 표현하는 경우

    // 투 포인터를 생각해볼 수 있는 키워드
    // - 1차원 배열에서 "연속 부분 수열" or "순서를 지키며 차례대로"
    // - 곱의 최소

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        count = new int[100000 + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        twoPointers();
    }

    static void twoPointers() {
        long answer = 0;

        for (int L = 1, R = 0; L <= N; L++) {
            // R 을 옮길 수 있는 만큼 옮긴다.
            while (R + 1 <= N && count[A[R + 1]] == 0) {
                R++;
                count[A[R]]++;
            }

            // 정답 갱신
            answer += R - L + 1;

            // L을 옮겨주면서 A[L]의 갯수를 감소 시킨다.
            count[A[L]]--;
        }

        System.out.println(answer);
    }
}

