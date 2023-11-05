import java.util.*;
class Solution {
    public static int targetCount, targetNum, idxArr[];
    public static boolean visit[];
    public static int answer = 0, numbersLen, numCopy[];
    public int solution(int[] numbers, int target) {
        targetNum = target;
        numbersLen = numbers.length;

        for(int i=1;i<=numbersLen;i++){
            idxArr = new int[numbers.length];
            numCopy = numbers.clone();
            targetCount = i;
            visit = new boolean[numbers.length];
            find(0, 0);
        }

        return answer;
    }
    public static void find(int count, int idx){
        if(count == targetCount){
            int totalSum = 0;
            for(int a : numCopy){
                totalSum += a;
            }

            if(totalSum == targetNum){
                answer++;
            }
            return;
        }

        for(int i=idx;i<numbersLen;i++){
            if(count == 0 || (count != 0 && idxArr[count-1] < i)) {
                if(!visit[i]){
                    visit[i] = true;
                    numCopy[i] *= -1;
                    idxArr[count] = i;
                    find(count+1, idx+1);
                    numCopy[i] *= -1;
                    visit[i] = false;
                }
            }
        }
    }
}
