import java.io.IOException;
import java.util.*;

public class P18428 {
    static int n;
    static char[][] map;
    static boolean isPossible = true;
    static String answer = "NO";
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<List<Integer>> teacherList = new ArrayList<>(); // 선생의 위치 저장
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new char[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                String s = sc.next();
                map[i][j] = s.charAt(0);
                // 선생 저장
                if (map[i][j] == 'T'){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);
                    teacherList.add(arr);
                }
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == 3){
            teachDfs();
            if (isPossible){
                answer = "YES";
            }
            return;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (map[i][j] == 'X'){
                    map[i][j] = 'O';
                    dfs(depth + 1);
                    map[i][j] = 'X';
                }
                isPossible = true;
            }
        }
    }

    private static void teachDfs() {
        for (List<Integer> teacher : teacherList) {
            int x = teacher.get(0);
            int y = teacher.get(1);
            for (int i = 0 ; i < 4; i++){
                processDirection(x, y, dx[i], dy[i]);
            }
        }
    }

    private static void processDirection(int x, int y, int dx, int dy) {
        x += dx;
        y += dy;
        while (x >= 0 && x < n && y >= 0 && y < n && map[x][y] != 'O') {
            if (map[x][y] == 'S'){
                isPossible = false;
                break;
            }
            x += dx;
            y += dy;
        }
    }
}
