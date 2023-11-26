import java.util.*;
import java.io.*;

public class boj2251 {
    static int A, B, C;
    static boolean[][] visited;
    static boolean[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        visited = new boolean[201][201];
        answer = new boolean[201];

        dfs(0, 0, C);

        for (int i = 0; i <= 200; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void dfs(int a, int b, int c) {
        if (visited[a][b]) {
            return;
        }

        visited[a][b] = true;
        if (a == 0) {
            answer[c] = true;
        }

        // A -> B
        if (a + b > B) {
            dfs((a + b) - B, B, c);
        } else {
            dfs(0, a + b, c);
        }
        // A -> C
        if (a + c > C) {
            dfs((a + c) - C, b, C);
        } else {
            dfs(0, b, a + c);
        }
        // B -> A
        if (b + a > A) {
            dfs(A, (a + b) - A, c);
        } else {
            dfs(a + b, 0, c);
        }
        // B -> C
        if (b + c > C) {
            dfs(a, (b + c) - C, C);
        } else {
            dfs(a, 0, b + c);
        }
        // C -> A
        if (c + a > A) {
            dfs(A, b, (a + c) - A);
        } else {
            dfs(a + c, b, 0);
        }
        // C -> B
        if (c + b > B) {
            dfs(a, B, (c + b) - B);
        } else {
            dfs(a, c + b, 0);
        }
    }
}
