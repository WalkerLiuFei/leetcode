package personal.walker.sort;

import personal.walker.Solution;

public class LC324 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * 1. 使用quick select 筛选出中位数，奇数位放比中位数大的数，偶数位放比奇数更大的数
     * 其中一个解是，所以中位数应该选择为左侧的那个数，然后
     * 2,4,3,5
     * 5,4,3,2 中位数为 3
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {

    }

    public int quickSelect(int[] nums,int i,int j,int k){
        return 0;
    }
}
