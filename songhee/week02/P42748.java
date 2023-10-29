import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int index = 0;
        for(int i=0;i<commands.length;i++){
            int[]arr = commands[i];
            int start = arr[0]-1;
            int end = arr[1]-1;
            int idx = arr[2]-1;

            List<Integer> list = new ArrayList<>();
            for(int j=start;j<=end;j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[index++] = list.get(idx);
        }
        return answer;
    }
}