package personal.walker;

import java.util.List;

public class Sum_4 {

    public void sort(int[] nums,int i,int j ){
        if (nums == null || j - i  < 1)  {
            return ;
        }
        int key = nums[j - 1];
        int start = i;
        int end = j - 2;
        while (start < end) {
            while (start < end && nums[start] < key) {start++;}
            while (start < end && nums[end] > key) {end--;}
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        if (nums[start] > key){
            int temp = nums[start];
            nums[start] = key;
            nums[j - 1] = temp;
        }
        sort(nums,i,start);
        sort(nums,start+1,j);
    }
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            return null;
        }

    }
}
