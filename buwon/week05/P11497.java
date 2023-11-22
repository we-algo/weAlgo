import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < arr.length; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            solution(n, arr);
        }
    }

    private static void solution(int n, int[] arr) {
        int[] answer = new int[n];

        Arrays.sort(arr);
        int middle = arr.length / 2;
        answer[middle] = arr[arr.length - 1]; // 가장 큰 값을 중앙에 세팅

        int index = 0;
        for (int i = 0; i < arr.length - 1; i++){
            if (i % 2 == 0){
                answer[index] = arr[i];
                index++;
            } else {
                answer[n - index] = arr[i];
            }
        }

        int max = 0;
        for (int i = 0; i < answer.length - 1; i++){
            max = Math.max(max, Math.abs(answer[i] - answer[i + 1]));
        }

        System.out.println(max);
    }
}
