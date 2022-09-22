package personal.walker.contest;

import personal.walker.Solution;


public class LC6157 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int secondsToRemoveOccurrences(String s) {
        int result = 0;
        while (s.contains("01")){
            s = s.replace("01","10");
            result ++;
        }
        return result;
    }

}
