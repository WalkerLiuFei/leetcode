package personal.walker.a.notes;

import personal.walker.Solution;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

// https://leetcode.com/problems/subarray-sum-equals-k/
public class LC560 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * 非常 好的 讲解 ：
     *   https://leetcode.com/problems/subarray-sum-equals-k/discuss/803317/Java-Solution-with-Detailed-Explanation
     *
     * func subarraySum(nums []int, k int) int {
     *     preSumMap := make(map[int]int)
     *     result := 0
     *     prefixSum := 0
     *     preSumMap[0] = 1
     *     for _,value := range nums{
     *         prefixSum += value
     *         result += preSumMap[prefixSum - k]
     *         preSumMap[prefixSum]++
     *     }
     *     return result
     * }
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        return 0;
    }

}
