package personal.walker.string;

import personal.walker.Solution;

public class LC6362 implements Solution {
    @Override
    public void runTestCases() {

    }



    public int findTheLongestBalancedSubstring(String s) {
        int result = 0;
         for (int i = 0; i < s.length();i++){
            int numZero = 0;
            int numOne = 0;
            boolean flag = false;
            for (int j = i; j >= 0; j--){
                char c = s.charAt(j);
                if (c == '1'){
                    numOne ++;
                    if (flag){
                        break;
                    }
                }
                if (c == '0'){
                    numZero ++;
                    flag = true;
                }

                if (numOne == numZero && numOne + numZero > result){
                    result = numOne + numZero;
                }
            }
        }
        return result;
    }

}
