import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P2866 {
    static int count;
    static int r;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        char[][] chars = new char[r][c];
        for (int i = 0; i < r; i++) {
            chars[i] = br.readLine().toCharArray();
        }

        solution(chars);
    }

    private static void solution(char[][] chars) {
        String[] str = new String[c];

        for (int i = 0; i < c; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < r; j++) {
                sb.append(chars[j][i]);
            }
            str[i] = sb.toString();
        }

        System.out.println(Arrays.toString(str));
        // [da, od, ba, at, ra, zk]

        subString(str);

        System.out.println(count);
    }

    private static void subString(String[] str) {
        for (int i = 0; i < r; i++){
            Set<String> set = new HashSet<>();
            for (int j = 0; j< c; j++){
                String s = str[j].substring(i);
                set.add(s);
            }
            if (set.size() == c){
                count++;
            }
        }
    }
}
