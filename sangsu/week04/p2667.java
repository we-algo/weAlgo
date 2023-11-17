import java.io.*;
import java.util.*;

public class Main {
    static int[][] move = {{0,1}, {0,-1}, {1, 0}, {-1,0}};
    static char[][] map;
    static boolean[][] visited;
    static int depth;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
        }
        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && map[i][j] == '1'){
                    depth = 1;
                    dfs(i, j);
                    if(depth >= 1) {
                        answerList.add(depth);
                    }
                }
            }

        }

        Collections.sort(answerList);

        StringBuilder sb= new StringBuilder();
        sb.append(answerList.size()).append("\n");
        for(int num : answerList){
            sb.append(num).append("\n");
        }
        System.out.println(sb);

    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int[] xy : move){
            int nowX = x + xy[0];
            int nowY = y + xy[1];
            if(nowX >= 0 && nowY >= 0 && nowX < n && nowY < n && !visited[nowX][nowY] && map[nowX][nowY] == '1'){
                depth++;
                dfs(nowX, nowY);
            }
        }
    }
}
