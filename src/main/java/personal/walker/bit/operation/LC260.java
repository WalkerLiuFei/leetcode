package personal.walker.bit.operation;

import personal.walker.Solution;

import java.util.HashSet;
import java.util.Set;

public class LC260 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(2 ^ 3 ^ 2  ^ 2 ^ 2 ^ 2 ^2 ^ 3);
    }

    public int[] singleNumber(int[] nums) {
        Set<Integer> resultSet = new HashSet<>();
        // 异或

        for (int num : nums){

        }
        return nums;
    }
}
