package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6216 implements Solution {
    @Override
    public void runTestCases() {
     //   System.out.println(minCost(new int[]{1,3,5,2},new int[]{2,3,1,14}));
        System.out.println(minCost(new int[]{1,2},new int[]{1,100}));
        System.out.println(minCost(new int[]{1,2,3,4},new int[]{1,100,100,100}));
    }

/**
 * You are given two 0-indexed arrays nums and cost consisting each of n positive integers.
 *
 * You can do the following operation any number of times:
 *
 * Increase or decrease any element of the array nums by 1.
 * The cost of doing one operation on the ith element is cost[i].
 *
 * Return the minimum total cost such that all the elements of the array nums become equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,2], cost = [2,3,1,14]
 * Output: 8
 * Explanation: We can make all the elements equal to 2 in the following way:
 * - Increase the 0th element one time. The cost is 2.
 * - Decrease the 1st element one time. The cost is 3.
 * - Decrease the 2nd element three times. The cost is 1 + 1 + 1 = 3.
 * The total cost is 2 + 3 + 3 = 8.
 * It can be shown that we cannot make the array equal with a smaller cost.
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], cost = [4,2,8,1,3]
 * Output: 0
 * Explanation: All the elements are already equal, so no operations are needed.
 */
    public long minCost(int[] nums, int[] cost) {

        int min = nums[0];
        int max = nums[0];
        for (int num : nums){
            if (min > num){
                min = num;
            }
            if (max < num){
                max = num;
            }
        }
        while (max - min > 2){
            int mid1 = min + (max - min) / 3;
            int mid2 = max - (max - min) / 3;
            if (conputeCost(nums,cost,mid1) < conputeCost(nums,cost,mid2)){
                max = mid2;
            }else {
                min = mid1;
            }
        }

        return Math.min(Math.min(conputeCost(nums,cost,(min + max) / 2),conputeCost(nums,cost,min)),conputeCost(nums,cost,max));
    }

    public long conputeCost(int[] nums,int[] cost,int x ){
        long totalCost = 0;
        for (int i = 0; i < nums.length;i++){
            totalCost += Math.abs(nums[i] - x) * (long)cost[i];
        }
        return totalCost;
    }

}
