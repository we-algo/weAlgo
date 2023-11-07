import java.io.*;
import java.util.*;


public class BOJ4779 {
    public static StringTokenizer st;
    public static StringBuilder sb;
    public static String[]arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String input = "";
        while((input == br.readLine()) != null && !input.isEmpty()){
            int inputInt = Integer.parseInt(input);
            int num = Math.pow(3, input);
            arr = new String[num];
            find(1, num, num);

            for(String a : arr){
                System.out.print(a);
            }
            System.out.println();
        }

    }
    public static void find(int start, int end, int num){
        if(num == 1){
            arr[start-1] = "-";
            return;
        }
        int a = start+num/3-1;
        find(start, a);
        find(start+(num/3)*2, end);
    }
}
