import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        Queue<Integer> idxQ = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int a : priorities){
            list.add(a);
            idxQ.add(idx++);
            queue.add(a);
        }
        Collections.sort(list);
        Collections.reverse(list);
        int listIdx = 0;
        int turn = 1;
        while(!queue.isEmpty()){
            int pollNum = queue.poll();
            int pollIdx = idxQ.poll();
            if(list.get(listIdx) == pollNum){
                listIdx++;

                if(pollIdx == location) {
                    return turn;
                }
                turn++;
            }else {
                queue.add(pollNum);
                idxQ.add(pollIdx);
            }

        }
        return 1;
    }
}