package personal.walker.contest;

import personal.walker.Main;
import personal.walker.Solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC6365 implements Solution {
    @Override
    public void runTestCases() {
//        System.out.println(minOperations(39));
//        ;
//        System.out.println(minOperations(54));
//        System.out.println(minOperations(1));
//
//        System.out.println(minOperations(8));
//
//
//        System.out.println(minOperations(870));

//        System.out.println(minOperations(7862));
//        System.out.println(minOperations(11));

        System.out.println(minOperationsStr("11010110110".toCharArray()));

    }


    public int minOperations(int n) {
        if (n == 0) {
            return 0;
        }
        String binaryNum = Integer.toBinaryString(n);
        return minOperationsStr(binaryNum.toCharArray());
    }


    public int minOperationsStr(char[] binaryNum) {

        int count = 0;
        boolean flag = false;
        for (int j = binaryNum.length - 1; j >= 0; ) {

            if (binaryNum[j] == '1') {
                int tmp = j;
                while (j >= 0 &&
                        binaryNum[j] == '1') {
                    j--;
                }
                count++;
                flag = tmp - j > 1;
            }
            if (flag) {
                if (j >= 0){
                    binaryNum[j] = '1';
                }
            } else {
                flag = false;
                j--;
            }
        }
        return  flag ? count + 1 :count;
    }

}
