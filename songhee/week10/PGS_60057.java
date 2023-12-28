import java.util.*;
class Solution {
    static int minCount = 1000;
    static String sc;
    public int solution(String s) {
        int answer = 0;
        
        for(int i=s.length();i>=1;i--){
            sc = check(i, s);
            minCount = Math.min(minCount, sc.length());
        }
        
        return minCount;
    }
    public static String check(int len, String s){
        String answer = "";
        int end = 0;
        int cnt = 1;
        String standard = "";
        String compare = "";
        for(int i=0;i<s.length();){
             end = i+len;
            if(standard.equals("")){
                if(end>=s.length()){
                    compare = s.substring(i, s.length());
                    if(cnt == 1) answer+=standard+compare;
                    else answer+=cnt+standard+compare;
                    break;
                }
                standard = s.substring(i, end);
                cnt = 1;
                i += len;
                continue;
            }
            
            if(end>=s.length()){
                compare = s.substring(i, s.length());
                if(compare.equals(standard)){
                    cnt++;
                    answer += cnt+standard;
                    break;
                }
                
                if(cnt==1) answer+=standard+compare;
                else answer+=cnt+standard+compare;
                break;
            }
            
            compare = s.substring(i, end);
            if(compare.equals(standard)){
                cnt++;
                i += len;
                continue;
            }
            
            if(cnt == 1) answer += standard;
            else answer += cnt+standard;
            standard = "";
       }
        
        return answer;
    }
}
