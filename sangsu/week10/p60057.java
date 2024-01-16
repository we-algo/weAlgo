package Programmers.lv2;

import java.util.*;
import java.io.*;

public class p60057 {

    public static void main(String[] args) {
        solution("aaaaaaaaaabbbbbbbbbb");
        //10a10b -> result 6
    }

    //ababcdcdababcdcd
    //ab ab cd cd da ba bc dc d
    //aba bcd cda bab cdc d
    //abab cdcd abab cdcd
    //ababc dcdab abcdc d
    //ababcd cdabab cdcd
    //ababcdc dababcd cd
    //ababcdcd ababcdcd
    //원래 길이 : 16 -> 압축 8단위 : 9
    //2ababcdcd
    //aabbaccc

    public static int solution(String s) {
        int min = s.length();
        int length = 1;
        int sum = 0;

        while (length <= s.length() / 2) {
            String prevString = s.substring(0, length);
            //ababcdcd ababcdcd
            int iterate = 0;
            for (int i = length; i <= s.length() - length; i += length) {
                String nextString = s.substring(i, i + length);
                if (prevString.equals(nextString)) {
                    iterate++;
                } else {
                    if (iterate >= 1) {
                        if (iterate >= 9) {
                            sum += length + 2;
                        } else {
                            sum += length + 1;
                        }
                        iterate = 0;
                    } else {
                        sum += length;
                    }
                    prevString = nextString;
                }
            }
            if (iterate >= 1) {
                if (iterate >= 9) {
                    sum += length + 2;
                } else {
                    sum += length + 1;
                }
            } else {
                sum += length;
            }
            sum += s.length() % length;

            min = Integer.min(min, sum);
            sum = 0;
            length++;
        }
        System.out.println(min);
        return min;
    }
}
