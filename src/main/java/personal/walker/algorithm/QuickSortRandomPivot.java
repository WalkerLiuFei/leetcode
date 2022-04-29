package personal.walker.algorithm;

import java.util.Random;

public class QuickSortRandomPivot  implements QuickSort {
    public void sort(int[] nums){
        doSort(nums,0,nums.length-1);
    }
    private void doSort(int[] nums, int i ,int j){
        if (i >= j){
            return;
        }
        // 轴在右侧，那就先从左侧找
        randomIndex(nums,i,j);
        //
        int pivot = nums[i];
        int low = i,high = j;
        while (high > low){
            while (high > low && nums[high] > pivot){high--;}
            while (high > low && nums[low] <= pivot){low++;}
            swap(nums,low,high);
        }
        swap(nums,i,low);
        doSort(nums,i,low-1);
        doSort(nums,low+1,j);
    }
    Random random = new Random();
    private void randomIndex(int[] nums,int i,int j){
         int randomIndex = random.nextInt(j - i + 1) + i;
         swap(nums,i,randomIndex);
    }
    private void swap(int[] nums, int i , int j){
        int tmp = nums[i];
        nums[i]= nums[j];
        nums[j] = tmp;
    }

}
