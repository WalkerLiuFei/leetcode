package personal.walker.string;

import personal.walker.Solution;

public class LC647 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(countSubstrings("aaa"));;
    }


    public int countSubstrings(String s) {
        int result = s.length();
        for (int i = 0; i < s.length(); i++ ){
            int a = -1,b = -1;
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)){
                a = i;
                b = i+1;
                while ( a >= 0 && b < s.length()  && s.charAt(a--) == s.charAt(b++)){
                    result++;
                 }
            }

            if (i > 0 && i < s.length() - 1 && s.charAt(i - 1) == s.charAt(i + 1)){
                a = i - 1;
                b = i + 1;
                while ( a >= 0 && b < s.length()  && s.charAt(a--) == s.charAt(b++)){
                    result++;
                 }
            }
        }
        return result;
    }


}
