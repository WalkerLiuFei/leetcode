package personal.walker.contest;

import personal.walker.Solution;

public class LC6359 implements Solution {
    @Override
    public void runTestCases() {
        minMaxDifference(456);
    }


    public int minMaxDifference(int num) {

        String numStr = String.valueOf(num);
        String maxStr = numStr;
        String minStr = numStr;
         for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '9') {
                continue;
            }
            maxStr = numStr.replace(numStr.charAt(i), '9');
            break;
        }
        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) == '0') {
                continue;
            }
            minStr = numStr.replace(numStr.charAt(i), '0');
            break;
        }
        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}
