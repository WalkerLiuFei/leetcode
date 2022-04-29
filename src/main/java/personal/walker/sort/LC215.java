package personal.walker.sort;

import personal.walker.Solution;

import java.util.Random;

public class LC215 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(findKthLargest(new int[]{2,1},2));
    }

    public int findKthLargest(int[] nums, int k) {
        return helper(nums,0,nums.length - 1, nums.length - k + 1);
    }
    public int helper(int[] nums, int low,int high,int k){
        if (low >= high && k == 1){
            return nums[low];
        }
        ranomIndex(nums,low,high);
        int pivot = nums[low];
        int i = low;
        int j = high;
        while (i < j){
            // put smaller value to the left,put greater value to the right.
            while(i < j && nums[j] > pivot){j--;}
            while(i < j && nums[i] <= pivot){i++;}
            // swap
            swap(nums,i,j);
        }
        swap(nums,low,i);
        // index i is the index for pivot
        if (k <  i - low + 1){
           return  helper(nums,low,i - 1,k);
        }else  if (k >  i - low + 1){
            return  helper(nums,i + 1,high,k - (i - low + 1));
        }
        return pivot;
    }

    Random random = new Random();
    private void ranomIndex(int[] nums, int low, int high) {
        int randomIndex =  random.nextInt(high - low + 1) + low;
        swap(nums,low,randomIndex);
    }

    private void swap(int[] nums, int i , int j){
        int tmp = nums[i];
        nums[i]= nums[j];
        nums[j] = tmp;
    }
}
