package Programmers.lv2;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class p17677 {
    public static void main(String[] args) {

        //"aa1+aa2", "AAAA12"
        System.out.println(solution("aa1+aa2", "AAAA12"));
        //"FRANCE", "FRENCH"
        //"FRFRANCE", "FRFRENCH"
    }

    public static int solution(String str1, String str2) {
        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();

        //특수문자 제거
        s1 = noSpecial(s1);
        s2 = noSpecial(s2);

        ArrayList<String> set1 = new ArrayList<>();
        ArrayList<String> set2 = new ArrayList<>();

        for(int i = 0; i < s1.length()-1; i++){
            set1.add(s1.substring(i, i+2));
        }

        for(int i = 0; i < s2.length()-1; i++){
            set2.add(s2.substring(i, i+2));
        }
        int sameCount = 0;

        //1, 2, 2, 4, 5 } {1, 1, 2 ,2, 3}
        Set<String> check = new HashSet<>();
        check.addAll(set1);
        check.addAll(set2);
        int sumCount = check.size();

        for(int i = 0; i < set1.size(); i++){
            String temp = set1.get(i);
            if(set2.contains(temp)){
                set2.remove(temp);
                sameCount++;
            }
        }//있으면 교집합 합집합 필수

        return sameCount / sumCount * 65536;
    }// 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 J(A, B) = 1로 정의한다.

    static String noSpecial(String string){
        return string.chars()
                .filter(Character::isAlphabetic)
                .mapToObj(c -> (char) c)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

}
