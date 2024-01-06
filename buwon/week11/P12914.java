class Solution {
    public long solution(int n) {
        int num1 = 0;
        int num2 = 1;

        for (int i = 0; i < n; i++) {
            int temp = num1 + num2;
            num1 = num2;
            num2 = temp % 1234567;

        }
        return num2;
    }
}
