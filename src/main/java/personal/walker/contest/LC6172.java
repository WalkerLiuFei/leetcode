package personal.walker.contest;

import personal.walker.Solution;

public class LC6172 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(isStrictlyPalindromic(9));
    }


    /**
     * 9 ： 3进制
     *
     * @param n
     * @return
     */
    public boolean isStrictlyPalindromic(int n) {
        StringBuilder resultStr = new StringBuilder();
        for (int bit = 2; bit < n - 1;bit ++){
            int temp = n;
            while (temp != 0){
                resultStr.append(temp % bit);
                temp /= bit;
            }
            System.out.println(resultStr);
            for (int i = 0, j = resultStr.length() - 1; i < j; i ++, j--){
                if (resultStr.charAt(i) != resultStr.charAt(j)){
                    return false;
                }
            }
            resultStr = new StringBuilder();
        }

        return true;
    }

}
