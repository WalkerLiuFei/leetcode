package personal.walker.contest;

import personal.walker.Solution;

public class LC6156 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int minimumRecolors(String blocks, int k) {
        int result = 1 << 31 - 1;
        int temp = 0;
        for (int i = 0; i < k; i++){
            if (blocks.charAt(i) == 'W'){
                temp ++;
            }
        }
        result = temp;
        for (int i = 1, j = k; j < blocks.length(); j ++,i++){
            if (blocks.charAt(i-1) == 'W'){
                temp -= 1;
            }
            if (blocks.charAt(j) == 'W'){
                temp += 1;
            }
            result = Math.min(result,temp);
        }
        return result;
    }

}
