import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> str1List = new ArrayList<>();
        List<String> str2List = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            addTwoWord(str1, str1List, set, i);
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            addTwoWord(str2, str2List, set, i);
        }

        List<String> difference = new ArrayList<>();

        for (String str : str1List) {
            if (str2List.remove(str)) {
                difference.add(str);
            }
        }

        List<String> union = new ArrayList<>(str1List);
        union.addAll(str2List);

        int differenceSize = difference.size();
        int unionSize = union.size();

        if (unionSize > 0) {
            answer = (int) Math.floor(((double) differenceSize / unionSize) * 65536);
        } else {
            answer = 65536;
        }

        return answer;
    }

    private static void addTwoWord(String str2, List<String> str2List, Set<String> set, int i) {
        String substring = str2.substring(i, i + 2);
        if (Character.isAlphabetic(substring.charAt(0)) && Character.isAlphabetic(substring.charAt(1))){
            str2List.add(str2.substring(i, i + 2));
            set.add(str2.substring(i, i + 2));
        }
    }
}
