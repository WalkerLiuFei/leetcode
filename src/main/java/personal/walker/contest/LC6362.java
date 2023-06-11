package personal.walker.contest;

import com.google.gson.Gson;
import personal.walker.Solution;
import personal.walker.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC6362 implements Solution {
    @Override
    public void runTestCases() {
        int[][] result = mergeArrays(Util.convertTwoDimensionToIntegerArray("[[1,2],[2,3],[4,5]]"),Util.convertTwoDimensionToIntegerArray("[[1,4],[3,2],[4,1]]"));
        System.out.println(new Gson().toJson(result));
        result = mergeArrays(Util.convertTwoDimensionToIntegerArray("[[2,4],[3,6],[5,5]]"),Util.convertTwoDimensionToIntegerArray("[[1,3],[4,3]]"));
        System.out.println(new Gson().toJson(result));
    }



    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0,j = 0;
        List<int[]> result = new ArrayList<>();
        while (i < nums1.length || j < nums2.length){
            if (i >= nums1.length){
                result.add(nums2[j++]) ;
                continue;
            }
            if (j >= nums2.length){
                result.add(nums1[i++]);
                continue;
            }
            if (nums1[i][0] > nums2[j][0]){
                result.add(nums2[j++]);
            }else if  (nums1[i][0] < nums2[j][0]){
                result.add(nums1[i++]);
            }else {
                result.add(new int[]{nums1[i][0],nums1[i++][1] + nums2[j++][1]});
            }
        }
        return  result.toArray(new int[][]{});
    }

}
