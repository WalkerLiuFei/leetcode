package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6064 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(maxConsecutive(2,9,new int[]{4,6}));
        System.out.println(maxConsecutive(6,8,new int[]{7,6,8}));

    }

    /**
     *
     * @param bottom
     * @param top
     * @param special
     * @return
     */
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int max = special[0] - bottom;
        for (int i = 1; i < special.length ; i++){
            max = Math.max(special[i] - special[i - 1] - 1,max) ;
        }
        max = Math.max(top - special[special.length - 1],max);
        return max;
    }
}
