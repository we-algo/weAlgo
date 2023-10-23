static boolean solution(String s){
        Stack<Character> leftBracket = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)) {
                case '(' -> leftBracket.add('(');
                case ')' -> {
                    if (leftBracket.size() >= 1) {
                        leftBracket.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if(leftBracket.size() > 0){
            return false;
        }
        return true;
    }
