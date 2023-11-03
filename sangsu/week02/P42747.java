import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Collections;


class Solution {
    public static int solution(int[] citations) {
        int answer = 0;
        
        Integer[] a = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        Arrays.sort(a, new Comparator<Integer>(){
                    @Override
                    public int compare(Integer o1, Integer o2){
                        return o2 - o1;
                    }
                }
        );


        //6, 5, 3, 1, 0
        // for(int num : a){
        //index가 값이고 그 값을 기준으로 찾는다
        for(int j = a[0]; j >= 0; j--){
            for(int i = 0; i < a.length; i++){
                if(a[i] < j){
                    if(i >= j){
                        return j;
                    }
                    break;
                }else if(i == a.length-1){
                    if(a[i] >= j){
                        if(a[i] > 1){
                            return a.length;
                        }else {
                            return 0;
                        }
                    }
                }
            }
        }
        return -1;

    }
}
