import java.util.Stack;

public class P12909 {
    public static void main(String[] args) {
        new Solution().solution(")()(");
    }
}


class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stacks = new Stack<>();


        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                stacks.push(String.valueOf(c));
            } else if (stacks.isEmpty() && c == ')'){
                return false;
            } else {
                stacks.pop();
            }
        }

        if (!stacks.isEmpty()){
            answer = false;
        }

        System.out.println(answer);

        return answer;
    }
}
