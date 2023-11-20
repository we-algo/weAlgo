import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class P18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(arr);
    }

    private static void solution(int[] arr) {
        // 정답 코드
//        Arrays.sort(arr);
//        if (arr.length % 2 == 0){
//            System.out.println(arr[arr.length / 2 - 1]); [1 5 7 9 ]
//        } else {
//            System.out.println(arr[arr.length / 2]);
//        }

        long answer = 0;

        Arrays.sort(arr);

        if (arr.length == 1){
            System.out.println(arr[0]);
        } else {
            long min = Integer.MAX_VALUE;
            // 인덱스 구하는 부분이 틀렸음!
            int middleIdx = arr.length / 2 - 1;
//            int middle = arr[arr.length / 2 - 1];


            int count = 0;
            while (count != 2) {
                count++;
                long sum = 0;
                for (long num : arr) {
                    sum += Math.abs(num - arr[middleIdx]);
                }

                if (sum < min) {
                    min = sum;
                    answer = arr[middleIdx];
                }

                middleIdx++;
            }

            System.out.println(answer);
        }
    }
}
