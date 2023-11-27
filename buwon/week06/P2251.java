import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2251 {

    static boolean[][] visited;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        visited = new boolean[a + 1][b + 1];

        bfs(a, b, c);

        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++){
            System.out.print(answer.get(i) + " ");
        }
    }
    private static void bfs(int a, int b, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, c}); // 초기 상태

        while (!queue.isEmpty()) {
            int[] s = queue.poll();

            if (visited[s[0]][s[1]]) {
                continue; // 이미 방문한 상태라면 무시
            }

            visited[s[0]][s[1]] = true;

            if (s[0] == 0) { // a 물통이 비어있을 경우 정답 처리
                answer.add(s[2]);
            }

            moveWater(queue, s, b, 0, 1); // a -> b
            moveWater(queue, s, c, 0, 2); // a -> c
            moveWater(queue, s, a, 1, 0); // b -> a
            moveWater(queue, s, c, 1, 2); // b -> c
            moveWater(queue, s, a, 2, 0); // c -> a
            moveWater(queue, s, b, 2, 1); // c -> b
        }
    }

    private static void moveWater(Queue<int[]> queue, int[] current, int to, int fromIndex, int toIndex) {
        int[] arr = Arrays.copyOf(current, 3);
        //
        int water = Math.min(current[fromIndex], to - current[toIndex]);
        arr[fromIndex] -= water;
        arr[toIndex] += water;

        queue.add(arr);
    }
}
