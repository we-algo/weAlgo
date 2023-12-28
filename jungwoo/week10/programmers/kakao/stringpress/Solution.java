package algorithmstudy.kakao.stringpress;

public class Solution {
    public int solution(String s) {
        int answer = s.length();
        int count = 1;

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder result = new StringBuilder();
            String prev = s.substring(0, i);

            for (int j = i; j <= s.length(); j += i) {
                int endIdx = Math.min(j + i, s.length());
                String sub = s.substring(j, endIdx);

                if (prev.equals(sub)) {
                    count++;
                } else {
                    if (count >= 2) {
                        result.append(count);
                    }

                    result.append(prev);
                    prev = sub;
                    count = 1;
                }
            }

            result.append(prev);
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}
