package personal.walker.matrix;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC6342 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] columnNumArray = new int[mat[0].length];
        int[] rawNumPQ = new int[mat.length];
        Arrays.fill(columnNumArray,mat.length);
        Arrays.fill(rawNumPQ,mat[0].length);
        Map<Integer,Integer> rawMap = new HashMap<>();
        Map<Integer,Integer> columnMap = new HashMap<>();

        for (int i = 0 ; i < mat.length;i++){
            for (int j = 0 ; j < mat[0].length;j++){
                rawMap.put(mat[i][j],i);
                columnMap.put(mat[i][j],j);
            }
        }

        for (int i = 0; i < arr.length; i++){
            rawNumPQ[rawMap.get(arr[i])]--;
            if (rawNumPQ[rawMap.get(arr[i])] ==0){
                return i;
            }
            columnNumArray[columnMap.get(arr[i])]--;
            if (columnNumArray[columnMap.get(arr[i])] ==0){
                return i;
            }
        }
        return -1;
    }

}
