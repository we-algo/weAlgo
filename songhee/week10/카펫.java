import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        answer[0]+=2;
        answer[1]+=2;
        
        for(int a2=1;a2<=yellow;a2++){ //세로
            for(int a1=1;a1<=yellow;a1++){ //가로
                if(a1*a2 == yellow && a1*2+a2*2==brown-4){
                    answer[0] += a1;
                    answer[1] += a2;
                    System.out.println(answer[0]+", "+answer[1]);
                    return answer;
                }
            }
        }
        return answer;
    }
}
