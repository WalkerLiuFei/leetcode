package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashSet;

public class LC6205 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int countDistinctIntegers(int[] nums) {
         HashSet<Integer> hashSet = new HashSet<>();
        for (int i =0; i < nums.length; i++){
            //int j = i + nums.length;
            int temp = nums[i];
            int reverse = temp % 10;
            temp = temp / 10;
            while (temp != 0){
                reverse = reverse * 10 + temp % 10;
                temp /= 10;
            }
            hashSet.add(nums[i]);
            hashSet.add(reverse);
        }
        return hashSet.size();
    }
}
