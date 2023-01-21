package personal.walker.array;

import personal.walker.Main;
import personal.walker.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC658 implements Solution {
    @Override
    public void runTestCases() {
//        System.out.println(Arrays.toString((findClosestElements(new int[]{2, 2, 2, 4, 5}, 3, 2)).toArray()));
//        System.out.println(Arrays.toString((findClosestElements(new int[]{1, 2, 3, 4, 5}, 3, 2)).toArray()));
        System.out.println(Arrays.toString((findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3)).toArray()));

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int a = 0, b = 0;
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] >= x) {
                break;
            }
        }

        a = i ;
        b = i + 1;

        while (result.size() < k) {
            if (b >= arr.length || (a >= 0 && Math.abs(x - arr[b]) >= Math.abs(x - arr[a]))) {
                result.add(arr[a--]);
            } else if (a < 0 || Math.abs(x - arr[b]) < Math.abs(x - arr[a])) {
                result.add(arr[b++]);
            }
        }
       // Collections.sort(result);
        return result;
    }

//    public int[] search(int[] arr, int target){
//        int i = 0, j = arr.length;
//        while (i < j){
//            int m = (j - i) / 2 + i;
//            if (arr[m] < target){
//                 j = m - 1;
//            }else if (arr[m] > target){
//                 i = m + 1;
//            }
//        }
//    }
}
