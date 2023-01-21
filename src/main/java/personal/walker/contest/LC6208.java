package personal.walker.contest;

import personal.walker.Solution;

public class LC6208 implements Solution {
    @Override
    public void runTestCases() {

    }
    public int countTime(String time) {
        int result = 1;
        if (time.charAt(0) == '?' ){
            if (time.charAt(1) < '4' && time.charAt(1)  >= '0'){
                result = 3;
            }else {
                result = 2;
            }
        }
        if (time.charAt(1) == '?'){
            if (time.charAt(0) == '?'){
                result = 24;
            }else if (time.charAt(0) == '1' ||  time.charAt(0) == '0' ) {
                result = 10;
            }else {
                result = 4;
            }
        }
        if (time.charAt(3) == '?'){
            result *= 6;
        }
        if (time.charAt(4) == '?'){
            result *= 10;
        }
        return result;
    }
}
