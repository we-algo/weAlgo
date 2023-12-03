import java.io.IOException;
import java.util.Scanner;

public class P17265 {
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {0, 1}; // 오른쪽
    static int[] dy = {1, 0}; // 아래쪽
    static int n;

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        String[][] map = new String[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.next();
            }

        }
        solution(map);
    }

    private static void solution(String[][] map) {
        // 시작 지점은 한개..
        int sumValue = Integer.parseInt(map[0][0]);
        dfs(0, 0, map, sumValue, "");

        System.out.print(max + " ");
        System.out.print(min);
    }

    private static void dfs(int startX, int startY, String[][] map, int sum, String operator) {
        if (startX == n - 1 && startY == n - 1) {
            if (sum > max) {
                max = sum;
            }

            if (sum < min) {
                min = sum;
            }
            return;
        }

        // visited 필요없음
        visited[startX][startY] = true;

        for (int i = 0; i < 2; i++) {
            int num1 = startX + dx[i];
            int num2 = startY + dy[i];

            if (num1 < map.length && num2 < map[0].length && !visited[num1][num2]) {
                if (map[num1][num2].matches("\\d")) { // 숫자 일 경우 값을 구해준다.
                    int num = Integer.parseInt(map[num1][num2]);
                    switch (operator) {
                        case "+":
                            dfs(num1, num2, map, sum + num, operator);
                            break;
                        case "-":
                            dfs(num1, num2, map, sum - num, operator);
                            break;
                        case "*":
                            dfs(num1, num2, map, sum * num, operator);
                            break;
                    }
                } else { // 연산자일경우 dfs로 바로 들어감
                    dfs(num1, num2, map, sum, map[num1][num2]);
                }
            }
        }

        visited[startX][startY] = false;
    }
}
