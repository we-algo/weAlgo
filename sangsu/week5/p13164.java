import java.io.*;
import java.util.*;

public class p13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> al = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            al.add(Integer.parseInt(st.nextToken()));
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }
//        5 3
//        1 3 5 6 10
        int maxLevel = 0;
        int temp = al.get(al.size() - 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = al.size() - 2; i >= 0; i--) {
            pq.add(temp - al.get(i));
            temp = al.get(i);
        }

        for (int i = 0; i < k-1; i++) {
            pq.poll();
        }
        System.out.println(pq.stream().mapToInt(Integer::intValue).sum());
    }
}
