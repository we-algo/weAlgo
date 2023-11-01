import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        
        String[] stringNumbers = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(stringNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a1 = Integer.parseInt(o1+o2);
                int a2 = Integer.parseInt(o2+o1);

                return a2 - a1;

            }
        });

        
        StringBuilder sb = new StringBuilder();
        for (String num : stringNumbers) {
            if(sb.length() != 0 && sb.charAt(0) == '0'){
                return sb.toString();
            }
            sb.append(num);
        }

        return sb.toString();
    }
}
