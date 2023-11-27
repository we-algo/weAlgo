import java.io.*;
import java.util.*;

public class p2251 {
    static int[] maxWater = new int[3];
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            maxWater[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[maxWater[0] + 1][maxWater[1] + 1];

        dfs(0, 0, maxWater[2]);

        StringBuilder sb = new StringBuilder();
        for (int i = maxWater[1]; i >= 0; i--) {
            if(visited[0][i]){
                sb.append(maxWater[2] - i).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void dfs(int a, int b, int c) {
        int remainA = maxWater[0] - a;
        int remainB = maxWater[1] - b;
        int remainC = maxWater[2] - c;
        if (visited[a][b]) {
            return;
        }
        visited[a][b] = true;

        if (a > 0) {
            int aToB = Math.min(remainB, a);
            dfs(a - aToB, b + aToB, c);
            int aToC = Math.min(remainC, a);
            dfs(a - aToC, b, c + aToC);
        }

        if (b > 0) {
            int bToA = Math.min(remainA, b);
            dfs(a + bToA, b - bToA, c);
            int bToC = Math.min(remainC, b);
            dfs(a, b - bToC, c + bToC);
        }

        if (c > 0) {
            int cToA = Math.min(remainA, c);
            dfs(a + cToA, b, c - cToA);
            int cToB = Math.min(remainB, c);
            dfs(a, b + cToB, c - cToB);
        }
    }
}
