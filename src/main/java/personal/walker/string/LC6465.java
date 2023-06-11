package personal.walker.string;

import personal.walker.Solution;

public class LC6465 implements Solution {
    @Override
    public void runTestCases() {

    }

    public String smallestString(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == 'a'){
            i++;
        }

        StringBuilder result = new StringBuilder();
        if (i == s.length()){
            result.append(s, 0, s.length() - 1);
            result.append('z');
            return result.toString();
        }
        result.append(s.substring(0,i));

        while (i < s.length() && s.charAt(i) != 'a'){
            result.append((char) (s.charAt(i) - 1));
            i++;
        }
        result.append(s.substring(i));

        return result.toString();

    }
}