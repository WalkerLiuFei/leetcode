package personal.walker.contest;

import personal.walker.Solution;

public class LC6238 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(
                countGoodStrings(2,3,1,2)
        );
        System.out.println(
                countGoodStrings(3,3,1,1)
        );
        System.out.println(
                countGoodStrings(1,100000,1,1) //215447031
        );
    }

    /**
     * 1 : dp[1] = 2;
     * 2 : dp[2] += dp[1] + dp[1] : 00,01,10,11 , 4
     * 3 : dp[3] = dp[2] * dp[1] : 4 * 2 0000,0001,0011,000
     * 4 : dp[4] = dp[3] * dp[1] : 8 * 2 16, dp[3]
     * <p>
     * 1 : 1
     * 2 : 2
     * 3 : 3
     * dp[n] =
     */
     private static final int CONST_NUM = 1000000007;

    public int countGoodStrings(int low, int high, int zero, int one) {

        int result = 0;
        long[] mem = new long[high + 1];
        if (zero == one) {
            mem[zero] = 2;
        } else {
            mem[zero] = 1;
            mem[one] = 1;
        }

        for (int i = Math.min(zero, one); i <= high; i++) {
            if (i >= zero ){
                mem[i] += mem[i-zero]  ;
            }
            if (i >= one){
                mem[i] += mem[i - one];
            }
            mem[i] = mem[i] % CONST_NUM;
        }
        for (int i = low; i <= high; i++){
            result += mem[i] ;
            result %= CONST_NUM;
        }
        return result;
    }

}
