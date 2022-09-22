package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6166 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(largestPalindromic("444947137"));
       System.out.println(largestPalindromic("00009"));
        System.out.println(largestPalindromic("00001105"));
        System.out.println(largestPalindromic("5736732"));
    }

    /**
     * 使用一个数组，记录每个数字出现的次数，大的数在前面构成一个回文数字 ？，需要出现
     * 将最大数字 的1/2 置于前面，
     *
     * @param num
     * @return
     */
    public String largestPalindromic(String num) {
        int[] numCount = new int[10];
        for (Character c : num.toCharArray()) {
            numCount[c - '0']++;
        }
        if (numCount[0] == num.length()){
            return "0";
        }
        //System.out.println(Arrays.toString(numCount));
        StringBuilder result = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (i == 0 && result.length() == 0){
                continue;
            }
            if (numCount[i] > 1){
                for (int count = numCount[i] / 2; count > 0; count--){
                    result.append(i);
                }
            }
            numCount[i] -= (numCount[i] / 2) * 2;
        }
        //System.out.println(result);
        boolean flag = false;
        // 加一个奇数
        for (int i = 9; i >= 0; i--) {
            if ((numCount[i] & 0x01) == 1){
                flag = true;
                result.append(i);
                break;
            }
        }
        int endIndex = flag ? result.length() - 1: result.length() ;
        StringBuffer  secondHalf = new StringBuffer(result.substring(0,endIndex));
        result.append(secondHalf.reverse());
        return result.toString();
        // 中间加一个最大的奇数的数字

    }

}
