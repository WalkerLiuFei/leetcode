package personal.walker.array;

import personal.walker.Solution;

public class LC2240 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(countHillValley(new int[]{8,2,5,7,7,2,10,3,6,2}));
    }

    /**
     *  use index i as left non equal index , use index j as right non equal index
     *  left = 0; index = 1; right = 2;
     *  while right < nums.Length && index <  {
     *      while right < nums.Length &&  nums[left] == nums[index]   {index++;right++;}
     *      while  right < nums.Length && nums[right] == nums[index]  {right++;}
     *      if (right >= nums.Length){
     *          break;
     *      }
     *      // 如果条件满足 ,left
     *      result += j - index;
     *      index = j;
     *      right++;
     *      left++;
     *
     *  }
     *  initial i = 0,
     * @param nums
     * @return
     */
    public int countHillValley(int[] nums) {
        int result = 0;
        int left = 0,right = 2,index = 1;
        while (right < nums.length){
            while (right < nums.length && nums[left] == nums[index]){index++;right++;};
            while (right < nums.length && nums[right] == nums[index]){right++;}
            if ((nums[left] > nums[index] && nums[right] > nums[index]) ||
                    (nums[left] < nums[index] && nums[right] < nums[index])){
                result ++;
            }
            left = index;
            index = right;
            right++;
        }
        return result;
    }
}
