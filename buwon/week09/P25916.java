import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(m, arr);
    }

    private static void solution(int m, int[] arr) {
        int start = 0;
        int end = 0;
        int sum = 0;

        while (end < n) {
            if (sum <= m && sum + arr[end] <= m){
                sum += arr[end];
                max = Math.max(max, sum);
                end++;
            } else {
                sum -= arr[start];
                start++;
            }
        }
        System.out.println(max);
    }
}
