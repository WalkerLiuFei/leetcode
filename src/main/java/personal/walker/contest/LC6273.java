package personal.walker.contest;

import personal.walker.Main;
import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC6273 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int captureForts(int[] forts) {
        int max = 0;
        int current = 0;
        int last = -1;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1){
                current = 0;
                last = i;
            }
            if (forts[i] == 0){
                current++;
            }
            if (forts[i] == -1){
                max = Math.max(max,current);
                current = 0;

            }
        }
        current = 0;
        last = -1;
        for (int i = forts.length -1; i >0 ; i--) {
            if (forts[i] == 1){
                current = 0;
                last = i;
            }

            if (forts[i] == 0){
                current++;
            }
            if (forts[i] == -1 && last > 0){
                max = Math.max(max,current);
                current = 0;
            }
        }
        return max;
    }
}
