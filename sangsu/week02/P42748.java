import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


class Solution {
    
    static int[] needSortArray;
    static int[] tmp = new int[101];
    
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for(int[] numbers : commands){
            answer.add(divide_sort(Arrays.copyOfRange(array, numbers[0]-1, numbers[1]))[numbers[2]-1]);
        }

        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    static int[] divide_sort(int[] divideArray){
        needSortArray = divideArray;
        merge_sort(0, needSortArray.length-1);

        return needSortArray;
    }
    
    static void merge_sort(int start, int end){
        if(start < end){
            int center = (start+end) / 2;
            merge_sort(start, center);
            merge_sort(center+1, end);
            merge(start, center, end);
        }
    }
    
    static void merge(int start, int center, int end){
        int i = start;
        int j = center+1;
        int t = 0;
        while(i <= center && j <= end){
            if(needSortArray[i] <= needSortArray[j]){
                tmp[t] = needSortArray[i];
                i++;
                t++;
            }
            if(needSortArray[i] >= needSortArray[j]){
                tmp[t] = needSortArray[j];
                j++;
                t++;
            }
        }
        while(i <= center){
            tmp[t] = needSortArray[i];
            i++;
            t++;
        }
        while(j <= end){
            tmp[t] = needSortArray[j];
            j++;
            t++;
        }
    
        int index = start;
        t = 0;
        while(index <= end){
            needSortArray[index] = tmp[t];
            index++;
            t++;
        }
    } 
}
