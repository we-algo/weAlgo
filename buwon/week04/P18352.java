import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 인접 노드를 나타내기 위한 graph 추가!
            graph.get(a).add(b);
        }

        solution(n, m, k, x, graph);
    }

    private static void solution(int n, int m, int k, int x, List<List<Integer>> graph) {
        Integer[] distances = new Integer[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE); // 가장 큰 값으로 세팅
        distances[x] = 0;

        System.out.println(Arrays.toString(distances));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(x);

        while (!pq.isEmpty()) {
            int num = pq.poll();

            for (int city : graph.get(num)) {
                int newDistance = distances[num] + 1;
                if (newDistance < distances[city]) {
                    distances[city] = newDistance;
                    System.out.println(Arrays.toString(distances));
                    pq.add(city);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        System.out.println(Arrays.toString(distances));
        for (int i = 1; i <= n; i++) {
            if (distances[i] == k) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(result);
            for (int node : result) {
                System.out.println(node);
            }
        }
    }
}
