import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 계란 1 : 내구도 7 / 무게 5
// 계란 2 : 내구도 3 / 무게 4

// 계란 1로 계란 2를 내려쳤을 경우
// 계란 1 : 내구도 3 / 무게 5
// 계란 2 : 내구도 -2 / 무게 4 -> 계란 2 박살

// 가장 왼쪽 계란부터 계란 치기 시작!

public class Main {
    static int n;
    static int[][] egg;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        egg = new int[n][2];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++){
                egg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(max);
    }

    private static void dfs(int currentEgg, int count) {
        if (currentEgg == n - 1){
            max = Math.max(max, count);
        }

        // 마지막 계란 까지 갔을 경우 max값 갱신
        if (currentEgg == n) {
            max = Math.max(max, count);
            return;
        }

        // 현재 계란이 깨져 있으면 다음으로 넘어가기
        if (egg[currentEgg][0] <= 0) {
            dfs(currentEgg + 1, count);
            return;
        }

        // 계란이 다 꺠져 있을 경우도 넘어가기
        if (count == n - 1){
            dfs(currentEgg + 1, count);
            return;
        }

        // 계란 부수기
        for (int i = 0; i < n; i++) {
            // 현재 계란으로 같으면 넘어가기!
            if (currentEgg == i) {
                continue;
            }

            // 다음 계란이 깨져 있으면 그냥 넘기기.
            if (egg[i][0] <= 0) {
                continue;
            }

            // 계란 부수기!
            egg[i][0] -= egg[currentEgg][1];
            egg[currentEgg][0] -= egg[i][1];

            // 계란으로 쳤을 경우 깨질 경우
            if (egg[i][0] <= 0) {
                count += 1;
            }

            // 들고 있는 계란이 깨질 경우
            if (egg[currentEgg][0] <= 0) {
                count += 1;
            }

            dfs(currentEgg + 1, count);

            // count 원상 복구
            if (egg[i][0] <= 0) {
                count -= 1;
            }

            if (egg[currentEgg][0] <= 0) {
                count -= 1;
            }

            // 계란 원상 복구
            egg[i][0] += egg[currentEgg][1];
            egg[currentEgg][0] += egg[i][1];
        }
    }
}
