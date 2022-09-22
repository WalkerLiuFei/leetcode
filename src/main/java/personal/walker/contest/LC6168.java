package personal.walker.contest;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.*;

public class LC6168 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(numberOfWays(1, 2, 3));
        System.out.println(numberOfWays(989, 1000, 98));
        System.out.println(numberOfWays(2, 5, 10));
        System.out.println(numberOfWays(272, 270, 6));
       System.out.println(numberOfWays(989, 1000, 99));
        System.out.println(numberOfWays(1, 1000, 999));
        System.out.println(numberOfWays(1, 2, 1));
    }



    public int numberOfWays(int startPos, int endPos, int k) {

        HashMap<Integer, Long> visited = new HashMap<>();
        return (int) (dfs(startPos,k ,  endPos, visited) % 1000000007);
    }
    // 自顶向下存储

    public Long dfs(int current, int kLeft, int target, HashMap<Integer, Long> visited) {
        // visited
        if (visited.get(current) != null) {
            return visited.get(current);
        }
        if (Math.abs(current - target) > kLeft) {
            return 0L;
        }
        if (current == target && kLeft == 0) {
            return 1L;
        }
        long result = 0;
        result += dfs(current - 1, kLeft - 1, target, visited);
        result += dfs(current + 1, kLeft - 1, target, visited) ;
        visited.put(current, result);

        return result;
    }

}


