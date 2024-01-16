package Programmers.lv1;

import java.util.*;

public class p92334 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                2)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //신고자
        HashMap<String, Set<String>> reporter = new HashMap<>();

        //신고 당한 유저
        HashMap<String, Integer> reported = new HashMap<>();

        for(String id : id_list){
            reported.put(id, 0);
            reporter.put(id, new HashSet<>());
        }

        StringTokenizer st;
        String reportUser;
        String reportedUser;
        for(String reportData : report){
            //신고 당한 유저
            st = new StringTokenizer(reportData);
            reportUser = st.nextToken();
            reportedUser = st.nextToken();
            //이미 데이터가 있으면 false
            if(reporter.get(reportUser).add(reportedUser)){
                reported.put(reportedUser, reported.get(reportedUser)+1);
            }
        }

        for(String reportData : report){
            //신고한 유저
            st = new StringTokenizer(reportData);
            reportUser = st.nextToken();
            reportedUser = st.nextToken();
            if(reported.get(reportedUser) < k){
                reporter.get(reportUser).remove(reportedUser);
            }
        }

        for(int i = 0; i < answer.length; i++){
            answer[i] = reporter.get(id_list[i]).size();
        }

        return answer;
    }
}
