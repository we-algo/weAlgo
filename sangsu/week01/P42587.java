import java.io.*;
import java.util.*;

class p42587{
    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 2));
    }

    public static int solution(int[] priorities, int location) {
        Queue<keyValueClass> keyValueClassQueue = new LinkedList<>();

        int[] a = new int[10];

        for (int i = 0; i < priorities.length; i++) {
            int important = priorities[i];
            a[important]++;
            keyValueClass kv = new keyValueClass(important, i);
            keyValueClassQueue.offer(kv);
        }
        int count = 0;
        int index = a.length-1;
        while(index >= 1){
            while(a[index] >= 1){
                keyValueClass kvc = keyValueClassQueue.poll();
                if(kvc.getValue() == index){
                    a[index]--;
                    count++;
                    if(kvc.valueIndex == location){
                        return count;
                    }
                }else{
                    keyValueClassQueue.offer(kvc);
                }
            }
            if(a[index] == 0){
                index--;
            }
        }

        return 0;

    }
    static class keyValueClass{
        private int value;
        private final int valueIndex;

        keyValueClass(int value, int valueIndex){
            this.value = value;
            this.valueIndex = valueIndex;
        }

        public int getValue() {
            return value;
        }

        public int getValueIndex() {
            return valueIndex;
        }
    }
}
