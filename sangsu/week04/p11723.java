import java.io.*;
import java.util.*;

public class p11725 {
    static boolean[] visited;
    static ArrayList<Integer>[] al;
    static ArrayList<Integer>[] childList;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        al = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        childList = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            al[i] = new ArrayList<>();
            childList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        int a, b;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            al[b].add(a);
            al[a].add(b);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < n+1; i++) {
            sb.append(childList[i].get(0)).append("\n");
        }
        System.out.println(sb);

    }

    static void dfs(int n) {
        for (int num : al[n]) {
            if (!visited[num]) {
                visited[num] = true;
                childList[num].add(n);
                dfs(num);
            }
        }
    }
}
