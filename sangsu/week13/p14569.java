package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p14569_2 {
    //1, 2, 3, 4
    //01111 => 인덱스로 생각
    //이걸 비트로 어케만드냐 => 1 << i

    //1, 2, 3, 4, 5, 6, 7, 8
    //011111111
    //두개를 and연산해서 확인
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n+1];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int subjectSize = Integer.parseInt(st.nextToken());
            for(int j = 0; j < subjectSize; j++) {
                int subject = Integer.parseInt(st.nextToken());
                a[i] |= 1L <<subject;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int studentSize = Integer.parseInt(st.nextToken());
            long student = 0;
            for(int j= 0; j < studentSize; j++){
                long time = Integer.parseInt(st.nextToken());
                student |= 1L << time;
            }

            student = ~student;

            int count = 0;
            for(int j= 0; j < n; j++){
                if((student & a[j]) == 0){
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
