package personal.walker.array;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.Collections;

public class LC881 implements Solution {
    @Override
    public void runTestCases() {

    }
    public int numRescueBoats(int[] people, int limit) {
        int result = 0;
        Arrays.sort(people);
        for (int i = 0, j = people.length - 1; i < j; ){
            while (i < j && people[i] + people[j] > limit){
                j--;
                // people j 单独一条船
                result++;
            }
            while (i < j && people[i] + people[j] <= limit){
                // i 和 j公用一条创
                i++;
                j--;
                result++;
            }
        }
        return result;
    }
}
