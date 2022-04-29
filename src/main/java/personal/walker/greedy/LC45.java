package personal.walker.greedy;

import personal.walker.Solution;

public class LC45 implements Solution {
    @Override
    public void runTestCases() {
        jump(new int[]{1,1,1,1});
    }
    public int jump(int[] nums) {
        if (nums.length <= 1){
            return 0;
        }
        int result = 0;
        // 距离，跳到的最远的index,如果
        int distance = nums[0];
        int newDistance = nums[0];
        result = 1;
        if(distance >= nums.length - 1){
            return result;
        }
        for (int i = 1; i < nums.length;){
            int nextDistance = distance;
            int j = i;
            while(j < nums.length && j <= distance){
                if (nextDistance < nums[j] + j){
                    nextDistance = nums[j] + j;
                }
                j++;
            }
            i = j;
            distance = nextDistance;
            result++;
            if (distance >= nums.length - 1){
                return result;
            }
        }
        return result;
    }

}
