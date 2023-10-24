import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P42586 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        new Solution().solution(progresses, speeds);
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++){
            int days = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            queue.add(days);
        }

        while (!queue.isEmpty()){
            int count = 0;
            int currentDay = queue.poll();
            count++;
            while (!queue.isEmpty() && queue.peek() <= currentDay){
                queue.poll();
                count++;
            }
            arrList.add(count);
        }

        int[] answer = new int[arrList.size()];

        for (int i = 0; i < answer.length; i++){
            answer[i] += arrList.get(i);
        }


        return answer;
    }
}
