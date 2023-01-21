package personal.walker.contest;

import personal.walker.Solution;

public class LC6246 implements Solution {
    @Override
    public void runTestCases() {

    }
    //96063

    public int appendCharacters(String s, String t) {

        int j = 0;
        int i = 0;
        while (i < t.length()) {
            while (j < s.length() && s.charAt(j) != t.charAt(i)) {
                j++;
            }
            j++;
            if (j >= s.length()){
                break;
            }
            i++;
        }
        return t.length() - i;
    }


}
