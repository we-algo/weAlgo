import java.util.*;

class p12946 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(3)));
    }
    static ArrayList<int[]> results;

    public static int[][] solution(int n) {
        results = new ArrayList<>();

        hanoi(n, 1, 3, 2);

        int[][] answer = new int[results.size()][2];
        for(int i = 0 ; i < results.size() ; ++i){
            int[] cmd = results.get(i);
            answer[i][0] = cmd[0];
            answer[i][1] = cmd[1];
        }

        return answer;
    }

    private static void hanoi(int n, int start, int end, int centers){
        int[] move = {start, end};

        if(n == 1) {
            results.add(move);
            return;
        }

        hanoi(n - 1, start, centers, end);
        results.add(move);
        hanoi(n - 1, centers, end, start);

    }
}
