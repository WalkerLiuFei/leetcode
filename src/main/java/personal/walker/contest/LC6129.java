package personal.walker.contest;

import personal.walker.Solution;

public class LC6129 implements Solution {
    @Override
    public void runTestCases() {
       // System.out.println(zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4}));
        System.out.println(zeroFilledSubarray(new int[]{0,0,0,2,0,0}));

    }

    /**
     *
     * @param nums
     * @return
     */
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        int i = 0, j = 0;
        while (i < nums.length&&nums[i] != 0) {
            i++;
        }
        j = i;
        while (j < nums.length) {
            while (j < nums.length && nums[j] == 0) {
                j++;
            }
            int length =  j - i;
            System.out.printf("%d,%d\n",i,j);
            result += (long) (length  + 1) * length/ 2;
            while (j < nums.length && nums[j] != 0) {
                j++;
            }
            i = j;
        }
        return result;
    }
}
