package personal.walker.contest;

import personal.walker.Solution;

public class LC6300 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] > nums2[j]){
                j++;
            }else if (nums1[i] < nums2[j]){
                i++;
            }else {
                return nums2[j];
            }

        }
        return -1;
    }

}
