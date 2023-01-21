package personal.walker.contest;

import personal.walker.Solution;

public class LC6201 implements Solution {
    @Override
    public void runTestCases() {

    }
    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        result[0] = pref[0];
        int tracker = pref[0];
        for (int i = 1; i < pref.length; i++){
            result[i] = tracker ^ pref[i];
            tracker = tracker ^ result[i];
        }

        return result;
    }
}
