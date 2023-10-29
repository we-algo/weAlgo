import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++){
            int[] inArr = commands[i];
            List<Integer> arrList = new ArrayList<>();

            for (int j = inArr[0] - 1; j <= inArr[1] - 1; j++){
                arrList.add(array[j]);
            }

            Collections.sort(arrList);
            answer[i] += arrList.get(inArr[2] - 1);
        }

        return answer;
    }
}
