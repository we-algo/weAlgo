import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 인용수 기준 내림차순 정렬 후
 * 정렬된 상태에서의 논문 순서가 인용 수와 같거나 커지는 시점을 h index라고 한다
 * 순서 >= 인용수
 *
 * 만약에 h index가 넘지 못한다면 길이 리턴
 *
 *
 * [0, 1, 3, 5, 6]
 * 여기서 문제 설명대로 쭉 적어보면
 * 0회 이상 인용 논문 수 = 5개
 * 1회 이상 인용 논문 수 = 4개
 * 3회 이상 인용 논문 수 = 3개
 * 5회 이상 인용 논문 수 = 2개
 * 6회 이상 인용 논문 수 = 1개
 */

public class P42747 {
    public static void main(String[] args) {
//        int[] arr = {3, 0, 6, 1, 5};
        int[] arr = {5, 4, 3, 8, 10};
//        int[] arr = {6, 5, 4, 2, 0};
//        int[] arr = {3, 4};
//        int[] arr = {0, 0, 0};
        new Solution().solution(arr);
    }
}

class Solution {
    public int solution(int[] citations) {
        int answer = 0;


        //  primitive 타입 내림차순 정렬 (int형)
//        Integer[] integerArr = Arrays.stream(citations)
//                .boxed()
//                .toArray(Integer[]::new);

        // 2. Comparator를 사용하여 내림차순으로 정렬
//        Arrays.sort(integerArr, Collections.reverseOrder());

        // 배열 부분정렬
//        Arrays.sort(citations, 0, 3);

//        System.out.println(Arrays.toString(integerArr));

        Arrays.sort(citations);

        List<Integer> arrList = new ArrayList<>();
        for (int i = citations.length - 1; i >= 0; i--) {
            arrList.add(citations[i]);
        }

        for (int i = 0; i < arrList.size(); i++){
            if (i >= arrList.get(i)){
                answer = i;
                return answer;
            }
        }

        return arrList.size();
    }
}
