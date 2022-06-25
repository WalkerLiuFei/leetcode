package personal.walker.contest;

import personal.walker.Solution;

import java.util.Set;

public class LC5242 implements Solution {
    @Override
    public void runTestCases() {

    }
    public String greatestLetter(String s) {
        //1. 大小写都出现的字母
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (int i = 0; i < s.getBytes().length;i++){
            if ( 'a'<= s.charAt(i)  && s.charAt(i)<= 'z'){
                lower[s.charAt(i)-'a'] = true;
            }
            if ( 'A'<= s.charAt(i)  && s.charAt(i)<= 'Z'){
                upper[s.charAt(i)-'A'] = true;
            }
        }
        for (int i = 25; i >= 0; i--){
            if (lower[i] && upper[i]){
                return String.valueOf((char) (i +'A'));
            }
        }
        return "";
    }
}
