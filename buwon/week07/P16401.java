import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16401 {
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        solution(m, arr);
    }

    private static void solution(int m, int[] arr) {
        Arrays.sort(arr);

        binarySearch(m, arr);
        int i = Arrays.binarySearch(arr, m);
    }

    private static void binarySearch(int m, int[] arr) {
        int left = 1; // 0
        int right = arr[arr.length - 1];
        while (left <= right) {
            int middle = (left + right) / 2;
            int sum = calculate(arr, middle);

            if (sum >= m){
                max = Math.max(middle, max);
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        System.out.println(max);
    }

    private static int calculate(int[] arr, int middle) {
        int candySum = 0;
        for (int candy : arr) {
            candySum += candy / middle;
        }

        return candySum;
    }
}
