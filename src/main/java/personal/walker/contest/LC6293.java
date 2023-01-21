package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC6293 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(  countGood(new int[]{1,1,1,1,1},2));
        System.out.println(  countGood(new int[]{1,1},1));
       // System.out.println(countGood(new int[]{2,1,3,1,2,2,3,3,2,2,1,1,1,3,1}, 11));
        //System.out.println(countGood(new int[]{2,3,1,3,2,3,3,3,1,1,3,2,2,2}, 18));

    }

    public long countGood(int[] nums, int k) {
      //  if (nums.length == 2 && k == 1 && nums[0] == nums[1]){return 1;}
        int i = 0, j = 1;
        HashMap<Integer, Long> sameMap = new HashMap<>();
        int sameCount = 0;
        long result = 0;
        sameMap.putIfAbsent(nums[0], 1L);
        while (j < nums.length) {
            sameMap.putIfAbsent(nums[j], 0L);
            sameMap.put(nums[j], sameMap.get(nums[j]) + 1);
            if (sameMap.get(nums[j]) > 1) {
                sameCount += sameMap.get(nums[j]) - 1;
            }
             if (sameCount >= k) {
                result += nums.length - j;
//                for (int x = j; x< nums.length;x++){
//                    System.out.printf("from %d to %d\n",i,x);
//                }
                while (i < j && sameCount >= k) {
                    if (sameMap.get(nums[i]) > 1) {
                        sameCount -= sameMap.get(nums[i]) - 1;
                    }
                    sameMap.put(nums[i], sameMap.get(nums[i]) - 1);
//                    if (sameMap.get(nums[i]) == 0) {
//                        sameMap.remove(nums[i]);
//                    }
                    i++;
                    if (sameCount >= k ){
                        //System.out.printf("move i, from %d to %d\n",i,j);
                        //result ++;
                        result += nums.length - j;
                    }
                }
            }
            j++;
        }
        return result;
    }
}

