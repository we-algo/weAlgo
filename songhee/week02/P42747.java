import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int arr[] = new int[10001];
        for(int a : citations){
            arr[a]++;
        }

        /*
        [6,5,4,1,1,1]
   arr[]:0 1 2 3 4 5 6.... 10000
           3     1 1 1
     sum:  4     3 2 1

        */
         */
         */

        int sum = 0;
        int minus = 0;

        for(int j=10000;j>=0;j--){
            sum += arr[j];
            if(sum >= j){
                return j;
            }
        }
        return 0;
    }
}
