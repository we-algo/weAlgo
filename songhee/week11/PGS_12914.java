import java.util.*;
class Solution {
    static long dp[];
    public long solution(int n) {
        
        dp = new long[2001];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        
        for(int i=4;i<=n;i++){
            dp[i] = dp[i-1]%1234567 + dp[i-2]%1234567;
        }
        
        return dp[n]%1234567;
    }
}
