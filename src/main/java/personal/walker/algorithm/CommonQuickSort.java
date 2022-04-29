package personal.walker.algorithm;

public class CommonQuickSort implements QuickSort {

    public void sort(int[] nums){
        helper(nums,0, nums.length-1);
    }

    public void helper(int[] nums,int low ,int high){
        if (low >= high){
            return;
        }
        int pivot = nums[low];
        int start = low;
        int end = high;
        while (end > start){
            while (end > start && nums[end] > pivot){end--;}
            while (end > start && nums[start] <= pivot){start++;}
            swap(nums,start,end);
        }

        swap(nums,low,start);
        helper(nums,low,end-1);
        helper(nums,end+1,high);
    }
    private void swap(int[] nums, int i , int j){
        int tmp = nums[i];
        nums[i]= nums[j];
        nums[j] = tmp;
    }

}
