import java.io.*;
import java.util.*;

public class p25916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        //8 10
        //2 2 2 2 11 2 5 2
        //9

        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;
        while (right < n) {
            if (count +a[right] <= m) {
                count += a[right];
                max = Integer.max(max, count);
                right++;
            }else{
                count -= a[left];
                left++;
            }
        }

        System.out.println(max);

    }
}
