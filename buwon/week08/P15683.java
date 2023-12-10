import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P15683 {
    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] map;

    // cctv 이동 위치
    static int[] cctvDirs = {0, 4, 2, 4, 4, 1};

    static List<List<Integer>> arrList = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    List<Integer> temp = new ArrayList<>();
                    // cctv가 있는 위치만 저장하기 위한 로직
                    temp.add(i);
                    temp.add(j);
                    arrList.add(temp);
                }
                if (map[i][j] != 0){
                    visited[i][j] = true;
                }
            }
        }

        dfs(0);
        System.out.println(min);
    }

    // dfs 탐색
    private static void dfs(int depth) {
        if (depth == arrList.size()) {
            min = Math.min(min, count());
            return;
        }

        List<Integer> cctvList = arrList.get(depth);
        int startX = cctvList.get(0);
        int startY = cctvList.get(1);

        int cctvType = map[startX][startY];
        boolean[][] tempVisited = new boolean[n][m];
        // visited -> tempVisited 복사
        copy(tempVisited, visited);

        /**
         * [false, false, false, false, false, false],
         * [false, false, false, false, false, false],
         * [false, false, true, false, true, false],
         * [false, false, false, false, false, false]
         */
        // cctv 순회
        for (int i = 0; i < cctvDirs[cctvType]; i++) {
            monitor(cctvList, i);
            dfs(depth + 1);
            // tempVisited -> visited 복사 (다시 -1가 없는 깨끗한 배열로 만들기 위해서 넣어준다)
            copy(visited, tempVisited);
        }
    }

    private static void copy(boolean[][] tempVisited, boolean[][] visited) {
        for (int i = 0; i < n; i++){
            tempVisited[i] = visited[i].clone();
        }
    }

    private static int count() {
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (!visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }


    // cctvType 찾아가기
    private static void monitor(List<Integer> cctvList, int cctvDir) {
        int cctvType = map[cctvList.get(0)][cctvList.get(1)];
        switch (cctvType){
            case 1:
                cctvType1(cctvList, cctvDir);
                break;
            case 2:
                cctvType2(cctvList, cctvDir);
                break;
            case 3:
                cctvType3(cctvList, cctvDir);
                break;
            case 4:
                cctvType4(cctvList, cctvDir);
                break;
            case 5:
                cctvType5(cctvList, cctvDir);

        }
    }

    // cctv 타입에 맞는 위치 순회 ( 1은 동서남북 / 2는 동서, 북남 / 3 동서남북 / 4 동서남북 / 5 는 한번만 순회)
    private static void cctvType1(List<Integer> cctvList, int cctvDir) {
        switch (cctvDir){
            case 0:
                up(cctvList);
                break;
            case 1:
                down(cctvList);
                break;
            case 2:
                left(cctvList);
                break;
            case 3:
                right(cctvList);
        }

    }

    private static void cctvType2(List<Integer> cctvList, int cctvDir) {
        switch (cctvDir){
            // 상하
            case 0:
                up(cctvList);
                down(cctvList);
                break;
            // 좌우
            case 1:
                left(cctvList);
                right(cctvList);
                break;
        }
    }

    private static void cctvType3(List<Integer> cctvList, int cctvDir) {
        switch (cctvDir){
            // 북동
            case 0:
                up(cctvList);
                right(cctvList);
                break;
            // 동남
            case 1:
                right(cctvList);
                down(cctvList);
                break;
            // 남서
            case 2:
                down(cctvList);
                left(cctvList);
                break;
            // 북서
            case 3:
                left(cctvList);
                up(cctvList);
        }
    }

    private static void cctvType4(List<Integer> cctvList, int cctvDir) {
        switch (cctvDir){
            case 0:
                left(cctvList);
                up(cctvList);
                right(cctvList);
                break;
            case 1:
                up(cctvList);
                right(cctvList);
                down(cctvList);
                break;
            case 2:
                right(cctvList);
                down(cctvList);
                left(cctvList);
                break;
            case 3:
                down(cctvList);
                left(cctvList);
                up(cctvList);
                break;
        }
    }

    private static void cctvType5(List<Integer> cctvList, int cctvDir) {
        up(cctvList);
        right(cctvList);
        down(cctvList);
        left(cctvList);
    }

    private static void processDirection(List<Integer> cctvList, int dx, int dy) {
        int startX = cctvList.get(0);
        int startY = cctvList.get(1);

        int x = startX + dx;
        int y = startY + dy;

        while (x >= 0 && x < n && y >= 0 && y < m && map[x][y] != 6) {
            if (map[x][y] == 0) {
                visited[x][y] = true;
            }
            x += dx;
            y += dy;
        }
    }

    private static void right(List<Integer> cctvList) {
        processDirection(cctvList, 0, 1);
    }

    private static void left(List<Integer> cctvList) {
        processDirection(cctvList, 0, -1);
    }

    private static void down(List<Integer> cctvList) {
        processDirection(cctvList, 1, 0);
    }

    private static void up(List<Integer> cctvList) {
        processDirection(cctvList, -1, 0);
    }
}
