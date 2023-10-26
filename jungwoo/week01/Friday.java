package week01;

import java.util.*;

class Friday {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Program> program = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            program.offer(new Program(i, priorities[i]));
        }
        // [0, 2], [1, 1], [2, 3], [3, 2]
        // 첫번째 2를 꺼냈는데 우선순위가 젤 높지 않아!
        // 그래서 얘를 맨뒤에 넣어야 해
        // 우선 순위가 제일 높은 거를 새로운
        // [1, 1], [2, 3], [3, 2], [0, 2]
        // [2, 3], [3, 2], [0, 2], [1, 1]
        // [2, 3], [3, 2], [0, 2], [1, 1]
        while (!program.isEmpty()) {
            Program temp = program.poll();
            for (Program p : program) {
                if (p.getPriority() > temp.getPriority()) {
                    program.offer(temp);
                    temp = null;
                    break;
                }
            }
            if (temp != null) {
                answer++;
                if (temp.id == location) {
                    return answer;
                }
            }
        }
        return answer;
    }

    class Program {
        private int id;
        private int priority;

        public Program(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        public int getId() {
            return id;
        }

        public int getPriority() {
            return priority;
        }
    }
}