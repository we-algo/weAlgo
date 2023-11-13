import java.io.*;
import java.util.*;

public class Main {
    static int[][] move = { {1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static char[][] map;
    static int x, y;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            map = new char[x][y];
            visited = new boolean[x][y];
            int count = 0;
            for(int i = 0; i < x; i++){
                map[i] = br.readLine().toCharArray();
            }

            for(int i = 0; i < x; i++){
                for(int j = 0; j < y; j++){
                    if(!visited[i][j] && map[i][j] == '#') {
                        visited[i][j] = true;
                        dfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");

        }
        System.out.println(sb);

    }

    static void dfs(int i, int j){
        for(int[] xy : move){
            int nowX = i+xy[0];
            int nowY = j+xy[1];

            if(nowX >= 0
                    && nowX < x
                    && nowY >= 0
                    && nowY < y
                    && map[nowX][nowY] == '#'
                    && !visited[nowX][nowY]){
                visited[nowX][nowY] = true;
                dfs(nowX, nowY);
            }
        }

    }
}
