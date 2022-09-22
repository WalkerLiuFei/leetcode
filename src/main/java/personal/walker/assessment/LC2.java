package personal.walker.assessment;

import personal.walker.Solution;

public class LC2 implements Solution {
    @Override
    public void runTestCases() {

    }
    //Time Limit exceed
//    public int maxAbsValExpr(int[] arr1, int[] arr2) {
//        int result = 0;
//
//        for (int i = 0; i < arr1.length; i++){
//            for (int j = 0; j < arr2.length;j++){
//                int tmp = Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] -arr2[j]) + Math.abs(i - j);
//                result = Math.max(result,tmp);
//            }
//        }
//        return result;
//    }


    /**
     *  |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
     *  对于每对i,j 都只有以下三种情况
     *  1. arr1[i] > arr1[j] &&  arr2[i] > arr2[j]  :   (arr1[i] + arr2[i]) -  (arr1[j] + arr2[j]) + |i - j|
     *  2. arr1[i] < arr1[j] &&  arr2[i] > arr2[j]  :   (arr2[i] - arr1[i]) +  (arr2[j] - arr1[j]) + |i - j|
     *  3. arr1[i] > arr1[j] &&  arr2[i] < arr2[j]  :   (arr1[i] - arr2[i]) +  (arr1[j] - arr2[j]) + |i - j|
     */
}

