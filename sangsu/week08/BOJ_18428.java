import java.io.*;
import java.util.*;

public class p18428 {

    static int n;
    static boolean success = false;
    static ArrayList<int[]> teacherPoint = new ArrayList<>();
    static char[][] checkMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        char[][] a = new char[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = st.nextToken().charAt(0);
                if (a[i][j] == 'T') {
                    teacherPoint.add(new int[]{i, j});
                }
            }
        }

        //T : 선생 | O : 장애물 | S : 학생
        dfs(a, 0);

        if (success) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static void dfs(char[][] prevMap, int depth) {
        if (depth == 3) {
            checkMap = prevMap;
            if (noTeacher()) {
                success = true;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (prevMap[i][j] == 'X') {
                    char[][] map = copyMap(prevMap);
                    map[i][j] = 'O';
                    dfs(map, depth + 1);
                }
            }
        }
    }

    static char[][] copyMap(char[][] a) {
        char[][] temp = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = a[i][j];
            }
        }
        return temp;
    }

    static boolean noTeacher() {
        boolean flag = false;
        for (int[] teacher : teacherPoint) {
            int nowX = teacher[0];
            int nowY = teacher[1];
            if (!flag) {
                if (leftGo(nowX, nowY)) {
                    flag = true;
                }
            }
            if (!flag) {
                if (rightGo(nowX, nowY)) {
                    flag = true;
                }
            }
            if (!flag) {
                if (upGo(nowX, nowY)) {
                    flag = true;
                }
            }
            if (!flag) {
                if (downGo(nowX, nowY)) {
                    flag = true;
                }
            }
        }
        if(flag){
            return false;
        }
        return true;
    }

    static boolean leftGo(int x, int y) {
        x--;
        while (x >= 0) {
            if (checkMap[x][y] == 'S') {
                return true;
            }
            if(checkMap[x][y] == 'O'){
                return false;
            }
            x--;
        }
        return false;
    }

    static boolean rightGo(int x, int y) {
        x++;
        while (x < n) {
            if (checkMap[x][y] == 'S') {
                return true;
            }
            if(checkMap[x][y] == 'O'){
                return false;
            }
            x++;
        }
        return false;
    }

    static boolean upGo(int x, int y) {
        y--;
        while (y >= 0) {
            if (checkMap[x][y] == 'S') {
                return true;
            }
            if(checkMap[x][y] == 'O'){
                return false;
            }
            y--;
        }
        return false;
    }

    static boolean downGo(int x, int y) {
        y++;
        while (y < n) {
            if (checkMap[x][y] == 'S') {
                return true;
            }
            if(checkMap[x][y] == 'O'){
                return false;
            }
            y++;
        }
        return false;
    }
}
