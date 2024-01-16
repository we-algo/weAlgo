package Programmers.lv2;

import java.util.*;
import java.util.Arrays;

public class p17686 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
    }

    static public String[] solution(String[] files) {
        String[] answer = {};

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){

                if(o1.compareTo(o2) == 0){
                    int head = 0;
                    for(int i = 0; i < o1.length(); i++){
                        if(Character.isDigit(o1.charAt(i))){
                            head = i;
                            break;
                        }
                    }
                    String numberTail1 = o1.substring(head);
                    String numberTail2 = o2.substring(head);

                    int a = 0;
                    int b = 0;
                    boolean noDigit = false;
                    int noDigitIndex = 0;
                    for(int i = 0; i < numberTail1.length(); i++){
                        if(Character.isDigit(numberTail1.charAt(0))){
                            noDigit = true;
                            noDigitIndex = i;
                            a = Integer.parseInt(numberTail1.substring(0, noDigitIndex));
                            break;
                        }
                    }
                    if(!noDigit){
                        a = Integer.parseInt(numberTail1.substring(0, numberTail1.length()));
                    }


                    noDigit = false;
                    noDigitIndex = 0;
                    for(int i = 0; i < numberTail2.length(); i++){
                        if(Character.isDigit(numberTail2.charAt(0))){
                            noDigit = true;
                            noDigitIndex = i;
                            b= Integer.parseInt(numberTail2.substring(0, noDigitIndex));
                            break;
                        }
                    }
                    if(!noDigit){
                        b = Integer.parseInt(numberTail2.substring(0, numberTail2.length()));
                    }

                    return a - b;
                }else{
                    return o1.compareTo(o2);
                }
            }
        });

        pq.addAll(List.of(files));

        List<String> resultList = new ArrayList<>();
        while (!pq.isEmpty()) {
            resultList.add(pq.poll());
        }

        return resultList.toArray(new String[0]);
    }
}
