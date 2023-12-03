package Baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 경로가 겹쳤을 때의 모든 경우가 단순하지 않음
 * movePercent[] { 동, 서, 남, 북 }
 */
public class p1405 {
    //    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] map = new boolean[202][202];
    static double[] movePercent = new double[4];
    static int n;
    static double easyRoadPercent = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        movePercent = new double[4];
        for (int i = 0; i < movePercent.length; i++) {
            movePercent[i] = Double.parseDouble(st.nextToken())/100.0;
        }

        map[101][101] = true;
        dfs(101, 101, 0, 1.0);

        /**
         * 25 25 25 25일때
         * 3 3 3 3
         * 12
         * 2^4
         * 0.75
         */
        System.out.println(easyRoadPercent);

    }

    static void dfs(int x, int y, int depth, double percent) {
        if (depth == n) {
            easyRoadPercent+= percent;
            return;
        }

        //0 : 동 | 1 : 서 | 2 : 남 | 3 : 북
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0 -> {
                    if (movePercent[i] > 0) {
                        if (!map[x+1][y]) {
                            map[x+1][y] = true;
                            dfs(x + 1, y, depth + 1, percent * movePercent[i]);
                            map[x+1][y] = false;
                        }
                    }
                }
                case 1 -> {
                    if (movePercent[i] > 0) {
                        if (!map[x-1][y]) {
                            map[x-1][y] = true;
                            dfs(x - 1, y, depth + 1, percent * movePercent[i]);
                            map[x-1][y] = false;
                        }
                    }
                }
                case 2 -> {
                    if (movePercent[i] > 0) {
                        if (!map[x][y+1]) {
                            map[x][y+1] = true;
                            dfs(x, y + 1, depth + 1, percent * movePercent[i]);
                            map[x][y+1] = false;
                        }
                    }
                }
                case 3 -> {
                    if (movePercent[i] > 0) {
                        if (!map[x][y-1]) {
                            map[x][y-1] = true;
                            dfs(x, y - 1, depth + 1, percent * movePercent[i]);
                            map[x][y-1] = false;
                        }
                    }
                }
            }
        }
    }
}
