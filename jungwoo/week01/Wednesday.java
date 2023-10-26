package week01;

import java.util.*;

class Wednesday {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        /*
            1. 며칠 걸리는지 계산
            2. 이전 날짜보다 작은 건 전부 이전 날짜 +1 , 그 이후 큰 건 1로 초기화
            3. 결과를 배열에 넣고 출력
        */
        // [93, 30, 55] -> [1, 30, 5] -> [7, 3, 9] -> (100 - 93) / 1 = 7 , (100 - 30) / 30 = 2 + 1 , (100 - 55) / 5 = 9
        List<Integer> remainDays = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) {
                day++;
            }
            remainDays.add(day); // [7, 3, 9]
            
        }
        
        // count -> 1 [7], [7] ->2(배열에 넣는다.) [9] count 1 -> 1 [2, 1]
        List<Integer> depoly = new ArrayList<>();
        for (int i = 0; i < remainDays.size();) {
            int count = 1;
            int maxDay = remainDays.get(i);
            // [7, 3, 9]
            //while(1 < 3 && 7 >= 3) true
            //while(2 < 3 && 7 >= 9) false return 2 -> count = 1
            //reutrn 1
            while(++i < remainDays.size() && maxDay >= remainDays.get(i)) {
                count++;
            }
            depoly.add(count);
        }

        return depoly.stream()
            .mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Wednesday t = new Wednesday();
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] progresses = new int[count];
        int[] speeds = new int[count];
        for (int i = 0; i < count; i++) {
            progresses[i] = in.nextInt();
        }
        for (int i = 0; i < count; i++) {
            speeds[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(t.solution(progresses, speeds)));
    }
}