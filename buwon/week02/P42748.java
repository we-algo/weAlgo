import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++){
            int[] inArr = commands[i];
            int[] start = new int[commands[i].length];
            List<Integer> arrList = new ArrayList<>();

            for (int j = 0; j < inArr.length; j++){
                start[j] += inArr[j];
            }

            for (int j = start[0] - 1; j <= start[1] - 1; j++){
                arrList.add(array[j]);
            }

            Collections.sort(arrList);
            answer[i] += arrList.get(start[2] - 1);
        }

        return answer;
    }
}
