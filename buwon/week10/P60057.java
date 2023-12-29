
class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int count = 1;

            for (int j = i; j <= s.length(); j += i) {
                String current;
                if (j + i > s.length()) {
                    current = s.substring(j);
                } else {
                    current = s.substring(j, j + i);
                }

                if (prev.equals(current)) {
                    count++;
                } else {
                    if (count > 1) {
                        sb.append(count);
                    }
                    sb.append(prev);
                    prev = current;
                    count = 1;
                }
            }
            if (count > 1) {
                sb.append(count);
            }
            sb.append(prev);

            answer = Math.min(answer, sb.length());
        }

        System.out.println(answer);
        return answer;
    }
}
