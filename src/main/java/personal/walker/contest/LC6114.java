package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6114 implements Solution {

    @Override
    public void runTestCases() {
       // System.out.println(canChange("_L__R__R_","L______RR"));
        System.out.println(canChange("____","R_L_"));
    }

    public int countChar(String str ,char x){
        int result = 0;
        for (int i = 0; i < str.length();i++){
            result += str.charAt(i) == x ? 1: 0;
        }
        return result;
    }
    public boolean canChange(String start, String target) {
       if ((countChar(start,'L') != countChar(target,'L')) || (countChar(start,'R') != countChar(target,'R'))){
           return false;
       }

        int[] startDP = new int[start.length()];
        int endStart = 0;
        int[] targetDP = new int[start.length()];
        int index = 0;
        int endTarget = 0;
        while (index < start.length() && target.charAt(index) != 'R') {
            if (target.charAt(index) == 'L') {
                if (index > 0) {
                    targetDP[index] = targetDP[index - 1] + 1;
                } else {
                    targetDP[index] = 1;
                }
                endTarget = targetDP[index];
            }else {
                if (index > 0){
                    targetDP[index] = targetDP[index-1];
                }

            }
            index++;
        }

        index = 0;
        while (index < start.length() && start.charAt(index) != 'R') {
            if (start.charAt(index) == 'L') {
                if (index > 0) {
                    startDP[index] = startDP[index - 1] + 1;
                } else {
                    startDP[index] = 1;
                }
                endStart = startDP[index];
            }else {
                if (index > 0){
                    startDP[index] = startDP[index-1];
                }
            }
            if (startDP[index] > targetDP[index]) {
                System.out.println("1");
                return false;
            }
            index++;
        }

        if (endTarget != endStart) {
            System.out.println("2");
            return false;
        }


        Arrays.fill(startDP,0);
        endStart = 0;

        Arrays.fill(targetDP,0);
        endTarget = 0;

        index = start.length() - 1;
        while (index >= 0 && target.charAt(index) != 'L') {
            if (target.charAt(index) == 'R') {
                if (index < start.length() - 1) {
                    targetDP[index] = targetDP[index + 1] + 1;
                } else {
                    targetDP[index] = 1;
                }
                endTarget = targetDP[index];
            }else {
                if (index < start.length() -1){
                    targetDP[index] = targetDP[index+1];
                }
            }
            index--;
        }

        index = start.length() - 1;
        while (index >= 0 && start.charAt(index) != 'L') {
            if (start.charAt(index) == 'R') {
                if (index < start.length() - 1) {
                    startDP[index] = startDP[index + 1] + 1;
                } else {
                    startDP[index] = 1;
                }
                endStart = startDP[index];
            }else {
                if (index < start.length() -1){
                    startDP[index] = startDP[index+1];
                }
            }
            if (startDP[index] > targetDP[index]) {
                System.out.printf("3 %d\n",index);
                return false;
            }
            index--;
        }

        return endTarget == endStart;
    }
}
