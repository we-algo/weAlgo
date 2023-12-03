import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1405 {
    static int N;
    static boolean[][] visited;
    // 동서남북
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static double[] per;
    static double sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N * 2 + 1][N * 2 + 1]; // 2가 들어올경우 map 너무 작음..
        per = new double[4];
        for (int i = 0; i < 4; i++){
            per[i] = Double.parseDouble(st.nextToken()) / 100;
        }

        dfs(N, N, 0, 1);
        System.out.println(sum);
    }

    private static void dfs(int startX, int startY, int depth, double result) {
        if (N == depth){
            sum += result;
            return;
        }

        visited[startX][startY] = true;


        for (int i = 0; i < 4; i++) {
            int num1 = startX + dx[i]; // 동서남북
            int num2 = startY + dy[i]; // 동서남북

            if (visited[num1][num2]){
                continue;
            }

            dfs(num1, num2, depth + 1, result * per[i]);
            visited[num1][num2] = false;
        }
//        visited[startX][startY] = false;
    }
}
