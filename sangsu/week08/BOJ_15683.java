import java.io.*;
import java.util.*;

public class p15683 {

    static int n, m;
    static int minBlindSpot = Integer.MAX_VALUE;
    static final int FILLED = 9;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        ArrayList<ModeCCTV> cctvList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(new ModeCCTV(map[i][j], new int[]{i, j}));
                }
            }
        }

        fillMap(copyArray(map), cctvList, 0);

        if (minBlindSpot == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minBlindSpot);
        }


    }

    static void fillMap(int[][] prevMap, ArrayList<ModeCCTV> cctvList, int visitCount) {
        if (cctvList.size() == visitCount) {
//            minBlindSpot = Integer.min(minBlindSpot, n * m - noZeroCount - sharpCount);
            minBlindSpot = Integer.min(minBlindSpot, zeroCount(prevMap));
            return;
        }
        int[][] map;
        ModeCCTV cctv = cctvList.get(visitCount);
        int nowX = cctv.place[0];
        int nowY = cctv.place[1];
        if (cctv.mode == 5) {
            map = copyArray(prevMap);
            mapFillRight(map, nowX, nowY);
            mapFillDown(map, nowX, nowY);
            mapFillLeft(map, nowX, nowY);
            mapFillUp(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);
        } else if (cctv.mode == 2) {
            map = copyArray(prevMap);
            mapFillRight(map, nowX, nowY);
            mapFillLeft(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);

            map = copyArray(prevMap);
            mapFillDown(map, nowX, nowY);
            mapFillUp(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);
        } else if (cctv.mode == 1) {
            //초기화 시점 잘 구분하기
            map = copyArray(prevMap);
            mapFillUp(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);

            map = copyArray(prevMap);
            mapFillDown(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);

            map = copyArray(prevMap);
            mapFillLeft(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);

            map = copyArray(prevMap);
            mapFillRight(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);
        } else if (cctv.mode == 3) {
            //초기화 시점 잘 구분하기
            map = copyArray(prevMap);
            mapFillUp(map, nowX, nowY);
            mapFillRight(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);

            map = copyArray(prevMap);
            mapFillRight(map, nowX, nowY);
            mapFillDown(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);

            map = copyArray(prevMap);
            mapFillDown(map, nowX, nowY);
            mapFillLeft(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);

            map = copyArray(prevMap);
            mapFillLeft(map, nowX, nowY);
            mapFillUp(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);
        } else if (cctv.mode == 4) {
            map = copyArray(prevMap);
            mapFillLeft(map, nowX, nowY);
            mapFillUp(map, nowX, nowY);
            mapFillRight(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);

            map = copyArray(prevMap);
            mapFillUp(map, nowX, nowY);
            mapFillRight(map, nowX, nowY);
            mapFillDown(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);

            map = copyArray(prevMap);
            mapFillRight(map, nowX, nowY);
            mapFillDown(map, nowX, nowY);
            mapFillLeft(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);

            map = copyArray(prevMap);
            mapFillDown(map, nowX, nowY);
            mapFillLeft(map, nowX, nowY);
            mapFillUp(map, nowX, nowY);
            fillMap(map, cctvList, visitCount + 1);
        }
    }

    static void mapFillUp(int[][] map, int nowX, int nowY) {
        while (nowX < n) {
            nowX++;
            if (nowX < n && map[nowX][nowY] == 0) {
                map[nowX][nowY] = FILLED;
            }
            if(nowX < n && map[nowX][nowY] == 6){
                return;
            }
        }
    }

    static void mapFillDown(int[][] map, int nowX, int nowY) {
        while (nowX >= 0) {
            nowX--;
            if (nowX >= 0 && map[nowX][nowY] == 0) {
                map[nowX][nowY] = FILLED;
            }
            if(nowX >= 0 && map[nowX][nowY] == 6){
                return;
            }
        }
    }

    static void mapFillLeft(int[][] map, int nowX, int nowY) {
        while (nowY >= 0) {
            nowY--;
            if (nowY >= 0 && map[nowX][nowY] == 0) {
                map[nowX][nowY] = FILLED;
            }
            if(nowY >= 0 && map[nowX][nowY] == 6){
                return;
            }
        }
    }

    static void mapFillRight(int[][] map, int nowX, int nowY) {
        while (nowY < m) {
            nowY++;
            if (nowY < m && map[nowX][nowY] == 0) {
                map[nowX][nowY] = FILLED;
            }
            if(nowY < m && map[nowX][nowY] == 6){
                return;
            }
        }
    }

    private static class ModeCCTV {
        int mode;
        int[] place;
        boolean visited = false;

        ModeCCTV(int mode, int[] place) {
            this.mode = mode;
            this.place = place;
        }

        public void trueSet() {
            visited = true;
        }

        public void falseSet() {
            visited = false;
        }

        public boolean isVisited() {
            return visited;
        }

    }

    static int[][] copyArray(int[][] a) {
        int[][] newArray = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                newArray[i][j] = a[i][j];
            }
        }

        return newArray;
    }

    static int zeroCount(int[][] map) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
