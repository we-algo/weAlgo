import java.util.*;

public class P42587 {
    public static void main(String[] args) {
//        int[] arr = {2, 1, 3, 2};
        int[] arr = {1, 1, 9, 1, 1, 1};
//        int[] arr = {2, 1, 2, 1, 2, 1, 2, 1, 2}; // lcation = 1 // answer = 6
        new Solution().solution(arr, 0);
    }
}


class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐를 내림차순으로 설정

        for (int i = 0; i < priorities.length; i++) {
            queue.add(i);
            priorityQueue.add(priorities[i]);
        }

        // queue :    0 1 2 3 4 5
        // priQueue : 9 1 1 1 1 1

        // 1
        // priorities 1 1 9 1 1 1
        // queue :    1 2 3 4 5 0
        // priQueue : 9 1 1 1 1 1

        // 2
        // priorities 1 1 9 1 1 1
        // queue :    2 3 4 5 0 1
        // priQueue : 9 1 1 1 1 1
        // answer = 0;

        // 3
        // priorities 1 1 9 1 1 1
        // queue :    2 3 4 5 0 1
        // priQueue : 9 1 1 1 1 1
        // answer = 0;

        // 4
        // priorities 1 1 9 1 1 1
        // queue :    3 4 5 0 1
        // priQueue : 1 1 1 1 1
        // answer = 1;

        // 5
        // priorities 1 1 9 1 1 1
        // queue :    4 5 0 1
        // priQueue : 1 1 1 1
        // answer = 2;

        // 6
        // priorities 1 1 9 1 1 1
        // queue :    5 0 1
        // priQueue : 1 1 1
        // answer = 3;

        // 7
        // priorities 1 1 9 1 1 1
        // queue :    0 1
        // priQueue : 1 1
        // answer = 4;

        // 8
        // priorities 1 1 9 1 1 1
        // queue :    0 1 -> location이랑 일치
        // priQueue : 1 1
        // answer = 5;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int currentValue = priorities[index];

            int max = priorityQueue.peek();

            if (currentValue == max) {
                answer++;
                priorityQueue.poll();

                if (index == location) {
                    break;
                }
            } else {
                queue.add(index);
            }
        }

        System.out.println(queue);
        System.out.println(priorityQueue);

        return answer;
    }
}
