import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11123 {
    static boolean[][] visited;
    static int x, y;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            char[][] chars = new char[x][y];
            visited = new boolean[x][y];

            for (int j = 0; j < x; j++){
                chars[j] = br.readLine().toCharArray();
            }

            int result = solution(chars);

            System.out.println(result);
        }
    }

    private static int solution(char[][] chars) {
        int count = 0;
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                if (chars[i][j] == '#'){
                    if (!visited[i][j]){
                        count++;
                        bfs(chars, i, j);
                    }
                }
            }
        }
        return count;
    }

    private static void bfs(char[][] chars, int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()){
            int[] s = queue.poll();

            for (int i = 0; i < 4; i++){ // 동서남북 체크 [동, 남, 서, 북]
                // static int dx[] = {0, 1, 0, -1};
                // static int dy[] = {1, 0, -1, 0};
                int num1 = s[0] + dx[i];
                int num2 = s[1] + dy[i];

                // 경계값을 벗어나지 않으면서 방문하지 않았고, 양인것을 찾는다.
                if (0 <= num1 && num1 < x && 0 <= num2 && num2 < y && !visited[num1][num2] && chars[num1][num2] == '#'){
                    queue.add(new int[]{num1, num2});
                    visited[num1][num2] = true;
                }
            }
        }
    }
}
