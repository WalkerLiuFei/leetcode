package personal.walker.array;

import personal.walker.Solution;

public class LC6424 implements Solution {
    @Override
    public void runTestCases() {

    }



    public int semiOrderedPermutation(int[] nums) {
        int index1 = 0;
        int indexn = 0;
        for (int i =0; i < nums.length;i++){
            if (nums[i] == 1){
                index1 = i;
            }
            if (nums[i] == nums.length){
                indexn = i;
            }
        }
        return  indexn > index1 ? index1 + (nums.length  - indexn) : index1 +  (nums.length  - indexn) - 1;
    }
}
