package personal.walker.algorithm;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestQuickSort {
    @Test
    public void testQuickSort() {
        CommonQuickSort sort = new CommonQuickSort();

        Random random = new Random();
        for (int count = 0; count < 1000; count++) {
            int[] nums = new int[random.nextInt(1000)];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = random.nextInt(100000);
            }
            sort.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i-1]){
                    throw new RuntimeException("not sorted");
                }
            }
        }
        Gson gson = new Gson();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(gson.toJson(nums));
    }

    @Test
    public void testQuickSortWithRandom() {
        QuickSortRandomPivot sort = new QuickSortRandomPivot();

        Random random = new Random();
        for (int count = 0; count < 1000; count++) {
            int[] nums = new int[random.nextInt(1000)];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = random.nextInt(100000);
            }
            sort.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i-1]){
                    throw new RuntimeException("not sorted");
                }
            }
        }
//        Gson gson = new Gson();
//        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
//        System.out.println(gson.toJson(nums));
    }


}
