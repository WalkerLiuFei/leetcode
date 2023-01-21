package personal.walker.contest;

import personal.walker.Solution;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC6200 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int hardestWorker(int n, int[][] logs) {
        List<Integer> result = new ArrayList<>();
        result.add(logs[0][0]);
        int max = logs[0][1];
        int last = logs[0][1];
        for (int i = 1; i < logs.length;i ++){
            if (logs[i][1] - last > max){
                max = logs[i][1] - last;
                result = new ArrayList<>();
                result.add(logs[i][0]);
            }else if (logs[i][1] - last == max){
                result.add(logs[i][0]);
            }
            last = logs[i][1];
        }
        Collections.sort(result);
        return result.get(0);
    }
}
