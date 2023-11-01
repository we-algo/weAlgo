import java.util.*;
import java.lang.*;

class Solution {
    public static String finalS = "";
    public static String s = "";

    public String solution(int[] numbers) {
        boolean visit[] = new boolean[numbers.length];
        String answer = "";
        int finalNum = 0;

        for(int i=1;i<=numbers.length;i++){
            find(0, i, 0, visit, numbers.length, numbers);
        }

        return finalS;
    }
    
    public static void find(int index, int count, int nowCount, boolean []visit, int numbersLen, int[] numbers){
        if(count == nowCount){
            int finalLen = 0;
            int len1 = s.length();
            int len2 = finalS.length();

            if(len2 == 0){
                finalS = s;
                return;
            }

            for(int i=0;i<s.length();i++){
                if(i+1 > finalS.length()){
                    finalS = s;
                    break;
                }

                if(Character.getNumericValue(finalS.charAt(i))<
                        Character.getNumericValue(s.charAt(i))){
                    finalS = s;
                    break;
                }


            }
            return;
        }

        for(int i=index;i<numbersLen;i++){
            if(!visit[i]){
                visit[i] = true;
                String oldString = s;
                s += numbers[i];
                find(i+1, count, nowCount+1, visit, numbersLen, numbers);
                s = oldString;
                visit[i] = false;
            }
        }
    }
}
