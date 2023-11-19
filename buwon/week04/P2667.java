import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2667 {
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int countRally;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
        }

        solution(map);
    }

    private static void solution(char[][] map) {
        StringBuilder sb = new StringBuilder();
        List<Integer> arrList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                if (!visited[i][j]){
                    if (map[i][j] == '1'){
                        countRally = 1;
//                        int bfsCount = bfs(map, i, j);
                        int dfsCount = dfs(map, i, j);
//                        arrList.add(bfsCount);
                        arrList.add(dfsCount);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        Collections.sort(arrList);
        for (Integer num : arrList) {
            sb.append(num).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int dfs(char[][]map, int startX, int startY){
        visited[startX][startY] = true;

        for (int i = 0; i < 4; i++){
            int num1 = startX + dx[i];
            int num2 = startY + dy[i];

            if (num1 >= 0 && num1 < map.length && num2 >= 0 && num2 < map.length && !visited[num1][num2] && map[num1][num2] == '1'){
                visited[num1][num2] = true;
                countRally++;
                dfs(map, num1, num2);
            }
        }

        return countRally;
    }

//    private static int bfs(char[][] map, int startX, int startY) {
//        visited[startX][startY] = true;
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{startX, startY});
//
//        int countRally = 1;
//        while (!queue.isEmpty()){
//            int[] s = queue.poll();
//
//            for (int i = 0; i < 4; i++){
//                int num1 = s[0] + dx[i];
//                int num2 = s[1] + dy[i];
//
//                if (num1 >= 0 && num1 < map.length && num2 >= 0 && num2 < map.length && !visited[num1][num2] && map[num1][num2] == '1'){
//                    visited[num1][num2] = true;
//                    queue.add(new int[]{num1, num2});
//                    countRally++;
//                }
//            }
//
//        }
//        return countRally;
//    }
}
