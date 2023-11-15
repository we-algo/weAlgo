import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, x;
    static ArrayList<Integer>[] al;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        al = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            al[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a, b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            al[a].add(b);
        }


        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        queue.add(-1);
        visited[x] = true;
        List<Integer> answerList = new ArrayList<>();
        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == -1) {
                if (!queue.isEmpty()) {
                    queue.add(-1);
                    count++;
                }
                continue;
            }
            for (int node : al[now]) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    if (count == k - 1) {
                        answerList.add(node);
                    }
                }
            }
        }

        Collections.sort(answerList);
        if (answerList.isEmpty()) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : answerList) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}
