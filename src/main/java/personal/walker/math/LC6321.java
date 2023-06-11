package personal.walker.math;

import personal.walker.Main;
import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashMap;

public class LC6321 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(
                findSmallestInteger(new int[]{1,-10,7,13,6,8}, 7)
        );
    }

    public int findSmallestInteger(int[] nums, int value) {

        int[] mod = new int[value];


        for (int i = 0; i < nums.length; i++) {
            int currentModule =  nums[i] % value;
            if (currentModule < 0){
                currentModule += value;
             }
            mod[currentModule]++;

        }
        // 找出最小的那个module，
        int min = mod[0];
        int minIndex = 0;
        for (int i = 0; i < mod.length; i++){
            if (min > mod[i]){
                min = mod[i];
                minIndex = i;
            }
        }


        return minIndex + min * value;
    }


}
