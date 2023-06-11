package personal.walker.string;

import personal.walker.Solution;

public class LC551 implements Solution {
    @Override
    public void runTestCases() {}



    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for (char c : s.toCharArray()){
            absent += c == 'A' ? 1 : 0;
            late += c == 'L'? 1 : -late;
            if (absent >= 2 || late >= 3){
                return false;
            }
        }
        return  absent < 2 && late < 3 ;
    }
}
