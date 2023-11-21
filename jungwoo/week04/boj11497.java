import java.io.*;
import java.util.*;

class boj11497 {

	public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int COUNT = Integer.parseInt(br.readLine());
        for (int t = 0; t < COUNT; t++) {
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }

            int[] result = new int[N];
            int start = 0;
            int end = result.length - 1;

            boolean flag = true;
            while (!pq.isEmpty()) {
                if (flag) {
                    result[start++] = pq.poll();
                } else {
                    result[end--] = pq.poll();
                }
                flag = !flag;
            }

            int max = Math.abs(result[0] - result[N - 1]);
            for (int i = 1; i < N; i++) {
                max = Math.max(Math.abs(result[i] - result[i - 1]), max);
            }
            bw.write(max + "\n");
        }
        bw.close();
        br.close();
    }

}
