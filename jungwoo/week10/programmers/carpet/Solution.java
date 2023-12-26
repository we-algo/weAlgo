package algorithmstudy.exhaustivesearch.programmers.carpet;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int[] answer = new int[2];

        for (int i = 3; i <= Math.sqrt(total); i++) {
            if (total % i == 0) {
                int j = total / i;
                if ((i - 2) * (j - 2) == yellow) {
                    answer[0] = j;
                    answer[1] = i;
                    break;
                }
            }
        }

        return answer;
    }
}
