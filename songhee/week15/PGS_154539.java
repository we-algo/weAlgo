import java.util.*;
class Solution {
    static int maxNum = 0;
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> s = new Stack<>();
        int idx = numbers.length-1;
        while(idx>=0){
            if(s.isEmpty()){
                s.push(numbers[idx]);
                answer[idx] = -1;
                idx--;
                continue;
            }
            
            if(s.peek() <= numbers[idx]) s.pop();
            else{
                answer[idx] = s.peek();
                s.push(numbers[idx]);
                idx--;
            }
        }
        
        return answer;
    }
}
