import java.io.*;
import java.util.*;

public class p18310 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] houses = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            houses[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(houses);

        System.out.println(houses[(houses.length-1)/2]);
    }
}
