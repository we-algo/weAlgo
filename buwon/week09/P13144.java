import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(arr);
    }

    /**
     * 메모리 초과
     * 추후에 다시 풀기..
     */
    private static void solution(int[] arr) {
        int count = 0;

        Set<Integer> list = new HashSet<>();
        for (int start = 0; start < n; start++) {
            int end = start;

            while (end < n && !list.contains(arr[end])) {
                list.add(arr[end]);
                end++;
            }

            count += end - start;
            list.clear();
        }

        System.out.println(count);
    }
}
