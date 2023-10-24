import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> list = new ArrayList<>();

        for(int i = 0;i<progresses.length;i++){
            int restProgress = (100-progresses[i]);
            if(restProgress%speeds[i] != 0){
                list.add(restProgress/speeds[i]+1);
            }else
                list.add(restProgress/speeds[i]);
        }

        int count = 1;
        int index = 0;
        List<Integer> answer = new ArrayList<>();
        for(int i=1;i<list.size();i++){
            if(list.get(index)>=list.get(i)){
                count++;
            }else{
                answer.add(count);
                count = 1;
                index = i;
            }
        }
        answer.add(count);
        int answerArr[] = new int[answer.size()];

        for(int i=0;i<answer.size();i++){
            answerArr[i] = answer.get(i);
        }
        return answerArr;
    }
}