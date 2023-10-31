import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P42746 {
    public static void main(String[] args) {
//        int[] arr = {6, 10, 2};
        int[] arr = {3, 30, 34, 5, 9};
//        int[] arr = {0, 0, 0, 0};
        new Solution().solution(arr);
    }
}

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        String[] str = new String[numbers.length];
        for(int i = 0; i < str.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }

        // 두 숫자 비교
        /**
         * compareTo 설명
         * 기준 값 == 비교값 : 0
         * 기준 값 < 비교값 : 음수
         * 기준 값 > 비교값 : 양수
         */
        Arrays.sort(str, (s1, s2) -> {
            System.out.println("s1 : " + s1);
            System.out.println("s2 : " + s2);
            return (s2 + s1).compareTo(s1 + s2);
        });

//        Arrays.sort(str, new Comparator<String>(){
//            @Override
//            public int compare(String s1, String s2){
//                return (s2 + s1).compareTo(s1 + s2);
//            }
//        });

        // 아래와 같이 한줄로 가능
//        Arrays.sort(str, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        // 다른 풀이
//        List<String> stringList = Arrays.stream(str)
//                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
//                .collect(Collectors.toList());

        for (String s : str){
            answer.append(s);
        }

        if (answer.charAt(0) == '0'){
            return "0";
        }

        System.out.println(answer);

        return answer.toString();
    }
}

/**
 * 풀이 참조
 */
//class Solution {
//    public String solution(int[] numbers) {
//        return Arrays.stream(numbers)
//                .mapToObj(String::valueOf)
//                .sorted((a, b) -> (b + a).compareTo(a + b))
//                .collect(Collectors.joining())
//                .replaceFirst("^0+(?!$)", "");
//    }
//}
