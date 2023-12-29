class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;
        int x = 0;
        int y = 0;

        int yellowX = 0;
        int yellowY = 0;

        for (int i = 1; i <= yellow; i++){
            if (yellow % i == 0){
                yellowX = Math.max(i, yellow / i);
                yellowY = Math.min(i, yellow / i);
                if ((yellowY + 2) * (yellowX + 2) == sum){
                    break;
                }
            }
        }

        x = yellowX + 2;
        y = yellowY + 2;

        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}
