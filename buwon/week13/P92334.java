import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> mailCount = new HashMap<>();

        String[] reportArr = Arrays.stream(report)
                .distinct()
                .toArray(String[]::new);

        for (String name : id_list){
            map.put(name, 0);
            mailCount.put(name, 0);
        }

        // 신고당한 횟수 넣어주기
        for (String declaration : reportArr) {
            String[] split = declaration.split(" ");

            map.put(split[1], map.getOrDefault(split[1], 0) + 1);
        }

        System.out.println(map);

        // 메일받은 수 count 해주기
        for (String declaration : reportArr) {
            String[] split = declaration.split(" ");

            if (map.get(split[1]) >= k) {
                mailCount.put(split[0], mailCount.getOrDefault(split[0], 0) + 1);
            }
        }

        for (int i = 0; i < id_list.length; i++){
            int count = mailCount.get(id_list[i]);
            answer[i] = count;
        }
        
        return answer;
    }
}
