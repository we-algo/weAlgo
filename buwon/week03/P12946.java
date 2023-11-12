import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P12946 {
    public static void main(String[] args) {
        new Solution().solution(3);
    }
}

class Solution {
    public int[][] solution(int n) {
        int[][] answer;

        Hanoi hanoi = new Hanoi(1, 3, n);
        answer = hanoi.toArray();

        System.out.println(Arrays.deepToString(answer));

        return answer;
    }
}

class Hanoi{

    int from;
    int to;
    int n;

    // 2차원 배열이 몇개 생길지 몰라 List 안에 배열 선언
    private final List<int[]> path = new ArrayList<>();

    public Hanoi(int from, int to, int n) {
        this.from = from;
        this.to = to;
        this.n = n;

        calculate(from, to, n);
    }

    // from -> empt, n-1개 이동
    // from -> to, 1개 이동
    // empty -> to, n-1개 이동


    // from = 1
    // to = 3
    // empty = 2

    // from : 시작점
    // to : 목적지
    // n : 옮길 원판 갯수
    // empty : 빈 공간

    // 이런 계산식으로 from, to, empty를 더하면 항상 6이 나온다.
    private void calculate(int from, int to, int n) {
        // 원판이 하나면 바로 3으로 가면된다.

        if (n == 1) {
            addPath(from, to);
            return;
        }

        /**
         *  from = 1
         *  to = 3
         *  empty = 2
         * 이런 계산식으로 from, to, empty를 더하면 항상 6이 나온다.
         */
        // from = 1 / to = 3 / n = 3
        // empty 빈 공간을 구한다.
        int empty = 6 - from - to;

        calculate(from, empty, n - 1);
        calculate(from, to, 1);
        calculate(empty, to, n - 1);
    }

    private void addPath(int from, int to){
        // from하고 to를 배열에 넣어줌 (출력해야하는 부분)
        path.add(new int[]{from, to});
    }

    public int[][] toArray() {
        // List<int[]> -> int[][]
        return path.stream()
                .toArray(int[][]::new);
    }
}
