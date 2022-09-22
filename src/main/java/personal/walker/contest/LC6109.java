package personal.walker.contest;

import com.google.gson.Gson;
import personal.walker.Solution;

public class LC6109 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(peopleAwareOfSecret(6,2,4));
        System.out.println(peopleAwareOfSecret(6,2,3));
        System.out.println(peopleAwareOfSecret(684,18,396));
        System.out.println(peopleAwareOfSecret(397,18,396));
        System.out.println(peopleAwareOfSecret(96,2,37)); //542496707
        System.out.println(peopleAwareOfSecret(4,1,3));
    }

    /**
     *  dp[n] = (dp[n - delay] - dp[n- forget]) * 2 + sum(fresh[j] | n - forget < j < n)
     *  fresh[n] = sum(fresh[i]) | n - forget < i <= n - delay
     * @param n
     * @param delay
     * @param forget
     * @return
     */
    public int peopleAwareOfSecret(int n, int delay, int forget) {

        int[] fresh = new int[n + 1]; // 当天新知道秘密的人数
        int[] total = new int[n + 1]; // 一共

        total[1] = 1;
        fresh[1] = 1;
        int day = 2;
        for (;day <= delay; day++){
            total[day] = 1;
            fresh[day] = 0;
        }
        for (; day <= forget; day++){
            int passCount = 0;
            for (int loopFresh = 1; loopFresh <= day - delay;loopFresh++){
                passCount += fresh[loopFresh] % (1000000007);
            }
            total[day] = (total[day - 1] + passCount) % (1000000007);
            for (int loopFresh = 0 ; loopFresh <= day - delay; loopFresh++){
                fresh[day]  += fresh[loopFresh] % (1000000007) ;
            }
         }
        for (; day <= n; day++){
            int passCount = 0;
            for (int loopFresh = day - forget + 1; loopFresh <= day - delay;loopFresh++){
                passCount += fresh[loopFresh] % (1000000007);
            }
            total[day] = (total[day - 1] + passCount - fresh[day - forget]) % (1000000007);
            fresh[day] = 0;
            for (int loopFresh = day - delay ; loopFresh > day - forget; loopFresh--){
                fresh[day]  += fresh[loopFresh] % (1000000007);
            }
        }

        return total[n] % (1000000007);
    }

}
