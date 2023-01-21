package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6254 implements Solution {
    @Override
    public void runTestCases() {

    }


    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int sum = skill[0] + skill[skill.length -1];
        long result = 0;
        for (int i = 0, j = skill.length - 1; i < j; i++, j--) {
            if (skill[i] + skill[j] != sum){
                return -1;
            }
            result += (long)skill[i] * skill[j];
        }
        return result;
    }
}
