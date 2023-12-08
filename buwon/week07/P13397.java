import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 풀이 참조
 */
public class P13397 {
    static int[] arr;
    static int n;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }

        binarySearch(m);
    }

    private static void binarySearch(int m) {
        int left = 1;
        int right = max - min;

        while (left <= right){
            int middle = (left + right) / 2;
            if (divideMid(middle, m)){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        System.out.println(left);
    }

    private static boolean divideMid(int middle, int m) {
        int countSet = 1;

        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if ((max - min) > middle){
                min = arr[i];
                max = arr[i];
                countSet++;
                if (countSet > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
