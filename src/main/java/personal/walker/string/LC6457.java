package personal.walker.string;

import personal.walker.Solution;

public class LC6457 implements Solution {
    @Override
    public void runTestCases() {

    }

    public String removeTrailingZeros(String num) {
        int i = num.length() - 1;
        for (; i >= 0; i--){
            if (num.charAt(i) != '0'){
                break;
            }
        }
        return num.substring(0,i+1);
    }

}
