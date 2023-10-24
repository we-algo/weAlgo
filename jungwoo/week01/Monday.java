package week01;

import java.util.*;

public class Monday {

    public boolean solution(String s) {
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public boolean solution2(String s) {
        int answer = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                answer++;
            } else if (c == ')') {
                if (answer == 0) {
                    return false;
                }
                answer--;
            }
        }
        return answer == 0;
    }

    public static void main(String[] args) {
        Monday t = new Monday();
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(t.solution(s));
        System.out.println(t.solution2(s));
    }
}