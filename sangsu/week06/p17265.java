package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p17265 {

    static final int[][] move = {{1, 0}, {0, 1}};
    static char[][] map;
    //    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n + 1][n + 1];
//        visited = new boolean[n + 1][n + 1];
        //이후 getNumericValue를 통해서 숫자 받아오자
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(1, 1, Character.getNumericValue(map[1][1]), Optional.empty());

        System.out.printf("%d %d", max, min);

    }

    static void dfs(int x, int y, int sum, Optional<Character> operator) {


        if (x == n && y == n) {
            max = Integer.max(max, sum);
            min = Integer.min(min, sum);
            return;
        }

        for (int[] movingXY : move) {
            int nowX = x + movingXY[0];
            int nowY = y + movingXY[1];
            if (nowX >= 1 && nowY >= 1 && nowX <= n && nowY <= n) {
                if (operator.isPresent()) {
                    dfs(nowX, nowY,
                            operatorCalc(sum,
                                    Character.getNumericValue(map[nowX][nowY]),
                                    operator.get()
                            ),
                            Optional.empty());
                } else {
                    dfs(nowX, nowY,
                            sum, Optional.of(map[nowX][nowY]));
                }
            }
        }
    }

    static int operatorCalc(int a, int b, char c) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return -1;
        }
    }
}
