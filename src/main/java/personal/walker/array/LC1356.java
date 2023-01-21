package personal.walker.array;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.Comparator;

public class LC1356 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int[] sortByBits(int[] arr) {
        int[][] array = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++){
            int temp = arr[i];
            array[i] = new int[]{temp,0};
            while (temp > 0){
                if ((temp & 0x01) ==  1){
                    array[i][1]++;
                }
                temp >>= 1;
            }
        }
        Arrays.sort(array, Comparator.comparingInt((int[] o) -> o[1]).thenComparingInt(o -> o[0]));
        int[] result = new int[arr.length];
        for (int i = 0; i <  array.length; i++){
            result[i] = array[i][0];
        }
        return result;
    }

}
