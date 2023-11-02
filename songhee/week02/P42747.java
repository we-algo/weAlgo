import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int arr[] = new int[10001];
        for(int a : citations){
            arr[a]++;
        }

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
