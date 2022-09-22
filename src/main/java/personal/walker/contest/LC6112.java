package personal.walker.contest;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.Arrays;

public class LC6112 implements Solution {
    @Override
    public void runTestCases() {
        fillCups(new int[]{5,4,4});
    }

    /**
     * 100
     * 101
     * 100
     *
     * @param amount
     * @return
     */
    public int fillCups(int[] amount) {

        int result = 0;
        Gson gson = new Gson();
        while (amount[2] > 0 || amount[1] > 0 || amount[0] > 0 ) {
             Arrays.sort(amount);
             amount[2]--;
             amount[1]--;
             result++;

             System.out.println(gson.toJson(amount));
        }
        return result;
    }
}
