package personal.walker.a.notes;

import personal.walker.Solution;

public class LC1004 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 1, 0, 0}, 0));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 1, 0, 0}, 0));
        System.out.println(longestOnes(new int[]{1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1}, 9));

    }



    public int longestOnes(int[] A, int K) {
        int zeroCount = 0, start = 0, res = 0;
        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0) zeroCount++;
            while (zeroCount > K) {
                if (A[start] == 0) zeroCount--;
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }


    /**
     * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
     * 两个变量 front , end
     * 1.  front = 0,end = 4  : 5
     * <p>
     * while(end < len(nums) && (nums[end] == 1 || flip > 0)){
     * if (nums[end] == 0){
     * flip--;
     * }
     * end++;
     * }
     * if (end - start + 1 > result) :
     * result = end - start + 1
     * if (flip == 0){
     * while(end < len(nums) && flip == 0) { if nums[end++] == 0 flip--; nums[front++] == 0 flip++}
     * }
     * 2.
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes_wrong(int[] nums, int k) {
        int result = 0;
        int start = 0, end = 0, flip = k;
        int length = nums.length;
        if (k == 0) {
            int current = 0;
            for (int num : nums) {
                if (num == 1) {
                    current++;
                    if (current > result) {
                        result = current;
                    }
                }
                if (num == 0) {
                    current = 0;
                }
            }
            return result;
        }
        while (end < length) {
            if (nums[end] == 0 && flip > 0) {
                end++;
                flip--;
            } else if (nums[end] == 1) {
                end++;
            } else if (0 == flip) {
                while (end < length && (flip <= 0)) {
                    if (nums[end++] == 0) {
                        flip--;
                    }
                    if (nums[start++] == 0) {
                        flip++;
                    }
                }
            }
            result = Math.max(end - start, result);
        }
        return result;
    }

}
