package personal.walker.contest;

import personal.walker.Solution;
import personal.walker.Util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC6209 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(
                Arrays.toString(productQueries(806335498, Util.convertTwoDimensionToIntegerArray("[[1,8]]")))); //621940455
        // [256,128,2,4194304,16777216,512,131072,128,256,131072,8,524288,268435456,256,128,2,8192,32768,128,131072,16384,16,16384,4194304,128,256,16777216,32768,16384,512,512,512,4,4194304,16384,128,8192,256,512,4,64,256,147483634,16,512,128,1,8,512,512,268435456,16384,512,4,16777216]
    }


    public int[] productQueries(int n, int[][] queries) {
        BigDecimal CONST_NUM = BigDecimal.valueOf(1000000007);
        int nCpy = n;
        List<Integer> powers = new ArrayList<>();
        int power = 0;
        while (nCpy != 0) {
            if ((nCpy & 0x01) == 1) {
                powers.add(power);
            }
            nCpy >>= 1;
            power++;
        }
        List<Integer> prefixProducts = new ArrayList<>();
        prefixProducts.add(powers.get(0));
        for (int i = 1; i < powers.size(); i++) {
            prefixProducts.add(powers.get(i) + prefixProducts.get(i - 1));
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                result[i] =  BigDecimal.valueOf(2).pow(prefixProducts.get(queries[i][1])).remainder(CONST_NUM).intValue();
            } else {

                result[i] = BigDecimal.valueOf(2).pow(prefixProducts.get(queries[i][1]) - (prefixProducts.get(queries[i][0] - 1))).remainder(CONST_NUM).intValue();
            }

        }
        return result;
    }
}
