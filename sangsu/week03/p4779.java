import java.io.*;

public class Main {
    static final String STRING_HYPHEN = "-";
    static StringBuilder cantorStrings;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int n;
        StringBuilder sb  =new StringBuilder();

        while((s = br.readLine()) != null && !s.isEmpty()){
            n = Integer.parseInt(s);

            if(n == 0){
                sb.append("-").append("\n");
                continue;
            }

            cantorStrings = new StringBuilder();
            cantorStrings.append(STRING_HYPHEN.repeat((int)Math.pow(3,n)));

            cantorController(0, cantorStrings.length());

            sb.append(cantorStrings).append("\n");

        }
        sb.setLength(sb.length()-1);

        System.out.println(sb);
    }

    static void cantorController(int start, int end){
        if(end-start <= 1){
            return;
        }

        int sliceOne = start+(end-start)/3;
        int sliceTwo = start+(end-start)/3*2;

        cantorDivide(sliceOne, sliceTwo);

        cantorController(start, start+(end-start)/3);
        cantorController(start + (end-start)/3*2,end);

    }

    static void cantorDivide(int start, int end){
        if(start >= end){
            return;
        }
        cantorStrings.replace(start, end, " ".repeat(end-start));
    }
}
